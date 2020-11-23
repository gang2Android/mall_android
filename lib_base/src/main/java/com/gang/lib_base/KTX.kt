package com.gang.lib_base

import android.transition.Transition
import android.transition.TransitionSet

fun TransitionSet.onEnd(callback: () -> Unit) {
    val listener = object : Transition.TransitionListener {
        override fun onTransitionEnd(transition: Transition?) {
            LogUtils.print("onTransitionEnd")
            callback()
        }

        override fun onTransitionResume(transition: Transition?) {
            LogUtils.print("onTransitionResume")
        }

        override fun onTransitionPause(transition: Transition?) {
            LogUtils.print("onTransitionPause")
        }

        override fun onTransitionCancel(transition: Transition?) {
            LogUtils.print("onTransitionCancel")
        }

        override fun onTransitionStart(transition: Transition?) {
            LogUtils.print("onTransitionStart")
        }

    }

    addListener(listener)


}
