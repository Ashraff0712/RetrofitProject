package com.example.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.TodoAdapter.TodoAdapter
import com.example.retrofitproject.model.Todos
import com.example.retrofitproject.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTodoAPI()
    }

    fun initTodoAPI() {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        //call API
        homeViewModel.getApiData()

        //Observer
        homeViewModel.todoLiveData.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(data: List<Todos>) {
        val rvTodo: RecyclerView
        rvTodo = findViewById(R.id.rvTodo)

        rvTodo.layoutManager = LinearLayoutManager(this)
        val adapter = TodoAdapter(data)
        rvTodo.adapter = adapter

    }
}