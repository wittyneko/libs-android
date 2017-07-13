package cn.wittyneko.anim

import android.animation.*
import android.view.animation.LinearInterpolator

/**
 * Created by wittyneko on 2017/7/6.
 */

open class AnimSet : ValueAnim() {

    companion object {

        fun ofInt(vararg values: Int): ValueAnim {
            val anim = AnimSet()
            anim.setIntValues(*values)
            return anim
        }

        fun ofArgb(values: IntArray): ValueAnim {
            val anim = AnimSet()
            anim.setIntValues(*values)
            anim.setEvaluator(argbEvaluator)
            return anim
        }

        fun ofFloat(vararg values: Float): ValueAnim {
            val anim = AnimSet()
            anim.setFloatValues(*values)
            return anim
        }

        fun ofPropertyValuesHolder(vararg values: PropertyValuesHolder): ValueAnim {
            val anim = AnimSet()
            anim.setValues(*values)
            return anim
        }

        fun ofObject(evaluator: TypeEvaluator<*>, vararg values: Any): ValueAnimator {
            val anim = AnimSet()
            anim.setObjectValues(*values)
            anim.setEvaluator(evaluator)
            return anim
        }

    }

    var childAnimSet: HashSet<AnimWrapper> = hashSetOf()

    init {
        interpolator = LinearInterpolator()
    }

    /**
     * 计算子动画播放时间
     * @param delayed 子动画延迟时间
     * @param duration 子动画时长
     *
     * @return 子动画当前播放时间
     */
    fun animChildPlayTime(delayed: Long, duration: Long): Long {
        var childPlayTime = animCurrentPlayTime - delayed
        when {
            childPlayTime < delayed -> {
                childPlayTime = 0
            }
            childPlayTime > duration -> {
                childPlayTime = duration
            }
        }
        return childPlayTime
    }

    /**
     * 添加子动画
     * @param childAnim 子动画
     * @param delayed 子动画延迟时间
     * @param tag 子动画tag标签
     */
    fun addChildAnim(childAnim: ValueAnimator, delayed: Long, tag: String = AnimWrapper.EMPTY_TAG) {
        addChildAnim(AnimWrapper(childAnim, delayed, tag))
    }

    /**
     * 添加子动画
     * @param child 子动画包装类
     */
    fun addChildAnim(child: AnimWrapper) {
        childAnimSet.add(child)
    }

    override fun onAnimationUpdate(animation: ValueAnimator?) {
        super.onAnimationUpdate(animation)

        //遍历刷新子动画
        childAnimSet.forEach {
            it.anim.currentPlayTime = animChildPlayTime(it.delayed, it.anim.duration)
        }
    }

    override fun onAnimationEnd(animation: Animator?) {
        super.onAnimationEnd(animation)

        //遍历结束子动画
        childAnimSet.forEach {
            it.anim.currentPlayTime = animChildPlayTime(it.delayed, it.anim.duration)
        }
    }

    /**
     * 子动画包装类
     */
    class AnimWrapper(
            var anim: ValueAnimator,
            var delayed: Long,
            var tag: String = AnimWrapper.EMPTY_TAG) {
        companion object {
            val EMPTY_TAG = ""
        }
    }
}