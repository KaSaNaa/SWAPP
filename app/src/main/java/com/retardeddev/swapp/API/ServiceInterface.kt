package com.retardeddev.swapp.API

import com.retardeddev.swapp.dataModel.SpaceWeatherEvent
import retrofit2.http.GET
import retrofit2.http.Query

interface DonkiApiService {
    @GET("DONKI/CME")
    suspend fun getCMEs(
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("api_key") apiKey: String
    ): List<SpaceWeatherEvent>
}
