package com.retardeddev.swapp.api

import com.retardeddev.swapp.dataModel.CME
import com.retardeddev.swapp.dataModel.CMEAnalysis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {

    @GET("DONKI/WS/get/CME")
    suspend fun fetchCMEs(
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): List<CME>

    @GET("DONKI/WS/get/CMEAnalysis")
    suspend fun fetchCMEAnalysis(
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("mostAccurateOnly") mostAccurateOnly: Boolean = true,
        @Query("completeEntryOnly") completeEntryOnly: Boolean = true,
        @Query("speed") speed: Int = 0,
        @Query("halfAngle") halfAngle: Int = 0,
        @Query("catalog") catalog: String = "ALL"
    ): List<CMEAnalysis>
}


object NasaApiClient {
    private const val BASE_URL = "https://kauai.ccmc.gsfc.nasa.gov/DONKI/WS/get/"

    val service: NasaApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(NasaApiService::class.java)
    }
}
