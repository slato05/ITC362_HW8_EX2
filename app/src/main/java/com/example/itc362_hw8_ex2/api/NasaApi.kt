package com.example.itc362_hw8_ex2.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NasaApi {
    private const val BASE_URL = "https://api.nasa.gov/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service: NasaApiService by lazy {
        retrofit.create(NasaApiService::class.java)
    }
}