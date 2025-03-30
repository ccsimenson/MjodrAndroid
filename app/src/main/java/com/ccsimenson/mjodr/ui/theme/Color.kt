package com.ccsimenson.mjodr.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Viking-themed color palette for the app
 */
object VikingColors {
    // Primary Colors from Viking theme memory
    val DarkWood = Color(0xFF2E1E0F)  // Dark brown background
    val LightWood = Color(0xFFD2B48C)  // Light brown for buttons
    val Gold = Color(0xFFD4AF37)       // Soft gold for accents
    val DeepRed = Color(0xFF8B0000)    // Deep red for hover/active states
    val Parchment = Color(0xFFF5F5DC)  // Parchment for text on dark backgrounds
    val TextDark = Color(0xFF3E2723)   // Dark brown text on light backgrounds
    val TextLight = Color(0xFFF5F5DC)  // Light text for dark backgrounds (same as Parchment)
    val Red = Color(0xFFC62828)        // Red for error messages
    val Green = Color(0xFF2E7D32)      // Green for success states and beginner difficulty
    val Background = Color(0xFF1A1209)  // Darker background for app

    // Alpha Variations for UI effects
    val LightWoodAlpha70 = Color(0xB3B08968)  // For semi-transparent overlays
    val GoldAlpha50 = Color(0x80DAA520)       // For subtle highlights
    val ParchmentAlpha90 = Color(0xE6F5E6D3)  // For text field backgrounds

    // Additional Theme Colors
    val DarkWoodLight = Color(0xFF3C2820)     // Lighter version of DarkWood for layering
    val GoldDark = Color(0xFFC69500)          // Darker gold for pressed states
    val DeepRedLight = Color(0xFF9B1010)      // Lighter red for hover states
    
    // Semantic Colors
    val Success = Green                       // Green for success states
    val Error = Red                           // Red for error states
    val Warning = Gold                        // Gold for warning states
}
