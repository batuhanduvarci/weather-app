package com.example.weatherapp.domain.util

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(response: T): DomainModel

    fun fromEntityList(initial: List<T>): List<DomainModel>
}