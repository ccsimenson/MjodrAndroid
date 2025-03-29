package com.ccsimenson.mjodr.data.dao

import androidx.room.*
import com.ccsimenson.mjodr.data.model.MeadBatch
import kotlinx.coroutines.flow.Flow

@Dao
interface MeadBatchDao {
    @Query("SELECT * FROM mead_batches ORDER BY startDate DESC")
    fun getAllBatches(): Flow<List<MeadBatch>>

    @Query("SELECT * FROM mead_batches WHERE id = :batchId")
    suspend fun getBatchById(batchId: Long): MeadBatch?

    @Insert
    suspend fun insertBatch(batch: MeadBatch): Long

    @Update
    suspend fun updateBatch(batch: MeadBatch)

    @Delete
    suspend fun deleteBatch(batch: MeadBatch)
}