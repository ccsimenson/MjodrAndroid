package com.ccsimenson.mjodr.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "youtube_videos")
data class YoutubeVideo(
    @PrimaryKey
    val videoId: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val channelTitle: String,
    val recipeId: Long? = null  // Optional reference to a recipe
)