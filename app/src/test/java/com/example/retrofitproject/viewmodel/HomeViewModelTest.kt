package com.example.retrofitproject.viewmodel

import HomeViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.retrofitproject.Repository.HomeActivityRepository
import com.example.retrofitproject.model.Todos
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    lateinit var model: HomeViewModel

    @MockK
    lateinit var homeActivityRepository: HomeActivityRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Before
    fun setUp() {

        MockKAnnotations.init(this, relaxUnitFun = true)
        model = HomeViewModel()
        model.setHomeRepository(homeActivityRepository)
    }

    @Test
    fun `test API call`() {
        every { homeActivityRepository.getServicesApiCall() } returns MutableLiveData<List<Todos>>().apply {
            postValue(listOf((Todos(
                "fdsgf","4","true"
            ))))
        }
        model.getServicesAPICall()
        Assert.assertEquals(
            model.todoLiveData?.value, listOf(Todos(
                "fdsgf","4","true"
            )))
    }
}