package com.gang.gang2020

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openDY(view: View) {
        val intent = Intent()
        intent.data = Uri.parse("snssdk2329://user/profile/105069675259")
//        intent.data = Uri.parse("snssdk0://")
        startActivity(intent)
    }
}
