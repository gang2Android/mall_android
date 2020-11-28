package com.gang.module_base.widget

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.gang.module_base.R

class AmountView : LinearLayout, View.OnClickListener {
    private var amount = 1 //购买数量
    private val goodsStorage = 100 //商品库存

    private var tvAmount: TextView? = null
    private var btnDecrease: Button? = null
    private var btnIncrease: Button? = null

    private var changeListener: ChangeListener? = null

    fun setOnChangeListener(changeListener: ChangeListener) {
        this.changeListener = changeListener
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.base_layout_amount, this);

        tvAmount = findViewById(R.id.tvAmount)
        btnDecrease = findViewById(R.id.btnDecrease)
        btnIncrease = findViewById(R.id.btnIncrease)
        btnDecrease?.setOnClickListener(this)
        btnIncrease?.setOnClickListener(this)

        val btnWidth = 150
        val tvWidth = 120
        val tvTextSize = 0
        val btnTextSize = 0

        val btnParams = LayoutParams(btnWidth, LayoutParams.MATCH_PARENT)
        btnDecrease?.layoutParams = btnParams
        btnIncrease?.layoutParams = btnParams
        if (btnTextSize != 0) {
            btnDecrease?.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize.toFloat())
            btnIncrease?.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize.toFloat())
        }

        val textParams = LayoutParams(tvWidth, LayoutParams.MATCH_PARENT)
        tvAmount?.layoutParams = textParams
        if (tvTextSize != 0) {
            tvAmount?.textSize = tvTextSize.toFloat()
        }
    }

    override fun onClick(v: View?) {
        val i = v!!.id
        if (i == R.id.btnDecrease) {
            if (amount > 1) {
                amount--
                tvAmount!!.text = "$amount"
            }
        } else if (i == R.id.btnIncrease) {
            if (amount < goodsStorage) {
                amount++
                tvAmount!!.text = "$amount"
            }
        }
        changeListener?.amount(amount)
    }

    interface ChangeListener {
        fun amount(amount: Int)
    }
}