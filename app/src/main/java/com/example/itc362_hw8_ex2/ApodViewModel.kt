package com.example.itc362_hw8_ex2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itc362_hw8_ex2.api.ApodResponse
import com.example.itc362_hw8_ex2.api.NasaApi
import kotlinx.coroutines.launch

private const val API_KEY = "6DKwsV8m0gciqaSp7Yr5lLTfVBdGE4NEGbJx6Bsl"

class ApodViewModel : ViewModel() {
    private val _photos = MutableLiveData<List<ApodResponse>>()
    val photos: LiveData<List<ApodResponse>> get() = _photos

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            try {
                val response = NasaApi.service.getApod(apiKey = API_KEY)
                _photos.value = response
            } catch (e: Exception) {
            }
        }
    }
}