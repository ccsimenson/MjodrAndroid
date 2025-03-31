package com.ccsimenson.mjodr.data;

/**
 * Status of a mead batch
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/ccsimenson/mjodr/data/BatchStatus;", "", "(Ljava/lang/String;I)V", "PLANNING", "FERMENTING", "AGING", "BOTTLED", "COMPLETED", "FAILED", "ARCHIVED", "app_release"})
public enum BatchStatus {
    /*public static final*/ PLANNING /* = new PLANNING() */,
    /*public static final*/ FERMENTING /* = new FERMENTING() */,
    /*public static final*/ AGING /* = new AGING() */,
    /*public static final*/ BOTTLED /* = new BOTTLED() */,
    /*public static final*/ COMPLETED /* = new COMPLETED() */,
    /*public static final*/ FAILED /* = new FAILED() */,
    /*public static final*/ ARCHIVED /* = new ARCHIVED() */;
    
    BatchStatus() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.ccsimenson.mjodr.data.BatchStatus> getEntries() {
        return null;
    }
}