package com.example.retrofitproject.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitproject.model.Todos
import com.example.retrofitproject.network.ApiInterface
import com.example.retrofitproject.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object HomeActivityRepository {
    val albumData = MutableLiveData<List<Todos>>()
    val failureData = MutableLiveData<String>()
    fun getServicesApiCall():MutableLiveData<List<Todos>>{
        val retrofitService = RetrofitClient.getRetrofitInstance().create(ApiInterface::class.java)
        retrofitService.getData().enqueue(object : Callback<List<Todos>> {
            override fun onResponse(call: Call<List<Todos>>, response: Response<List<Todos>>) {
                //On success
                albumData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Todos>>, t: Throwable) {
                failureData.postValue("failed")
            }
        })
    return albumData
    }

}