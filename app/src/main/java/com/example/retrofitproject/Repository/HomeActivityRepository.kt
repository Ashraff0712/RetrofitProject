package com.example.retrofitproject.Repository

import androidx.lifecycle.MutableLiveData
import com.deloitte.retrofitdemo.retrofit.RetrofitClient
import com.example.retrofitproject.model.Todos

import retrofit2.Call
import retrofit2.Response

class HomeActivityRepository {

    val todoData = MutableLiveData<List<Todos>>()
    val failureData = MutableLiveData<String>()

    fun getServicesApiCall(): MutableLiveData<List<Todos>> {
        val call = RetrofitClient.apiInterface.getData()

        call.enqueue(object : retrofit2.Callback<List<Todos>>{
            override fun onResponse(call: Call<List<Todos>>, response: Response<List<Todos>>) {
                todoData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Todos>>, t: Throwable) {
                failureData.postValue("failed")
            }


        })
        return todoData
    }
}