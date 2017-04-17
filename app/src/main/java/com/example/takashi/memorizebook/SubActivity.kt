package com.example.takashi.memorizebook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.content.res.AssetManager

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle(intent.getStringExtra("FileName"))
        println(read_file("sample.csv"))
    }
    fun read_file(FileName: String): List<String> = getResources().getAssets().open(FileName).reader().readLines()
}
