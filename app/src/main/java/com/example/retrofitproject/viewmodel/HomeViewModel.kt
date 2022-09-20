package com.example.retrofitproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitproject.Repository.HomeActivityRepository
import com.example.retrofitproject.model.Todos


class HomeViewModel:ViewModel() {

    var todoLiveData = MutableLiveData<List<Todos>>()

    fun getApiData():LiveData<List<Todos>>{
        todoLiveData = HomeActivityRepository.getServicesApiCall()
        return todoLiveData
    }
}