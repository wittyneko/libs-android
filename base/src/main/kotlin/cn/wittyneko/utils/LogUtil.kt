/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.wittyneko.base

import android.util.Log

/**
 * Log工具，android.util.Log包装。
 * tag默认填写，msg加入行数显示
 */
object LogUtil {

    var tagPrefix = "logs" // Log Tag
    var isDebug = true
    private val space = "-> " // Log msg 间隔符

    private val tag: String
        get() {
            //return "$tagPrefix ${trace(3)}"
            return tagPrefix
        }

    private val trace: String
        get() = trace(3)

    private fun trace(index: Int): String {
        val caller = Throwable().stackTrace[index]

        // 1. 类名 + 方法名
        //val callerClazzName = caller.className
        //val callerClazzName = callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        //var template = "${callerClazzName}.${caller.methodName}(${caller.fileName}:${caller.lineNumber})"

        // 2. 方法名

        var template = "${caller.methodName}(${caller.fileName}:${caller.lineNumber})"
        return template
    }

    fun d(content: String) {
        if (!isDebug) return

        Log.d(tag, "$trace $space $content")
    }

    fun d(content: String, tr: Throwable) {
        if (!isDebug) return

        Log.d(tag, "$trace $space $content", tr)
    }

    fun e(content: String) {
        if (!isDebug) return

        Log.e(tag, "$trace $space $content")
    }

    fun e(content: String, tr: Throwable) {
        if (!isDebug) return

        Log.e(tag, "$trace $space $content", tr)
    }

    fun i(content: String) {
        if (!isDebug) return

        Log.i(tag, "$trace $space $content")
    }

    fun i(content: String, tr: Throwable) {
        if (!isDebug) return

        Log.i(tag, "$trace $space $content", tr)
    }

    fun v(content: String) {
        if (!isDebug) return

        Log.v(tag, "$trace $space $content")
    }

    fun v(content: String, tr: Throwable) {
        if (!isDebug) return

        Log.v(tag, "$trace $space $content", tr)
    }

    fun w(content: String) {
        if (!isDebug) return

        Log.w(tag, "$trace $space $content")
    }

    fun w(content: String, tr: Throwable) {
        if (!isDebug) return

        Log.w(tag, "$trace $space $content", tr)
    }

    fun w(tr: Throwable) {
        if (!isDebug) return

        //Log.w(tag, getTrace() + space +tr);
        Log.w(tag, "$trace $space", tr)
    }


    fun wtf(content: String) {
        if (!isDebug) return

        Log.wtf(tag, "$trace $space $content")
    }

    fun wtf(content: String, tr: Throwable) {
        if (!isDebug) return

        Log.wtf(tag, "$trace $space $content", tr)
    }

    fun wtf(tr: Throwable) {
        if (!isDebug) return

        //Log.wtf(tag, getTrace() + space +tr);
        Log.wtf(tag, "$trace $space", tr)
    }

}
