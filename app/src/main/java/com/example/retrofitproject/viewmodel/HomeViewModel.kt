package com.example.retrofitproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitproject.model.Todos
import com.example.retrofitproject.network.ApiInterface
import com.example.retrofitproject.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class HomeViewModel:ViewModel() {

    var todoLiveData = MutableLiveData<List<Todos>>()

    fun getApiData(){
        val retrofitService = RetrofitClient.getRetrofitInstance().create(ApiInterface::class.java)
        retrofitService.getData().enqueue(object : Callback<List<Todos>>{
            override fun onResponse(call: Call<List<Todos>>, response: Response<List<Todos>>) {
                //On success
                todoLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<Todos>>, t: Throwable) {
                //Failure
            }
        })

    }
}