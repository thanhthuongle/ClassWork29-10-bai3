package com.example.classwork29_10_bai3

import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.classwork29_10_bai3.Adapters.StudentAdapter
import com.example.classwork29_10_bai3.Models.StudentModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            mapOf("name" to "Lê Trọng Bảo An", "mssv" to "20215295"),
            mapOf("name" to "Hoàng Kỳ Anh", "mssv" to "20210068"),
            mapOf("name" to "Nguyễn Thuý Anh", "mssv" to "20215306"),
            mapOf("name" to "Quách Hữu Tùng Anh", "mssv" to "20215311"),
            mapOf("name" to "Trần Minh Chiến", "mssv" to "20215321"),
            mapOf("name" to "Nguyễn Quốc Dũng", "mssv" to "20215329"),
            mapOf("name" to "Nguyễn Hoàng Dương", "mssv" to "20215337"),
            mapOf("name" to "Nguyễn Thành Đạt", "mssv" to "20215344"),
            mapOf("name" to "Vũ Hải Đăng", "mssv" to "20215347"),
            mapOf("name" to "Đinh Nhẫn Đức", "mssv" to "20215350"),
            mapOf("name" to "Nguyễn Trọng Đức", "mssv" to "20215356"),
            mapOf("name" to "Nguyễn Đức Hải", "mssv" to "20210313"),
            mapOf("name" to "Nguyễn Phúc Hiệp", "mssv" to "20215367"),
            mapOf("name" to "Phạm Trung Hiếu", "mssv" to "20215374"),
            mapOf("name" to "Lục Minh Hoàng", "mssv" to "20215379"),
            mapOf("name" to "Nguyễn Việt Hoàng", "mssv" to "20215384"),
            mapOf("name" to "Nguyễn Vũ Hùng", "mssv" to "20210400"),
            mapOf("name" to "Hoàng Nguyễn Huy", "mssv" to "20215393"),
            mapOf("name" to "Nhuien Tkhi Kam Tu", "mssv" to "20210988"),
            mapOf("name" to "Lie Min Kyonh", "mssv" to "20210989"),
            mapOf("name" to "Trần Quang Khải", "mssv" to "20215401"),
            mapOf("name" to "Phạm Đăng Khuê", "mssv" to "20215406"),
            mapOf("name" to "Nguyễn Hoàng Lâm", "mssv" to "20210515"),
            mapOf("name" to "Tô Thái Linh", "mssv" to "20215414"),
            mapOf("name" to "Bùi Anh Minh", "mssv" to "20215422"),
            mapOf("name" to "Hoàng Trọng Minh", "mssv" to "20215427"),
            mapOf("name" to "Nguyễn Văn Nam", "mssv" to "20210618"),
            mapOf("name" to "Phạm Thị Thúy Ngần", "mssv" to "20215437"),
            mapOf("name" to "Lê Hà Phi", "mssv" to "20215443"),
            mapOf("name" to "Thẩm Lập Phong", "mssv" to "20215449"),
            mapOf("name" to "Hà Vĩnh Phước", "mssv" to "20215455"),
            mapOf("name" to "Hứa Hành Quân", "mssv" to "20215464"),
            mapOf("name" to "Trương Đình Văn Quyền", "mssv" to "20215467"),
            mapOf("name" to "Trần Cao Sơn", "mssv" to "20215472"),
            mapOf("name" to "Nguyễn Duy Tấn", "mssv" to "20215478"),
            mapOf("name" to "Phạm Đình Tú", "mssv" to "20210888"),
            mapOf("name" to "Nguyễn Quang Tuyến", "mssv" to "20215510"),
            mapOf("name" to "Lê Thanh Thương", "mssv" to "20215485"),
            mapOf("name" to "Lương Đức Trọng", "mssv" to "20215489"),
            mapOf("name" to "Nguyễn Văn Trường", "mssv" to "20215496"),
            mapOf("name" to "Lý Quang Vũ", "mssv" to "20215517")
        )
        val students = mutableListOf<StudentModel>()
        for (student in data) {
            students.add(StudentModel(student["name"]!!, student["mssv"]!!))
        }

        var studentRender = students
        var adapter = StudentAdapter(studentRender)
        val listStudents = findViewById<ListView>(R.id.list_students)
        listStudents.adapter = adapter

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setIconifiedByDefault(false)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val query = newText.trim().replace("\\s+".toRegex(), " ")
                if (newText != null && newText.length > 2) {
                    studentRender = students.filter { it.name.contains(query, ignoreCase = true) || it.mssv.contains(query, ignoreCase = true) }.toMutableList()
                    adapter = StudentAdapter(studentRender)
                } else{
                    adapter = StudentAdapter(students)
                }    
                listStudents.adapter = adapter
                return true
            }
        })
    }
}