package com.example.loginmvvm.cleanllogin_without_api_di.domain.usecase

import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginmvvm.cleanllogin_without_api_di.data.repository.AuthRepositoryImpl
import com.example.loginmvvm.cleanllogin_without_api_di.domain.entity.AuthToken
import com.example.loginmvvm.cleanllogin_without_api_di.domain.repository.AuthRepositoryInterface
import com.example.loginmvvm.mycleanarch.core.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList

data class LoginUsecase(val authRepositoryImpl: AuthRepositoryImpl) {
        suspend  operator fun invoke(userName: String,password: String): Flow<UiState<String>> {
          val result= authRepositoryImpl.login(username = userName, password = password)
            if(result.toList().firstOrNull() is UiState.Success<*>)
            {
                authRepositoryImpl.saveToken(AuthToken(""))
            }else{
                authRepositoryImpl.saveToken(AuthToken(null))
            }
          return   result
              }
               }