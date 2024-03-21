package com.retardeddev.swapp.dataModel

data class CME(
    val activityID: String,
    val startTime: String,
    val sourceLocation: String,
    val activeRegionNum: String,
    val instruments: List<String>,
    val cmeAnalyses: List<CMEAnalysis>,
    val linkedEvents: List<String>,
    val note: String,
    val catalog: String
)

data class CMEAnalysis(
    val time21_5: String,
    val latitude: Double,
    val longitude: Double,
    val halfAngle: Double,
    val speed: Double,
    val type: String,
    val isMostAccurate: Boolean,
    val associatedCMEID: String,
    val note: String,
    val catalog: String
)

