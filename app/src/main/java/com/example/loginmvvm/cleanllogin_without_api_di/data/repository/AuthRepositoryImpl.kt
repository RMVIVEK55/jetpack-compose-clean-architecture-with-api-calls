package com.example.loginmvvm.cleanllogin_without_api_di.data.repository

import com.example.loginmvvm.cleanllogin_without_api_di.data.preference_manager.LoginPreference
import com.example.loginmvvm.cleanllogin_without_api_di.domain.entity.AuthToken
import com.example.loginmvvm.cleanllogin_without_api_di.domain.repository.AuthRepositoryInterface
import com.example.loginmvvm.mycleanarch.core.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Response

class AuthRepositoryImpl( val loginPreference: LoginPreference): AuthRepositoryInterface{

    override suspend fun saveToken(token: AuthToken) {
       loginPreference.authToken =token.token?:""
    }

    override suspend fun getAuthToken(): AuthToken {
       return AuthToken(loginPreference.authToken)
    }

    override suspend fun login(username: String, password: String): Flow<UiState<String>> {
       return flow {
           if(username == "login" && password == "200")
           {
               emit(UiState.Success("200"))
           }else{
               emit(UiState.Error("LoginFailed","error"))
           }
       }
      }
      }





