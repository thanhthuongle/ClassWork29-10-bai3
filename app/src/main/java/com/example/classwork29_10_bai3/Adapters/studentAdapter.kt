package com.example.classwork29_10_bai3.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.classwork29_10_bai3.Models.StudentModel
import com.example.classwork29_10_bai3.R

class StudentAdapter(val students: List<StudentModel>): BaseAdapter() {

    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(p0: Int): Any {
        return students[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView: View
        val viewHolder: ViewHolder
        if (p1 == null) {
            itemView = LayoutInflater.from(p2?.context)
                .inflate(R.layout.layout_item, p2, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = p1
            viewHolder = itemView.tag as ViewHolder
        }

        val student = students[p0]
        viewHolder.textName.text = student.name
        viewHolder.textMssv.text = student.mssv

        return itemView
    }

    class ViewHolder(itemView: View) {
        val textName: TextView
        val textMssv: TextView
        init {
            textName = itemView.findViewById(R.id.text_hoten)
            textMssv = itemView.findViewById(R.id.text_mssv)
        }
    }
}
