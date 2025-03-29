package com.ccsimenson.mjodr.data.model

enum class BatchStatus {
    PRIMARY,        // Initial fermentation
    SECONDARY,      // Secondary fermentation
    AGING,          // Bulk aging
    BOTTLED,        // In bottles
    COMPLETED       // Ready to drink
}