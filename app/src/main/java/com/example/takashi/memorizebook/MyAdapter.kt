package com.example.takashi.memorizebook

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(activity: Activity, myDataset: Array<String?>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var mDataset = mutableListOf<String>()
    private var mActivity: Activity? = null

    init {
        mDataset = (myDataset as Array<String>).toMutableList()
        mActivity = activity
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.textView) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = mDataset[position]
        holder.mTextView.setOnClickListener {
            holder.mTextView.text = "remove"
            val intent = Intent(mActivity, SubActivity::class.java) as Intent
            mActivity!!.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}