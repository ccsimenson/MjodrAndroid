package com.ccsimenson.mjodr.data

/**
 * Statistics for a mead batch
 */
data class BatchStatistics(
    val totalMeasurements: Int = 0,
    val daysFermenting: Int = 0,
    val abvTrend: List<Double> = emptyList(),
    val temperatureTrend: List<Double> = emptyList()
)
