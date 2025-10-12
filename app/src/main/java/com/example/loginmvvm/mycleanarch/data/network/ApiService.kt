package com.example.loginmvvm.mycleanarch.data.network

import com.example.loginmvvm.mycleanarch.domain.model.Employee
import com.example.loginmvvm.mycleanarch.utils.Constant.SUB_URL
import retrofit2.http.GET

interface ApiService {
    @GET(SUB_URL)
    suspend fun getAllEmployee() : List<Employee>

}