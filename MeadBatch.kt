package com.ccsimenson.mjodr.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "mead_batches")
data class MeadBatch(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val recipe: String,
    val startDate: LocalDateTime = LocalDateTime.now(),
    val status: BatchStatus = BatchStatus.PRIMARY,
    val targetVolume: Float,  // In liters
    val notes: String = "",
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)