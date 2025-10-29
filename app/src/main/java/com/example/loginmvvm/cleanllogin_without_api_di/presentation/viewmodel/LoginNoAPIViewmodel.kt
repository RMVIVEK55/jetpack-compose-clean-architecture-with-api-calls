package com.example.loginmvvm.cleanllogin_without_api_di.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginmvvm.cleanllogin_without_api_di.domain.entity.AuthToken

import com.example.loginmvvm.cleanllogin_without_api_di.domain.usecase.LoginUsecase
import com.example.loginmvvm.mycleanarch.core.common.UiState
import kotlinx.coroutines.launch


class LoginNoAPIViewmodel(val loginUsecase: LoginUsecase): ViewModel() {
  private var _password = mutableStateOf("")
    var password : State<String> = _password

    private var _userName =mutableStateOf("")
    var userName : State<String> = _userName

    fun getLogin(userName: String,password: String)
    {
        viewModelScope.launch() {
            _userName.value = userName
            _password.value = password
            loginUsecase.invoke(userName, password).collect {
                when (it) {
                    is UiState.Error<*> -> {

                        Log.e("vivek", "err")
                    }

                    is UiState.Loading<*> -> {
                        Log.e("vivek", "load")
                    }

                    is UiState.Success<*> -> {
                        Log.e("vivek", "succ")

                    }
                }
            }
        }
    }

}