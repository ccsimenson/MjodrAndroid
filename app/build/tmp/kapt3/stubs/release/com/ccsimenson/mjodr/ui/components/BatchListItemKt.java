package com.ccsimenson.mjodr.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001a\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\u000b"}, d2 = {"BatchListItem", "", "batch", "Lcom/ccsimenson/mjodr/data/MeadBatch;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "StatusBadge", "status", "Lcom/ccsimenson/mjodr/data/BatchStatus;", "app_release"})
public final class BatchListItemKt {
    
    /**
     * A list item component for displaying a mead batch
     * Styled with the Viking theme
     */
    @androidx.compose.runtime.Composable
    public static final void BatchListItem(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.MeadBatch batch, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * A badge component for displaying batch status
     * Styled with the Viking theme
     */
    @androidx.compose.runtime.Composable
    public static final void StatusBadge(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.BatchStatus status, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
}