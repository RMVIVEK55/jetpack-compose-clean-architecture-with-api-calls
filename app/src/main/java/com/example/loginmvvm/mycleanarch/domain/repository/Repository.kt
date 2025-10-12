package com.example.loginmvvm.mycleanarch.domain.repository

import com.example.loginmvvm.mycleanarch.domain.model.Employee

interface Repository {
    suspend fun getEmployee() : List<Employee>
}