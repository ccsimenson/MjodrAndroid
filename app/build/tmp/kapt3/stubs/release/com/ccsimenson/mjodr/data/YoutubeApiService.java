package com.ccsimenson.mjodr.data;

/**
 * Retrofit service interface for YouTube API
 * Used for the Ancient Recipes feature to search for traditional mead recipes
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/ccsimenson/mjodr/data/YoutubeApiService;", "", "searchVideos", "Lcom/ccsimenson/mjodr/data/YoutubeSearchResponse;", "part", "", "maxResults", "", "query", "type", "apiKey", "pageToken", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface YoutubeApiService {
    
    @retrofit2.http.GET(value = "youtube/v3/search")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchVideos(@retrofit2.http.Query(value = "part")
    @org.jetbrains.annotations.NotNull
    java.lang.String part, @retrofit2.http.Query(value = "maxResults")
    int maxResults, @retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull
    java.lang.String query, @retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.NotNull
    java.lang.String type, @retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "pageToken")
    @org.jetbrains.annotations.Nullable
    java.lang.String pageToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ccsimenson.mjodr.data.YoutubeSearchResponse> $completion);
    
    /**
     * Retrofit service interface for YouTube API
     * Used for the Ancient Recipes feature to search for traditional mead recipes
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}