package com.example.data.network.apiservice

import com.example.data.network.model.Response
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    @GET("products")
    suspend fun getProducts(): Response


}