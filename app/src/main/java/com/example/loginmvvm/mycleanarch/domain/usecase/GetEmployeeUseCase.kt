package com.example.loginmvvm.mycleanarch.domain.usecase

import com.example.loginmvvm.mycleanarch.core.common.UiState
import com.example.loginmvvm.mycleanarch.data.repository.RepositoryImpl
import com.example.loginmvvm.mycleanarch.domain.model.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetEmployeeUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
 fun invoke() : Flow<UiState<List<Employee>>> = flow {
    emit(UiState.Loading())
    try{
        emit(UiState.Success(data = repositoryImpl.getEmployee()))

    }catch (e: Exception)
    {
        emit(UiState.Error(message = e.message.toString()))
    }
}.flowOn(Dispatchers.IO)
}