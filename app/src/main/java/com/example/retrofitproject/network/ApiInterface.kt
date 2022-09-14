package com.example.retrofitproject.network

import com.example.retrofitproject.model.Todos
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/todos")
    fun getData(): Call<List<Todos>>
}