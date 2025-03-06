package com.ccsimenson.mjodr.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Viking theme color scheme
private val VikingColorScheme = darkColorScheme(
    // Primary colors
    primary = VikingColors.Gold,
    onPrimary = VikingColors.TextDark,
    primaryContainer = VikingColors.LightWood,
    onPrimaryContainer = VikingColors.TextDark,
    
    // Secondary colors
    secondary = VikingColors.DeepRed,
    onSecondary = VikingColors.Parchment,
    secondaryContainer = VikingColors.DeepRedLight,
    onSecondaryContainer = VikingColors.Parchment,
    
    // Tertiary colors
    tertiary = VikingColors.LightWood,
    onTertiary = VikingColors.TextDark,
    tertiaryContainer = VikingColors.LightWoodAlpha70,
    onTertiaryContainer = VikingColors.TextDark,
    
    // Background and surface colors
    background = VikingColors.DarkWood,
    onBackground = VikingColors.Parchment,
    surface = VikingColors.DarkWood,
    onSurface = VikingColors.Parchment,
    surfaceVariant = VikingColors.DarkWoodLight,
    onSurfaceVariant = VikingColors.Parchment,
    
    // Error colors
    error = VikingColors.Error,
    onError = VikingColors.Parchment,
    errorContainer = VikingColors.DeepRedLight,
    onErrorContainer = VikingColors.Parchment,
    
    // Additional colors
    outline = VikingColors.Gold,
    outlineVariant = VikingColors.GoldAlpha50
)

@Composable
fun MjodrTheme(
    darkTheme: Boolean = true, // Always use dark theme as base for Viking aesthetic
    content: @Composable () -> Unit
) {
    val colorScheme = VikingColorScheme
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Set status bar color
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
            
            // Set navigation bar color
            window.navigationBarColor = colorScheme.background.toArgb()
            
            // Enable edge-to-edge
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = VikingTypography,
        content = content
    )
}
