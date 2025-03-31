package com.ccsimenson.mjodr.ui.viewmodels;

/**
 * ViewModel for the Traditional Recipes feature
 * Handles loading, filtering, and favoriting traditional Viking mead recipes
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00107\u001a\u000208J\b\u00109\u001a\u000208H\u0002J\u0006\u0010:\u001a\u000208J\u0010\u0010;\u001a\u0002082\b\u0010<\u001a\u0004\u0018\u00010%J\u0010\u0010=\u001a\u0002082\b\u0010>\u001a\u0004\u0018\u00010,J\u000e\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u000208J\u000e\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020\u001eR+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R/\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0005\u001a\u0004\u0018\u00010%8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R/\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0005\u001a\u0004\u0018\u00010,8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010\r\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u0010\r\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000b\u00a8\u0006D"}, d2 = {"Lcom/ccsimenson/mjodr/ui/viewmodels/TraditionalRecipesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "<set-?>", "", "_isFavorite", "get_isFavorite", "()Z", "set_isFavorite", "(Z)V", "_isFavorite$delegate", "Landroidx/compose/runtime/MutableState;", "_recipes", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/ccsimenson/mjodr/data/MeadRecipe;", "allRecipes", "dataStoreManager", "Lcom/ccsimenson/mjodr/data/DataStoreManager;", "isLoading", "setLoading", "isLoading$delegate", "recipes", "Lkotlinx/coroutines/flow/StateFlow;", "getRecipes", "()Lkotlinx/coroutines/flow/StateFlow;", "repository", "Lcom/ccsimenson/mjodr/data/MeadRecipeRepository;", "", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "setSearchQuery", "(Ljava/lang/String;)V", "searchQuery$delegate", "Lcom/ccsimenson/mjodr/data/RecipeDifficulty;", "selectedDifficulty", "getSelectedDifficulty", "()Lcom/ccsimenson/mjodr/data/RecipeDifficulty;", "setSelectedDifficulty", "(Lcom/ccsimenson/mjodr/data/RecipeDifficulty;)V", "selectedDifficulty$delegate", "Lcom/ccsimenson/mjodr/data/RecipeType;", "selectedType", "getSelectedType", "()Lcom/ccsimenson/mjodr/data/RecipeType;", "setSelectedType", "(Lcom/ccsimenson/mjodr/data/RecipeType;)V", "selectedType$delegate", "showFavoritesOnly", "getShowFavoritesOnly", "setShowFavoritesOnly", "showFavoritesOnly$delegate", "clearFilters", "", "filterRecipes", "loadAllRecipes", "setDifficultyFilter", "difficulty", "setTypeFilter", "type", "toggleFavorite", "recipeId", "toggleFavoritesOnly", "updateSearchQuery", "query", "app_release"})
public final class TraditionalRecipesViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.MeadRecipeRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.DataStoreManager dataStoreManager = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ccsimenson.mjodr.data.MeadRecipe> allRecipes = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ccsimenson.mjodr.data.MeadRecipe>> _recipes = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ccsimenson.mjodr.data.MeadRecipe>> recipes = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState selectedType$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState selectedDifficulty$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState searchQuery$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState showFavoritesOnly$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState _isFavorite$delegate = null;
    
    public TraditionalRecipesViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ccsimenson.mjodr.data.MeadRecipe>> getRecipes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.ccsimenson.mjodr.data.RecipeType getSelectedType() {
        return null;
    }
    
    private final void setSelectedType(com.ccsimenson.mjodr.data.RecipeType p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.ccsimenson.mjodr.data.RecipeDifficulty getSelectedDifficulty() {
        return null;
    }
    
    private final void setSelectedDifficulty(com.ccsimenson.mjodr.data.RecipeDifficulty p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSearchQuery() {
        return null;
    }
    
    private final void setSearchQuery(java.lang.String p0) {
    }
    
    public final boolean getShowFavoritesOnly() {
        return false;
    }
    
    private final void setShowFavoritesOnly(boolean p0) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    private final void setLoading(boolean p0) {
    }
    
    private final boolean get_isFavorite() {
        return false;
    }
    
    private final void set_isFavorite(boolean p0) {
    }
    
    public final void loadAllRecipes() {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void setTypeFilter(@org.jetbrains.annotations.Nullable
    com.ccsimenson.mjodr.data.RecipeType type) {
    }
    
    public final void setDifficultyFilter(@org.jetbrains.annotations.Nullable
    com.ccsimenson.mjodr.data.RecipeDifficulty difficulty) {
    }
    
    public final void toggleFavoritesOnly() {
    }
    
    public final void clearFilters() {
    }
    
    private final void filterRecipes() {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String recipeId) {
    }
}