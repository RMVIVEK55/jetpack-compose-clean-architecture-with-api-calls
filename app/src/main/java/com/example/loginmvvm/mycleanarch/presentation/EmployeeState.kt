package com.example.loginmvvm.mycleanarch.presentation

import com.example.loginmvvm.mycleanarch.domain.model.Employee

data class EmployeeState(
    val isLoading: Boolean = false,
    val data : List<Employee>? = null,
    val error: String =""
)