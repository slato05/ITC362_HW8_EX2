package com.example.itc362_hw8_ex2.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {
    @GET("planetary/apod")
    suspend fun getApod(
        @Query("api_key") apiKey: String,
        @Query("count") count: Int = 50
    ): List<ApodResponse>
}