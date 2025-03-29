package com.ccsimenson.mjodr.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "measurements",
    foreignKeys = [
        ForeignKey(
            entity = MeadBatch::class,
            parentColumns = ["id"],
            childColumns = ["batchId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class GravityMeasurement(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val batchId: Long,
    val specificGravity: Float,
    val temperature: Float,    // In Celsius
    val correctedGravity: Float?,
    val notes: String = "",
    val timestamp: LocalDateTime = LocalDateTime.now()
)