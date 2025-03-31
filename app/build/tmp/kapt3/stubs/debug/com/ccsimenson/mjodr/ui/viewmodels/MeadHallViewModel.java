package com.ccsimenson.mjodr.ui.viewmodels;

/**
 * ViewModel for the Mead Hall screen
 * Manages batch tracking functionality
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020JJ\u000e\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\fJ\b\u0010N\u001a\u0004\u0018\u00010\bJ\u0006\u0010O\u001a\u00020JJ\u0006\u0010P\u001a\u00020JJ\b\u0010Q\u001a\u00020JH\u0002J\b\u0010R\u001a\u00020JH\u0002J\u0010\u0010S\u001a\u00020J2\b\u0010M\u001a\u0004\u0018\u00010\fJ\u0006\u0010?\u001a\u00020JJ\u0006\u0010E\u001a\u00020JJ\u0016\u0010T\u001a\u00020J2\u0006\u0010M\u001a\u00020\f2\u0006\u0010U\u001a\u00020VJ\u000e\u0010W\u001a\u00020J2\u0006\u0010X\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020J2\u0006\u0010Z\u001a\u00020\fJ\u000e\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020\fJ\u000e\u0010]\u001a\u00020J2\u0006\u0010^\u001a\u00020\fJ\u000e\u0010_\u001a\u00020J2\u0006\u0010`\u001a\u00020 J\u000e\u0010a\u001a\u00020J2\u0006\u0010b\u001a\u00020\fJ\u000e\u0010c\u001a\u00020J2\u0006\u0010d\u001a\u00020\fJ\u000e\u0010e\u001a\u00020J2\u0006\u0010Z\u001a\u00020\fJ\u000e\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020\fR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R+\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R+\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R;\u0010\"\u001a\n !*\u0004\u0018\u00010 0 2\u000e\u0010\u000b\u001a\n !*\u0004\u0018\u00010 0 8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R+\u0010,\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\u0013\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R+\u00100\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b3\u0010\u0013\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R+\u00104\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b7\u0010\u0013\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010:\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b=\u0010\u0013\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R+\u0010?\u001a\u00020>2\u0006\u0010\u000b\u001a\u00020>8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bD\u0010\u0013\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR+\u0010E\u001a\u00020>2\u0006\u0010\u000b\u001a\u00020>8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bH\u0010\u0013\u001a\u0004\bF\u0010A\"\u0004\bG\u0010C\u00a8\u0006h"}, d2 = {"Lcom/ccsimenson/mjodr/ui/viewmodels/MeadHallViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "batches", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/ccsimenson/mjodr/data/MeadBatch;", "getBatches", "()Lkotlinx/coroutines/flow/StateFlow;", "<set-?>", "", "newBatchName", "getNewBatchName", "()Ljava/lang/String;", "setNewBatchName", "(Ljava/lang/String;)V", "newBatchName$delegate", "Landroidx/compose/runtime/MutableState;", "newBatchNotes", "getNewBatchNotes", "setNewBatchNotes", "newBatchNotes$delegate", "newBatchOG", "getNewBatchOG", "setNewBatchOG", "newBatchOG$delegate", "newBatchRecipe", "getNewBatchRecipe", "setNewBatchRecipe", "newBatchRecipe$delegate", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "newBatchStartDate", "getNewBatchStartDate", "()Ljava/time/LocalDate;", "setNewBatchStartDate", "(Ljava/time/LocalDate;)V", "newBatchStartDate$delegate", "newBatchTargetFG", "getNewBatchTargetFG", "setNewBatchTargetFG", "newBatchTargetFG$delegate", "newMeasurementGravity", "getNewMeasurementGravity", "setNewMeasurementGravity", "newMeasurementGravity$delegate", "newMeasurementNotes", "getNewMeasurementNotes", "setNewMeasurementNotes", "newMeasurementNotes$delegate", "newMeasurementTemperature", "getNewMeasurementTemperature", "setNewMeasurementTemperature", "newMeasurementTemperature$delegate", "repository", "Lcom/ccsimenson/mjodr/data/BatchRepository;", "selectedBatchId", "getSelectedBatchId", "setSelectedBatchId", "selectedBatchId$delegate", "", "showAddBatchDialog", "getShowAddBatchDialog", "()Z", "setShowAddBatchDialog", "(Z)V", "showAddBatchDialog$delegate", "showAddMeasurementDialog", "getShowAddMeasurementDialog", "setShowAddMeasurementDialog", "showAddMeasurementDialog$delegate", "addBatch", "", "addMeasurement", "deleteBatch", "id", "getSelectedBatch", "hideAddBatchDialog", "hideAddMeasurementDialog", "resetNewBatchForm", "resetNewMeasurementForm", "selectBatch", "updateBatchStatus", "status", "Lcom/ccsimenson/mjodr/data/BatchStatus;", "updateNewBatchName", "name", "updateNewBatchNotes", "notes", "updateNewBatchOG", "og", "updateNewBatchRecipe", "recipe", "updateNewBatchStartDate", "date", "updateNewBatchTargetFG", "fg", "updateNewMeasurementGravity", "gravity", "updateNewMeasurementNotes", "updateNewMeasurementTemperature", "temp", "app_debug"})
public final class MeadHallViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.BatchRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ccsimenson.mjodr.data.MeadBatch>> batches = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState selectedBatchId$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newBatchName$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newBatchRecipe$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newBatchOG$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newBatchTargetFG$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newBatchNotes$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newBatchStartDate$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState showAddBatchDialog$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState showAddMeasurementDialog$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newMeasurementGravity$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newMeasurementTemperature$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState newMeasurementNotes$delegate = null;
    
    public MeadHallViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ccsimenson.mjodr.data.MeadBatch>> getBatches() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedBatchId() {
        return null;
    }
    
    private final void setSelectedBatchId(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewBatchName() {
        return null;
    }
    
    private final void setNewBatchName(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewBatchRecipe() {
        return null;
    }
    
    private final void setNewBatchRecipe(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewBatchOG() {
        return null;
    }
    
    private final void setNewBatchOG(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewBatchTargetFG() {
        return null;
    }
    
    private final void setNewBatchTargetFG(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewBatchNotes() {
        return null;
    }
    
    private final void setNewBatchNotes(java.lang.String p0) {
    }
    
    public final java.time.LocalDate getNewBatchStartDate() {
        return null;
    }
    
    private final void setNewBatchStartDate(java.time.LocalDate p0) {
    }
    
    public final boolean getShowAddBatchDialog() {
        return false;
    }
    
    private final void setShowAddBatchDialog(boolean p0) {
    }
    
    public final boolean getShowAddMeasurementDialog() {
        return false;
    }
    
    private final void setShowAddMeasurementDialog(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewMeasurementGravity() {
        return null;
    }
    
    private final void setNewMeasurementGravity(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewMeasurementTemperature() {
        return null;
    }
    
    private final void setNewMeasurementTemperature(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewMeasurementNotes() {
        return null;
    }
    
    private final void setNewMeasurementNotes(java.lang.String p0) {
    }
    
    /**
     * Select a batch to view details
     */
    public final void selectBatch(@org.jetbrains.annotations.Nullable
    java.lang.String id) {
    }
    
    /**
     * Show the add batch dialog
     */
    public final void showAddBatchDialog() {
    }
    
    /**
     * Hide the add batch dialog
     */
    public final void hideAddBatchDialog() {
    }
    
    /**
     * Show the add measurement dialog
     */
    public final void showAddMeasurementDialog() {
    }
    
    /**
     * Hide the add measurement dialog
     */
    public final void hideAddMeasurementDialog() {
    }
    
    /**
     * Reset the new batch form
     */
    private final void resetNewBatchForm() {
    }
    
    /**
     * Reset the new measurement form
     */
    private final void resetNewMeasurementForm() {
    }
    
    /**
     * Update new batch name
     */
    public final void updateNewBatchName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    /**
     * Update new batch recipe
     */
    public final void updateNewBatchRecipe(@org.jetbrains.annotations.NotNull
    java.lang.String recipe) {
    }
    
    /**
     * Update new batch original gravity
     */
    public final void updateNewBatchOG(@org.jetbrains.annotations.NotNull
    java.lang.String og) {
    }
    
    /**
     * Update new batch target final gravity
     */
    public final void updateNewBatchTargetFG(@org.jetbrains.annotations.NotNull
    java.lang.String fg) {
    }
    
    /**
     * Update new batch notes
     */
    public final void updateNewBatchNotes(@org.jetbrains.annotations.NotNull
    java.lang.String notes) {
    }
    
    /**
     * Update new batch start date
     */
    public final void updateNewBatchStartDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
    }
    
    /**
     * Update new measurement gravity
     */
    public final void updateNewMeasurementGravity(@org.jetbrains.annotations.NotNull
    java.lang.String gravity) {
    }
    
    /**
     * Update new measurement temperature
     */
    public final void updateNewMeasurementTemperature(@org.jetbrains.annotations.NotNull
    java.lang.String temp) {
    }
    
    /**
     * Update new measurement notes
     */
    public final void updateNewMeasurementNotes(@org.jetbrains.annotations.NotNull
    java.lang.String notes) {
    }
    
    /**
     * Add a new batch
     */
    public final void addBatch() {
    }
    
    /**
     * Add a new measurement to the selected batch
     */
    public final void addMeasurement() {
    }
    
    /**
     * Delete a batch
     */
    public final void deleteBatch(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    /**
     * Update batch status
     */
    public final void updateBatchStatus(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.BatchStatus status) {
    }
    
    /**
     * Get the selected batch
     */
    @org.jetbrains.annotations.Nullable
    public final com.ccsimenson.mjodr.data.MeadBatch getSelectedBatch() {
        return null;
    }
}