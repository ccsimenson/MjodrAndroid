package com.ccsimenson.mjodr.data.dao

import androidx.room.*
import com.ccsimenson.mjodr.data.model.GravityMeasurement
import kotlinx.coroutines.flow.Flow

@Dao
interface MeasurementDao {
    @Query("SELECT * FROM measurements WHERE batchId = :batchId ORDER BY timestamp DESC")
    fun getMeasurementsForBatch(batchId: Long): Flow<List<GravityMeasurement>>

    @Insert
    suspend fun insertMeasurement(measurement: GravityMeasurement): Long

    @Update
    suspend fun updateMeasurement(measurement: GravityMeasurement)

    @Delete
    suspend fun deleteMeasurement(measurement: GravityMeasurement)

    @Query("SELECT * FROM measurements WHERE id = :measurementId")
    suspend fun getMeasurementById(measurementId: Long): GravityMeasurement?
}