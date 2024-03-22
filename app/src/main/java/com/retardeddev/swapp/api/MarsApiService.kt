package com.retardeddev.swapp.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi {
    val retrofitServiceMars : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}