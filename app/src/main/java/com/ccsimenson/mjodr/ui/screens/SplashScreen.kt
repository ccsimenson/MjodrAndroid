package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.theme.VikingColors

/**
 * Viking-themed splash screen for the Mjöðr app
 * Displays the app icon, title, and subtitle with Norse-inspired design elements
 */
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(VikingColors.DarkWood)
    ) {
        // Wood texture background
        Image(
            painter = painterResource(id = R.drawable.wood_texture),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.15f
        )
        
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App Icon
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "Mjöðr App Icon",
                modifier = Modifier.size(120.dp)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // App Title
            Text(
                text = "Mjöðr",
                color = VikingColors.Gold,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // App Subtitle
            Text(
                text = "Viking Mead Calculator",
                color = VikingColors.Parchment,
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
        }
        
        // Norse Border at bottom
        Image(
            painter = painterResource(id = R.drawable.norse_border),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
                .fillMaxWidth()
        )
    }
}
