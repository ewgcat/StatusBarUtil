package com.lishuaihua.statusbarutil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mListWidget: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        mListWidget!!.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayOf("沉浸式", "改变状态栏"))
        mListWidget!!.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val str = mListWidget!!.getItemAtPosition(position) as String
            if ("改变状态栏" == str) {
                startActivity(Intent(this@MainActivity, StatusBarChangeActivity::class.java))
            } else if ("沉浸式" == str) {
                startActivity(Intent(this@MainActivity, ImmersiveStatusBarActivity::class.java))
            }
        }
    }

    private fun initView() {
        mListWidget = findViewById<View>(R.id.list_widget) as ListView
    }
}