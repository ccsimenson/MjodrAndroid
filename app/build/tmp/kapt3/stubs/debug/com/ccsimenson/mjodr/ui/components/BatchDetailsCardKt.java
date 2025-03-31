package com.ccsimenson.mjodr.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a.\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\u0015"}, d2 = {"BatchDetailsCard", "", "batch", "Lcom/ccsimenson/mjodr/data/MeadBatch;", "onAddMeasurementClick", "Lkotlin/Function0;", "onStatusChange", "Lkotlin/Function1;", "Lcom/ccsimenson/mjodr/data/BatchStatus;", "onDeleteClick", "modifier", "Landroidx/compose/ui/Modifier;", "DetailItem", "label", "", "value", "MeasurementItem", "measurement", "Lcom/ccsimenson/mjodr/data/GravityMeasurement;", "StatusDropdown", "currentStatus", "app_debug"})
public final class BatchDetailsCardKt {
    
    /**
     * A card component for displaying detailed information about a mead batch
     * Styled with the Viking theme
     */
    @androidx.compose.runtime.Composable
    public static final void BatchDetailsCard(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.MeadBatch batch, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddMeasurementClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.ccsimenson.mjodr.data.BatchStatus, kotlin.Unit> onStatusChange, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteClick, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * A component for displaying a detail item with label and value
     */
    @androidx.compose.runtime.Composable
    public static final void DetailItem(@org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * A component for displaying a measurement item
     */
    @androidx.compose.runtime.Composable
    public static final void MeasurementItem(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.GravityMeasurement measurement, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * A dropdown for changing batch status
     */
    @androidx.compose.runtime.Composable
    public static final void StatusDropdown(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.BatchStatus currentStatus, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.ccsimenson.mjodr.data.BatchStatus, kotlin.Unit> onStatusChange, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
}