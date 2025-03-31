package com.ccsimenson.mjodr.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AbvCalculator", "BatchStatistics", "BrewingHistory", "Help", "Home", "MeadHall", "Recipes", "Lcom/ccsimenson/mjodr/navigation/Screen$AbvCalculator;", "Lcom/ccsimenson/mjodr/navigation/Screen$BatchStatistics;", "Lcom/ccsimenson/mjodr/navigation/Screen$BrewingHistory;", "Lcom/ccsimenson/mjodr/navigation/Screen$Help;", "Lcom/ccsimenson/mjodr/navigation/Screen$Home;", "Lcom/ccsimenson/mjodr/navigation/Screen$MeadHall;", "Lcom/ccsimenson/mjodr/navigation/Screen$Recipes;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$AbvCalculator;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "app_debug"})
    public static final class AbvCalculator extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.AbvCalculator INSTANCE = null;
        
        private AbvCalculator() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$BatchStatistics;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "createRoute", "", "batchId", "app_debug"})
    public static final class BatchStatistics extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.BatchStatistics INSTANCE = null;
        
        private BatchStatistics() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull
        java.lang.String batchId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$BrewingHistory;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "app_debug"})
    public static final class BrewingHistory extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.BrewingHistory INSTANCE = null;
        
        private BrewingHistory() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$Help;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "app_debug"})
    public static final class Help extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.Help INSTANCE = null;
        
        private Help() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$Home;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$MeadHall;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "app_debug"})
    public static final class MeadHall extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.MeadHall INSTANCE = null;
        
        private MeadHall() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ccsimenson/mjodr/navigation/Screen$Recipes;", "Lcom/ccsimenson/mjodr/navigation/Screen;", "()V", "app_debug"})
    public static final class Recipes extends com.ccsimenson.mjodr.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.ccsimenson.mjodr.navigation.Screen.Recipes INSTANCE = null;
        
        private Recipes() {
        }
    }
}