package com.example.loginmvvm.mycleanarch.data.repository

import com.example.loginmvvm.mycleanarch.domain.model.Employee
import com.example.loginmvvm.mycleanarch.data.network.ApiService
import com.example.loginmvvm.mycleanarch.domain.repository.Repository
import jakarta.inject.Inject

class RepositoryImpl @Inject constructor(private val apiservice : ApiService): Repository{
    override suspend fun getEmployee(): List<Employee> {
       return apiservice.getAllEmployee()
    }

}