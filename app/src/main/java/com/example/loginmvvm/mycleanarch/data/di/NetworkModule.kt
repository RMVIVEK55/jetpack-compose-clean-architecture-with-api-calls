package com.example.loginmvvm.mycleanarch.data.di

import com.example.loginmvvm.mycleanarch.data.network.ApiService
import com.example.loginmvvm.mycleanarch.data.repository.RepositoryImpl
import com.example.loginmvvm.mycleanarch.domain.repository.Repository
import com.example.loginmvvm.mycleanarch.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent ::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerRepositoryImpl(apiService: ApiService): Repository{
    return RepositoryImpl(apiservice = apiService)

}
}