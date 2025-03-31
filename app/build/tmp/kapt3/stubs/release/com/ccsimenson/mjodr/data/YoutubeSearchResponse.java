package com.ccsimenson.mjodr.data;

/**
 * Data models for YouTube API responses
 * Used for the Ancient Recipes feature to search for traditional mead recipes
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u00c6\u0003J=\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/ccsimenson/mjodr/data/YoutubeSearchResponse;", "", "items", "", "Lcom/ccsimenson/mjodr/data/YoutubeVideo;", "nextPageToken", "", "prevPageToken", "pageInfo", "Lcom/ccsimenson/mjodr/data/PageInfo;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/ccsimenson/mjodr/data/PageInfo;)V", "getItems", "()Ljava/util/List;", "getNextPageToken", "()Ljava/lang/String;", "getPageInfo", "()Lcom/ccsimenson/mjodr/data/PageInfo;", "getPrevPageToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class YoutubeSearchResponse {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo> items = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String nextPageToken = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String prevPageToken = null;
    @org.jetbrains.annotations.Nullable
    private final com.ccsimenson.mjodr.data.PageInfo pageInfo = null;
    
    public YoutubeSearchResponse(@org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo> items, @org.jetbrains.annotations.Nullable
    java.lang.String nextPageToken, @org.jetbrains.annotations.Nullable
    java.lang.String prevPageToken, @org.jetbrains.annotations.Nullable
    com.ccsimenson.mjodr.data.PageInfo pageInfo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNextPageToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrevPageToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.ccsimenson.mjodr.data.PageInfo getPageInfo() {
        return null;
    }
    
    public YoutubeSearchResponse() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.ccsimenson.mjodr.data.PageInfo component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.YoutubeSearchResponse copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo> items, @org.jetbrains.annotations.Nullable
    java.lang.String nextPageToken, @org.jetbrains.annotations.Nullable
    java.lang.String prevPageToken, @org.jetbrains.annotations.Nullable
    com.ccsimenson.mjodr.data.PageInfo pageInfo) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}