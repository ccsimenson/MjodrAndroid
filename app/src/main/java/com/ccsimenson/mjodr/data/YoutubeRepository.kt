package com.ccsimenson.mjodr.data

import com.ccsimenson.mjodr.data.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Repository for YouTube API operations
 * Used for the Ancient Recipes feature to search for traditional mead recipes
 */
class YoutubeRepository {
    
    private val BASE_URL = "https://www.googleapis.com/"
    
    // Using the API key from ApiConstants
    private val API_KEY = ApiConstants.YOUTUBE_API_KEY
    
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    
    private val youtubeService = retrofit.create(YoutubeApiService::class.java)
    
    /**
     * Search for mead recipes on YouTube
     * @param query The search query
     * @param pageToken Optional token for pagination
     * @return A list of YouTube videos matching the query
     */
    suspend fun searchMeadRecipes(query: String, pageToken: String? = null): YoutubeSearchResponse {
        // Append "mead recipe" to ensure results are relevant
        val fullQuery = if (query.isNotBlank()) "$query mead recipe" else "traditional mead recipe"
        return youtubeService.searchVideos(
            query = fullQuery,
            apiKey = API_KEY,
            pageToken = pageToken
        )
    }
}
