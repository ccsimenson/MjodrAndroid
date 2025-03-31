package com.ccsimenson.mjodr.data;

/**
 * Manager for handling data store operations
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/ccsimenson/mjodr/data/DataStoreManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getFavoriteRecipes", "Lkotlinx/coroutines/flow/Flow;", "", "", "saveFavoriteRecipes", "", "recipes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class DataStoreManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    public DataStoreManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Get the list of favorite recipe IDs
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getFavoriteRecipes() {
        return null;
    }
    
    /**
     * Save the list of favorite recipe IDs
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveFavoriteRecipes(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> recipes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}