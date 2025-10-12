package com.example.loginmvvm.mycleanarch.domain.di

import com.example.loginmvvm.mycleanarch.data.repository.RepositoryImpl
import com.example.loginmvvm.mycleanarch.domain.usecase.GetEmployeeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun employeeUSeCaseProvider(repositoryImpl: RepositoryImpl): GetEmployeeUseCase{
        return GetEmployeeUseCase(repositoryImpl)
    }
}