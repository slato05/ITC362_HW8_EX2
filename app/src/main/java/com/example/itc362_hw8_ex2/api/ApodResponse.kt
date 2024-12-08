package com.example.itc362_hw8_ex2.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApodResponse(
    val date: String,
    val explanation: String,
    val hdurl: String?,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)