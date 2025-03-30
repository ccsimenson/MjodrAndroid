package com.ccsimenson.mjodr.data

/**
 * Data models for YouTube API responses
 * Used for the Ancient Recipes feature to search for traditional mead recipes
 */

data class YoutubeSearchResponse(
    val items: List<YoutubeVideo> = emptyList(),
    val nextPageToken: String? = null,
    val prevPageToken: String? = null,
    val pageInfo: PageInfo? = null
)

data class PageInfo(
    val totalResults: Int = 0,
    val resultsPerPage: Int = 0
)

data class YoutubeVideo(
    val id: VideoId? = null,
    val snippet: VideoSnippet? = null
) {
    val videoId: String
        get() = id?.videoId ?: ""
    
    val videoUrl: String
        get() = "https://www.youtube.com/watch?v=$videoId"
}

data class VideoId(
    val kind: String = "",
    val videoId: String = ""
)

data class VideoSnippet(
    val publishedAt: String = "",
    val channelId: String = "",
    val title: String = "",
    val description: String = "",
    val thumbnails: Thumbnails? = null,
    val channelTitle: String = ""
)

data class Thumbnails(
    val default: Thumbnail? = null,
    val medium: Thumbnail? = null,
    val high: Thumbnail? = null
)

data class Thumbnail(
    val url: String = "",
    val width: Int = 0,
    val height: Int = 0
)
