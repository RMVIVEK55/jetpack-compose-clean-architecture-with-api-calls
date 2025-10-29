package com.example.loginmvvm.cleanllogin_without_api_di.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.cleanllogin_without_api_di.domain.usecase.LoginUsecase
import com.example.loginmvvm.cleanllogin_without_api_di.presentation.viewmodel.LoginNoAPIViewmodel

class MyViewModelFactory(private val dataRepository: LoginUsecase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginNoAPIViewmodel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginNoAPIViewmodel(dataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}