package com.ccsimenson.mjodr.ui.theme

import androidx.compose.ui.graphics.Color

object VikingColors {
    // Primary Colors
    val DarkWood = Color(0xFF2C1810)  // Dark brown background
    val LightWood = Color(0xFFB08968)  // Light brown for buttons
    val Gold = Color(0xFFDAA520)       // Soft gold for accents
    val DeepRed = Color(0xFF8B0000)    // Deep red for active states
    val Parchment = Color(0xFFF5E6D3)  // Warm cream for text fields
    val TextDark = Color(0xFF2C1810)   // Dark text on light backgrounds

    // Alpha Variations
    val LightWoodAlpha70 = Color(0xB3B08968)  // For semi-transparent overlays
    val GoldAlpha50 = Color(0x80DAA520)       // For subtle highlights
    val ParchmentAlpha90 = Color(0xE6F5E6D3)  // For text field backgrounds

    // Additional Theme Colors
    val DarkWoodLight = Color(0xFF3C2820)     // Lighter version of DarkWood for layering
    val GoldDark = Color(0xFFC69500)          // Darker gold for pressed states
    val DeepRedLight = Color(0xFF9B1010)      // Lighter red for hover states
    
    // Semantic Colors
    val Success = Color(0xFF2E7D32)           // Green for success states
    val Error = DeepRed                        // Red for error states
    val Warning = Gold                         // Gold for warning states
}
