package com.example.takashi.memorizebook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {
    private var myDataset = arrayOfNulls<String>(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle("This is title")
        setSupportActionBar(toolbar)
        val mRecyclerView = findViewById(R.id.recyclerview) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager
        for (i in 0..myDataset.size - 1) {
            myDataset[i] = "Data_0" + i.toString()
        }
        val mAdapter = MyAdapter(this, myDataset)
        mRecyclerView.adapter = mAdapter
        println(book_list())
    }

    fun book_list(): List<String> = getResources().getAssets().list("").filter { File(it).extension == "csv" }
}