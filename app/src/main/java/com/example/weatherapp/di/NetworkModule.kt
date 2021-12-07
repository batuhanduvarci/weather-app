package com.example.weatherapp.di

import com.example.weatherapp.network.WeatherService
import com.example.weatherapp.network.mapper.WeatherResponseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun serviceProvider(retrofit: Retrofit) : WeatherService = retrofit.create(WeatherService::class.java)

    @Singleton
    @Provides
    fun weatherResponseMapperProvider(): WeatherResponseMapper{
        return WeatherResponseMapper()
    }
}