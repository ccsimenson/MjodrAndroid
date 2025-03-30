package com.ccsimenson.mjodr.data

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit service interface for YouTube API
 * Used for the Ancient Recipes feature to search for traditional mead recipes
 */
interface YoutubeApiService {
    
    @GET("youtube/v3/search")
    suspend fun searchVideos(
        @Query("part") part: String = "snippet",
        @Query("maxResults") maxResults: Int = 10,
        @Query("q") query: String,
        @Query("type") type: String = "video",
        @Query("key") apiKey: String,
        @Query("pageToken") pageToken: String? = null
    ): YoutubeSearchResponse
}
