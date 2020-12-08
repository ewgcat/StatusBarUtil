package com.lishuaihua.statusbarutil

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class ImmersiveStatusBarActivity : AppCompatActivity() {
    private var mToolBar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_immersive_status_bar)
        initView()
    }

    private fun initView() {
        mToolBar = findViewById<View>(R.id.tool_bar) as Toolbar
        mToolBar!!.setNavigationIcon(R.mipmap.icon_title_return)
        //设置支持toolbar
        //设置支持toolbar
        setSupportActionBar(mToolBar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
        //返回按钮点击事件
        //返回按钮点击事件
        mToolBar?.setNavigationOnClickListener(View.OnClickListener { finish() })
    }

}