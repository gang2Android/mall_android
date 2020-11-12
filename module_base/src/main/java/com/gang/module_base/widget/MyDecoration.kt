package com.gang.module_base.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gang.lib_base.LogUtils

class MyDecoration : RecyclerView.ItemDecoration() {
    private var space = 0
    fun setSpace(space: Int) {
        this.space = space
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val p = parent.getChildAdapterPosition(view)
        if(p==0){
            outRect.left = 0
            outRect.right = 0
            outRect.top = 0
            outRect.bottom = 0
        }else{
            outRect.left = space
            outRect.right = space
            outRect.top = space
            outRect.bottom = space
            LogUtils.print("p=$p")
        }
    }
}