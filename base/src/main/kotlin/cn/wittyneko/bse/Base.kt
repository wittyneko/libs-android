package cn.wittyneko.base

import android.app.Application
import android.content.Context

import java.lang.reflect.Method


/**
 * 初始化
 * Created by wittyneko .
 * @since 2017/4/18
 */
object Base {

    var isDebug: Boolean = false

    private var _application: Application? = null
    val application: Application?
        get() {
            if (_application == null) {
                try {
                    // 在IDE进行布局预览时使用
                    val renderActionClass = Class.forName("com.android.layoutlib.bridge.impl.RenderAction")
                    val method = renderActionClass.getDeclaredMethod("getCurrentContext")
                    val context = method.invoke(null) as Context
                    _application =   MockApplication(context)
                } catch (ignored: Throwable) {
                    throw RuntimeException("please invoke Base.init(application) on Application#onCreate()" + " and register your Application in manifest.")
                }

            }
            return _application
        }


    fun init(application: Application) {
        if (_application == null) {
            _application = application
        }
    }

    private class MockApplication(baseContext: Context) : Application() {
        init {
            this.attachBaseContext(baseContext)
        }
    }
}
