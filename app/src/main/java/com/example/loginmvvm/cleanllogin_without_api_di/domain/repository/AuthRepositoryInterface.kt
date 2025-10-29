package com.example.loginmvvm.cleanllogin_without_api_di.domain.repository

import com.example.loginmvvm.cleanllogin_without_api_di.domain.entity.AuthToken
import com.example.loginmvvm.mycleanarch.core.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlin.jvm.Throws

interface AuthRepositoryInterface {
    suspend fun saveToken(token: AuthToken)
    suspend fun getAuthToken(): AuthToken
    suspend fun login(username: String,password: String): Flow<UiState<String>>

}