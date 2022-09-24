package com.example.retrofitproject

import HomeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.Repository.HomeActivityRepository
import com.example.retrofitproject.TodoAdapter.TodoAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvTodo)
        progressBar = findViewById(R.id.progressBar)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.setHomeRepository(HomeActivityRepository())
        setUpList()
    }

    private fun setUpList() {
        progressBar.visibility = View.VISIBLE
        homeViewModel.getServicesAPICall().observe(this, Observer { todos ->
            progressBar.visibility = View.GONE
            val albumAdapter = TodoAdapter(todos)
            val layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = albumAdapter

        })
        homeViewModel.getFailure()?.observe(this, Observer {
            //do failure action
        })
    }

}