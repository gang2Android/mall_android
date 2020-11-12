package com.gang.module_base.widget.flowview

import android.content.Context
import android.graphics.Canvas
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.gang.lib_base.LogUtils

class FlowGuideView : RelativeLayout {

    val views = ArrayList<FlowSurfaceView>()

    var curShowPosition: Int = -1

    var callBack: CallBack? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    fun addGuides(vararg resIds: Int) {
        resIds.iterator().withIndex().forEach {
            val flowView = FlowSurfaceView(context)
            views.add(flowView)
//            flowSurfaceView.setBackgroundColor(Color.WHITE)
            flowView.setImageResource(it.value)
            val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            flowView.layoutParams = layoutParams
            flowView.visibility = View.VISIBLE
//            flowView.scaleType = ImageView.ScaleType.FIT_XY
            flowView.setOnStateChangedListener(object :
                FlowSurfaceView.OnStateChangedListener {
                override fun onStateChanged(state: Int) {
                    if (state == STATE_EXPANDED) {
                        showNext()
                    } else if (state == STATE_MOVING) {
                        // hideNext()
                        // showNext()
                    } else {
                        hideNext()
                    }
                    if(curShowPosition + 2 == views.size && state == 2){
                        callBack?.end()
                    }
                }
            })
            addView(flowView)
        }
        Handler().postDelayed({
            views.iterator().withIndex().forEach {
                if (it.index == 0) {
                    it.value.showWithAnim()
                } else {
                    it.value.hideWithAnim()
                }
            }

            views[0].startExpandAnim()
        }, 500L)
    }

    fun open(){
        views[0].startExpandAnim()
    }

    private fun showNext() {
        if (curShowPosition + 1 < views.size) {
            curShowPosition += 1
            if (curShowPosition + 1 < views.size) {
                views[curShowPosition + 1].showWithAnim()
            }
        }
        Log.i(
            "pengyeah",
            "showNext=curShowPosition==>$curShowPosition====${curShowPosition + 1 < views.size}"
        )
    }

    private fun hideNext() {
        if (curShowPosition + 1 < views.size) {
            if (views[curShowPosition + 1].visibility == View.VISIBLE) {
                views[curShowPosition + 1].hideWithAnim()
            }
        }
        curShowPosition -= 1
        Log.i(
            "pengyeah",
            "hideNext=curShowPosition==>$curShowPosition====${curShowPosition + 1 < views.size}"
        )
    }

    interface CallBack {
        fun end()
    }

}