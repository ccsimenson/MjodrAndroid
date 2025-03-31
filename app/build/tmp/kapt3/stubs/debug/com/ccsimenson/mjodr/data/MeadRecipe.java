package com.ccsimenson.mjodr.data;

/**
 * Data model for a traditional mead recipe
 * Used for the Ancient Recipes feature
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\fH\u00c6\u0003J\t\u0010+\u001a\u00020\u000eH\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0011H\u00c6\u0003J{\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u000202H\u00d6\u0001J\t\u00103\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015\u00a8\u00064"}, d2 = {"Lcom/ccsimenson/mjodr/data/MeadRecipe;", "", "id", "", "name", "description", "ingredients", "", "Lcom/ccsimenson/mjodr/data/Ingredient;", "instructions", "Lcom/ccsimenson/mjodr/data/Instruction;", "type", "Lcom/ccsimenson/mjodr/data/RecipeType;", "difficulty", "Lcom/ccsimenson/mjodr/data/RecipeDifficulty;", "preparationTime", "isFavorite", "", "youtubeVideoId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/ccsimenson/mjodr/data/RecipeType;Lcom/ccsimenson/mjodr/data/RecipeDifficulty;Ljava/lang/String;ZLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getDifficulty", "()Lcom/ccsimenson/mjodr/data/RecipeDifficulty;", "getId", "getIngredients", "()Ljava/util/List;", "getInstructions", "()Z", "setFavorite", "(Z)V", "getName", "getPreparationTime", "getType", "()Lcom/ccsimenson/mjodr/data/RecipeType;", "getYoutubeVideoId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class MeadRecipe {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ccsimenson.mjodr.data.Ingredient> ingredients = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ccsimenson.mjodr.data.Instruction> instructions = null;
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.RecipeType type = null;
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.RecipeDifficulty difficulty = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String preparationTime = null;
    private boolean isFavorite;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String youtubeVideoId = null;
    
    public MeadRecipe(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.Ingredient> ingredients, @org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.Instruction> instructions, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.RecipeType type, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.RecipeDifficulty difficulty, @org.jetbrains.annotations.NotNull
    java.lang.String preparationTime, boolean isFavorite, @org.jetbrains.annotations.Nullable
    java.lang.String youtubeVideoId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.Ingredient> getIngredients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.Instruction> getInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.RecipeType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.RecipeDifficulty getDifficulty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPreparationTime() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final void setFavorite(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getYoutubeVideoId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.Ingredient> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.Instruction> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.RecipeType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.RecipeDifficulty component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.MeadRecipe copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.Ingredient> ingredients, @org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.Instruction> instructions, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.RecipeType type, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.RecipeDifficulty difficulty, @org.jetbrains.annotations.NotNull
    java.lang.String preparationTime, boolean isFavorite, @org.jetbrains.annotations.Nullable
    java.lang.String youtubeVideoId) {
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