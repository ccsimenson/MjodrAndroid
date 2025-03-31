package com.ccsimenson.mjodr.data;

/**
 * Data model for a mead batch
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0002\u0010\u0012J\u0018\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010>\u001a\u00020\u000eH\u00c6\u0003J|\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010D\u001a\u00020EH\u00d6\u0001J\t\u0010F\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0013\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0015R\u0011\u0010(\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u00101\u001a\u0004\b0\u0010\u0018\u00a8\u0006G"}, d2 = {"Lcom/ccsimenson/mjodr/data/MeadBatch;", "", "id", "", "name", "recipe", "originalGravity", "", "targetFinalGravity", "notes", "startDate", "Ljava/time/LocalDate;", "targetEndDate", "status", "Lcom/ccsimenson/mjodr/data/BatchStatus;", "measurements", "", "Lcom/ccsimenson/mjodr/data/GravityMeasurement;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/Double;Ljava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Lcom/ccsimenson/mjodr/data/BatchStatus;Ljava/util/List;)V", "currentAbv", "getCurrentAbv", "()D", "currentGravity", "getCurrentGravity", "()Ljava/lang/Double;", "daysInFermentation", "", "getDaysInFermentation", "()J", "formattedStartDate", "getFormattedStartDate", "()Ljava/lang/String;", "formattedTargetEndDate", "getFormattedTargetEndDate", "getId", "getMeasurements", "()Ljava/util/List;", "getName", "getNotes", "getOriginalGravity", "potentialAbv", "getPotentialAbv", "getRecipe", "getStartDate", "()Ljava/time/LocalDate;", "getStatus", "()Lcom/ccsimenson/mjodr/data/BatchStatus;", "getTargetEndDate", "getTargetFinalGravity", "Ljava/lang/Double;", "calculateAbv", "og", "fg", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/Double;Ljava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Lcom/ccsimenson/mjodr/data/BatchStatus;Ljava/util/List;)Lcom/ccsimenson/mjodr/data/MeadBatch;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class MeadBatch {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String recipe = null;
    private final double originalGravity = 0.0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double targetFinalGravity = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String notes = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDate startDate = null;
    @org.jetbrains.annotations.Nullable
    private final java.time.LocalDate targetEndDate = null;
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.BatchStatus status = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ccsimenson.mjodr.data.GravityMeasurement> measurements = null;
    
    public MeadBatch(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String recipe, double originalGravity, @org.jetbrains.annotations.Nullable
    java.lang.Double targetFinalGravity, @org.jetbrains.annotations.NotNull
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    java.time.LocalDate startDate, @org.jetbrains.annotations.Nullable
    java.time.LocalDate targetEndDate, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.BatchStatus status, @org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.GravityMeasurement> measurements) {
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
    public final java.lang.String getRecipe() {
        return null;
    }
    
    public final double getOriginalGravity() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getTargetFinalGravity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDate getStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDate getTargetEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.BatchStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.GravityMeasurement> getMeasurements() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getCurrentGravity() {
        return null;
    }
    
    public final double getCurrentAbv() {
        return 0.0;
    }
    
    public final double getPotentialAbv() {
        return 0.0;
    }
    
    public final long getDaysInFermentation() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedTargetEndDate() {
        return null;
    }
    
    /**
     * Calculate ABV from original gravity and final gravity
     */
    private final double calculateAbv(double og, double fg) {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.ccsimenson.mjodr.data.GravityMeasurement> component10() {
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
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDate component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDate component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.BatchStatus component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.MeadBatch copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String recipe, double originalGravity, @org.jetbrains.annotations.Nullable
    java.lang.Double targetFinalGravity, @org.jetbrains.annotations.NotNull
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    java.time.LocalDate startDate, @org.jetbrains.annotations.Nullable
    java.time.LocalDate targetEndDate, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.BatchStatus status, @org.jetbrains.annotations.NotNull
    java.util.List<com.ccsimenson.mjodr.data.GravityMeasurement> measurements) {
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