package com.ccsimenson.mjodr.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.unit.sp

private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Using UnifrakturMaguntia as our Viking-style font
private val UnifrakturMaguntia = FontFamily(
    Font(
        googleFont = GoogleFont("UnifrakturMaguntia"),
        fontProvider = provider,
        weight = FontWeight.Normal
    )
)

// Using Cinzel as our secondary Viking-style font for better readability
private val Cinzel = FontFamily(
    Font(
        googleFont = GoogleFont("Cinzel"),
        fontProvider = provider,
        weight = FontWeight.Normal
    ),
    Font(
        googleFont = GoogleFont("Cinzel"),
        fontProvider = provider,
        weight = FontWeight.Bold
    )
)

val VikingTypography = Typography(
    // Main Title (32sp)
    displayLarge = TextStyle(
        fontFamily = UnifrakturMaguntia,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    // Section Title (24sp)
    displayMedium = TextStyle(
        fontFamily = UnifrakturMaguntia,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    // Subtitle (20sp)
    titleLarge = TextStyle(
        fontFamily = Cinzel,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    // Body Large (16sp)
    bodyLarge = TextStyle(
        fontFamily = Cinzel,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    // Body Medium (14sp)
    bodyMedium = TextStyle(
        fontFamily = Cinzel,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.15.sp
    ),
    // Button Text (16sp bold)
    labelLarge = TextStyle(
        fontFamily = Cinzel,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    // Input Field Labels (12sp)
    labelMedium = TextStyle(
        fontFamily = Cinzel,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    // Helper Text (10sp)
    labelSmall = TextStyle(
        fontFamily = Cinzel,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    )
)
