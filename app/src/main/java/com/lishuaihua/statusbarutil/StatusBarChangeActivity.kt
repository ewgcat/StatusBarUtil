package com.lishuaihua.statusbarutil

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.android_status_util.Eyes


class StatusBarChangeActivity : AppCompatActivity(), View.OnClickListener {
    /**
     * status_blue
     */
    private var mBtnStatusBlue: Button? = null

    /**
     * status_red
     */
    private var mBtnStatusRed: Button? = null

    /**
     * status_while
     */
    private var mBtnStatusWhile: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_change_bar)
        initView()
    }

    private fun initView() {
        mBtnStatusBlue = findViewById<View>(R.id.btn_status_blue) as Button
        mBtnStatusBlue!!.setOnClickListener(this)
        mBtnStatusRed = findViewById<View>(R.id.btn_status_red) as Button
        mBtnStatusRed!!.setOnClickListener(this)
        mBtnStatusWhile = findViewById<View>(R.id.btn_status_while) as Button
        mBtnStatusWhile!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_status_blue -> com.lishuaihua.android_status_util.Eyes.setStatusBarLightMode(this, Color.BLUE)
            R.id.btn_status_red -> com.lishuaihua.android_status_util.Eyes.setStatusBarLightMode(this, Color.RED)
            R.id.btn_status_while -> com.lishuaihua.android_status_util.Eyes.setStatusBarLightMode(this, Color.WHITE)
            else -> {
            }
        }
    }
}