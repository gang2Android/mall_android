package com.gang.module_goods.det.spec

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gang.lib_base.LogUtils
import com.gang.module_goods.R


class SpecFragment : DialogFragment() {

    private var rootView: View? = null

    private var recyclerView: RecyclerView? = null
    private var adapter: SpecAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.goods_fragment_det_spec, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val window = dialog?.window ?: return
        window.setBackgroundDrawable(ColorDrawable(0x00000000))
        window.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

    override fun onStart() {
        super.onStart()
        initParams()

        initView()
    }

    private fun initParams() {
        val window = dialog?.window ?: return
        val dimAmount = 0.5f
        val animStyle = R.style.SpecAnimation

        val lp = window.attributes
        lp.dimAmount = dimAmount
        lp.gravity = Gravity.BOTTOM
        lp.width = resources.displayMetrics.widthPixels
        lp.height = (resources.displayMetrics.heightPixels * 0.8).toInt()

        window.setWindowAnimations(animStyle)
        window.attributes = lp
    }

    private fun initView() {
        recyclerView = rootView!!.findViewById(R.id.spec_rv)

        recyclerView!!.layoutManager = LinearLayoutManager(requireContext())

        adapter = SpecAdapter()
        recyclerView!!.adapter = adapter
        val data = mutableListOf<SpecBean>()
        data.add(SpecBean("id1"))
        data.add(SpecBean("id2"))
        data.add(SpecBean("id3"))
        adapter?.setNewInstance(data)

        adapter?.setCallBack(object : SpecCallBack {
            override fun tagCall(adapterPosition: Int, tagPosition: Int) {
                LogUtils.print("tagCall-adapterPosition=${adapterPosition},tagPosition=${tagPosition}")
            }
        })
    }

}