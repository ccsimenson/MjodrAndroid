package com.ccsimenson.mjodr.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val type: String,          // Traditional, Melomel, Metheglin, etc.
    val difficulty: String,    // Beginner, Intermediate, Advanced
    val isFavorite: Boolean = false
)