package com.ccsimenson.mjodr.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a<\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001aI\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\u001a\u001a<\u0010\u001b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\u001c"}, d2 = {"AbvCalculatorScreen", "", "onNavigateBack", "Lkotlin/Function0;", "viewModel", "Lcom/ccsimenson/mjodr/ui/viewmodels/AbvCalculatorViewModel;", "ErrorMessage", "errorKey", "", "GravityInputField", "value", "onValueChange", "Lkotlin/Function1;", "label", "placeholder", "isError", "", "ResultsCard", "abv", "", "platoOG", "platoFG", "originalGravity", "finalGravity", "temperatureCorrectionApplied", "appliedTemperature", "(DLjava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "TemperatureInputField", "app_debug"})
public final class AbvCalculatorScreenKt {
    
    /**
     * ABV Calculator Screen
     * Allows users to calculate ABV based on original and final gravity readings
     */
    @androidx.compose.runtime.Composable
    public static final void AbvCalculatorScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.ui.viewmodels.AbvCalculatorViewModel viewModel) {
    }
    
    /**
     * Input field for gravity values
     */
    @androidx.compose.runtime.Composable
    public static final void GravityInputField(@org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String placeholder, boolean isError) {
    }
    
    /**
     * Input field for temperature values
     */
    @androidx.compose.runtime.Composable
    public static final void TemperatureInputField(@org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String placeholder, boolean isError) {
    }
    
    /**
     * Display Viking-themed error message
     */
    @androidx.compose.runtime.Composable
    public static final void ErrorMessage(@org.jetbrains.annotations.NotNull
    java.lang.String errorKey) {
    }
    
    /**
     * Card to display calculation results
     */
    @androidx.compose.runtime.Composable
    public static final void ResultsCard(double abv, @org.jetbrains.annotations.Nullable
    java.lang.Double platoOG, @org.jetbrains.annotations.Nullable
    java.lang.Double platoFG, @org.jetbrains.annotations.NotNull
    java.lang.String originalGravity, @org.jetbrains.annotations.NotNull
    java.lang.String finalGravity, boolean temperatureCorrectionApplied, @org.jetbrains.annotations.NotNull
    java.lang.String appliedTemperature) {
    }
}