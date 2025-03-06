package com.ccsimenson.mjodr.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Viking theme color scheme
private val VikingColorScheme = darkColorScheme(
    // Primary colors
    primary = VikingColors.LightWood,
    onPrimary = VikingColors.TextDark,
    primaryContainer = VikingColors.LightWoodAlpha70,
    onPrimaryContainer = VikingColors.TextDark,
    
    // Secondary colors
    secondary = VikingColors.Gold,
    onSecondary = VikingColors.TextDark,
    secondaryContainer = VikingColors.GoldAlpha50,
    onSecondaryContainer = VikingColors.TextDark,
    
    // Tertiary colors
    tertiary = VikingColors.DeepRed,
    onTertiary = VikingColors.Parchment,
    tertiaryContainer = VikingColors.DeepRedLight,
    onTertiaryContainer = VikingColors.Parchment,
    
    // Background and surface colors
    background = VikingColors.DarkWood,
    onBackground = VikingColors.Parchment,
    surface = VikingColors.DarkWoodLight,
    onSurface = VikingColors.Parchment,
    
    // Error colors
    error = VikingColors.Error,
    onError = VikingColors.Parchment,
    errorContainer = VikingColors.DeepRedLight,
    onErrorContainer = VikingColors.Parchment
)

@Composable
fun MjodrTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Set status bar color
            window.statusBarColor = VikingColorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = VikingColorScheme,
        typography = VikingTypography,
        content = content
    )
}
