package com.ccsimenson.mjodr.ui.viewmodels;

/**
 * ViewModel for the ABV Calculator screen
 * Manages state and calculations for the ABV calculator
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b7\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0004H\u0002J\u0006\u0010I\u001a\u00020\u0013J\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\fJ\u000e\u0010N\u001a\u00020K2\u0006\u0010M\u001a\u00020\fJ\u000e\u0010O\u001a\u00020K2\u0006\u0010M\u001a\u00020\fR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R+\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R+\u0010\"\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R+\u0010&\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R+\u0010*\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R+\u0010.\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R/\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR/\u00106\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR+\u0010:\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R+\u0010>\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R+\u0010B\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bE\u0010\u000b\u001a\u0004\bC\u0010\u0016\"\u0004\bD\u0010\u0018\u00a8\u0006P"}, d2 = {"Lcom/ccsimenson/mjodr/ui/viewmodels/AbvCalculatorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "<set-?>", "", "abvResult", "getAbvResult", "()Ljava/lang/Double;", "setAbvResult", "(Ljava/lang/Double;)V", "abvResult$delegate", "Landroidx/compose/runtime/MutableState;", "", "appliedTemperature", "getAppliedTemperature", "()Ljava/lang/String;", "setAppliedTemperature", "(Ljava/lang/String;)V", "appliedTemperature$delegate", "", "emptyFieldsError", "getEmptyFieldsError", "()Z", "setEmptyFieldsError", "(Z)V", "emptyFieldsError$delegate", "errorMessage", "getErrorMessage", "setErrorMessage", "errorMessage$delegate", "finalGravity", "getFinalGravity", "setFinalGravity", "finalGravity$delegate", "finalGravityError", "getFinalGravityError", "setFinalGravityError", "finalGravityError$delegate", "ogFgComparisonError", "getOgFgComparisonError", "setOgFgComparisonError", "ogFgComparisonError$delegate", "originalGravity", "getOriginalGravity", "setOriginalGravity", "originalGravity$delegate", "originalGravityError", "getOriginalGravityError", "setOriginalGravityError", "originalGravityError$delegate", "platoFG", "getPlatoFG", "setPlatoFG", "platoFG$delegate", "platoOG", "getPlatoOG", "setPlatoOG", "platoOG$delegate", "temperature", "getTemperature", "setTemperature", "temperature$delegate", "temperatureCorrectionApplied", "getTemperatureCorrectionApplied", "setTemperatureCorrectionApplied", "temperatureCorrectionApplied$delegate", "temperatureError", "getTemperatureError", "setTemperatureError", "temperatureError$delegate", "applyTemperatureCorrection", "gravity", "temp", "calculate", "reset", "", "updateFinalGravity", "value", "updateOriginalGravity", "updateTemperature", "app_release"})
public final class AbvCalculatorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState originalGravity$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState finalGravity$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState temperature$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState abvResult$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState platoOG$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState platoFG$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState temperatureCorrectionApplied$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState appliedTemperature$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState originalGravityError$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState finalGravityError$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState ogFgComparisonError$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState temperatureError$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState emptyFieldsError$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState errorMessage$delegate = null;
    
    public AbvCalculatorViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOriginalGravity() {
        return null;
    }
    
    private final void setOriginalGravity(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFinalGravity() {
        return null;
    }
    
    private final void setFinalGravity(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTemperature() {
        return null;
    }
    
    private final void setTemperature(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAbvResult() {
        return null;
    }
    
    private final void setAbvResult(java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getPlatoOG() {
        return null;
    }
    
    private final void setPlatoOG(java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getPlatoFG() {
        return null;
    }
    
    private final void setPlatoFG(java.lang.Double p0) {
    }
    
    public final boolean getTemperatureCorrectionApplied() {
        return false;
    }
    
    private final void setTemperatureCorrectionApplied(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAppliedTemperature() {
        return null;
    }
    
    private final void setAppliedTemperature(java.lang.String p0) {
    }
    
    public final boolean getOriginalGravityError() {
        return false;
    }
    
    private final void setOriginalGravityError(boolean p0) {
    }
    
    public final boolean getFinalGravityError() {
        return false;
    }
    
    private final void setFinalGravityError(boolean p0) {
    }
    
    public final boolean getOgFgComparisonError() {
        return false;
    }
    
    private final void setOgFgComparisonError(boolean p0) {
    }
    
    public final boolean getTemperatureError() {
        return false;
    }
    
    private final void setTemperatureError(boolean p0) {
    }
    
    public final boolean getEmptyFieldsError() {
        return false;
    }
    
    private final void setEmptyFieldsError(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    private final void setErrorMessage(java.lang.String p0) {
    }
    
    /**
     * Update original gravity input
     */
    public final void updateOriginalGravity(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    /**
     * Update final gravity input
     */
    public final void updateFinalGravity(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    /**
     * Update temperature input
     */
    public final void updateTemperature(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    /**
     * Calculate ABV and Plato values
     * @return true if calculation was successful, false otherwise
     */
    public final boolean calculate() {
        return false;
    }
    
    /**
     * Reset all inputs and results
     */
    public final void reset() {
    }
    
    /**
     * Apply temperature correction to a gravity reading
     * Formula: SG_corrected = SG + ((calibration_temp - measured_temp) * 0.00065)
     * Assumes calibration temperature of 60°F
     */
    private final double applyTemperatureCorrection(double gravity, double temp) {
        return 0.0;
    }
}