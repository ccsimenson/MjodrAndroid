package com.ccsimenson.mjodr.ui.viewmodels;

/**
 * ViewModel for the Ancient Recipes screen
 * Handles YouTube API search operations and UI state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010\'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020#J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/ccsimenson/mjodr/ui/viewmodels/RecipesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_searchResults", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/ccsimenson/mjodr/data/YoutubeVideo;", "<set-?>", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "errorMessage$delegate", "Landroidx/compose/runtime/MutableState;", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "nextPageToken", "prevPageToken", "repository", "Lcom/ccsimenson/mjodr/data/YoutubeRepository;", "searchQuery", "getSearchQuery", "setSearchQuery", "searchQuery$delegate", "searchResults", "Lkotlinx/coroutines/flow/StateFlow;", "getSearchResults", "()Lkotlinx/coroutines/flow/StateFlow;", "clearResults", "", "handleSearchResponse", "response", "Lcom/ccsimenson/mjodr/data/YoutubeSearchResponse;", "loadDefaultRecipes", "loadNextPage", "searchRecipes", "updateSearchQuery", "query", "app_debug"})
public final class RecipesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.YoutubeRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState searchQuery$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState errorMessage$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo>> _searchResults = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo>> searchResults = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String nextPageToken;
    @org.jetbrains.annotations.Nullable
    private java.lang.String prevPageToken;
    
    public RecipesViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSearchQuery() {
        return null;
    }
    
    private final void setSearchQuery(java.lang.String p0) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    private final void setLoading(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    private final void setErrorMessage(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ccsimenson.mjodr.data.YoutubeVideo>> getSearchResults() {
        return null;
    }
    
    /**
     * Update the search query
     */
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    /**
     * Search for mead recipes on YouTube
     */
    public final void searchRecipes() {
    }
    
    /**
     * Load the next page of results
     */
    public final void loadNextPage() {
    }
    
    /**
     * Load default traditional mead recipes
     */
    public final void loadDefaultRecipes() {
    }
    
    /**
     * Handle the search response
     */
    private final void handleSearchResponse(com.ccsimenson.mjodr.data.YoutubeSearchResponse response) {
    }
    
    /**
     * Clear search results
     */
    public final void clearResults() {
    }
}