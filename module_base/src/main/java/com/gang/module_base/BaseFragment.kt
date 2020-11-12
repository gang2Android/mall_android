package com.gang.module_base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gang.lib_base.LogUtils

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtils.print("onAttach", tag = javaClass.simpleName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.print("onCreate", tag = javaClass.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtils.print("onCreateView", tag = javaClass.simpleName)
        return getRootView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.print("onViewCreated", tag = javaClass.simpleName)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogUtils.print("onActivityCreated", tag = javaClass.simpleName)
        initView()
        initListener()
        initOther()
    }

    override fun onStart() {
        super.onStart()
        LogUtils.print("onStart", tag = javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        LogUtils.print("onResume", tag = javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        LogUtils.print("onPause", tag = javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        LogUtils.print("onStop", tag = javaClass.simpleName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.print("onDestroyView", tag = javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.print("onDestroy", tag = javaClass.simpleName)
    }

    override fun onDetach() {
        super.onDetach()
        LogUtils.print("onDetach", tag = javaClass.simpleName)
    }

    abstract fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    abstract fun initView()

    abstract fun initListener()

    abstract fun initOther()

}