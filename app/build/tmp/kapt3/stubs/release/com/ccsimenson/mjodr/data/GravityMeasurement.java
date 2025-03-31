package com.ccsimenson.mjodr.data;

/**
 * Data model for a gravity measurement
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J8\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/ccsimenson/mjodr/data/GravityMeasurement;", "", "gravity", "", "temperature", "notes", "", "date", "Ljava/time/LocalDate;", "(DLjava/lang/Double;Ljava/lang/String;Ljava/time/LocalDate;)V", "correctedGravity", "getCorrectedGravity", "()D", "getDate", "()Ljava/time/LocalDate;", "formattedDate", "getFormattedDate", "()Ljava/lang/String;", "getGravity", "getNotes", "getTemperature", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(DLjava/lang/Double;Ljava/lang/String;Ljava/time/LocalDate;)Lcom/ccsimenson/mjodr/data/GravityMeasurement;", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class GravityMeasurement {
    private final double gravity = 0.0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double temperature = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String notes = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDate date = null;
    
    public GravityMeasurement(double gravity, @org.jetbrains.annotations.Nullable
    java.lang.Double temperature, @org.jetbrains.annotations.NotNull
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
        super();
    }
    
    public final double getGravity() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getTemperature() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedDate() {
        return null;
    }
    
    public final double getCorrectedGravity() {
        return 0.0;
    }
    
    public final double component1() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDate component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ccsimenson.mjodr.data.GravityMeasurement copy(double gravity, @org.jetbrains.annotations.Nullable
    java.lang.Double temperature, @org.jetbrains.annotations.NotNull
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
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