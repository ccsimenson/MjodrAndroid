package com.ccsimenson.mjodr.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0003\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"RecipeDetailScreen", "", "recipe", "Lcom/ccsimenson/mjodr/data/MeadRecipe;", "onBackClick", "Lkotlin/Function0;", "onFavoriteClick", "Lkotlin/Function1;", "", "onShareClick", "modifier", "Landroidx/compose/ui/Modifier;", "getDifficultyColor", "Landroidx/compose/ui/graphics/Color;", "difficulty", "(Ljava/lang/String;)J", "app_release"})
public final class RecipeDetailScreenKt {
    
    /**
     * Screen for displaying detailed information about a mead recipe
     * Styled with the Viking theme
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void RecipeDetailScreen(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.MeadRecipe recipe, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFavoriteClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.ccsimenson.mjodr.data.MeadRecipe, kotlin.Unit> onShareClick, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Get color based on recipe difficulty
     */
    @androidx.compose.runtime.Composable
    private static final long getDifficultyColor(java.lang.String difficulty) {
        return 0L;
    }
}