package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.theme.vikingFontFamily

/**
 * Screen displaying historical information about Viking brewing methods
 */
@Composable
fun VikingBrewingHistoryScreen(
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(VikingColors.DarkWood)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = stringResource(id = R.string.viking_brewing_title),
            fontFamily = vikingFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = VikingColors.Gold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // Introduction
        Text(
            text = stringResource(id = R.string.viking_brewing_intro),
            fontFamily = vikingFontFamily,
            fontSize = 18.sp,
            color = VikingColors.Parchment,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        
        // Section 1: The Sacred Craft
        HistorySection(
            titleResId = R.string.brewing_section_1_title,
            contentResId = R.string.brewing_section_1_content,
            iconResId = R.drawable.ic_launcher_foreground // Replace with appropriate icon
        )
        
        // Section 2: Ingredients of the North
        HistorySection(
            titleResId = R.string.brewing_section_2_title,
            contentResId = R.string.brewing_section_2_content,
            iconResId = R.drawable.ic_launcher_foreground // Replace with appropriate icon
        )
        
        // Section 3: Brewing Methods
        HistorySection(
            titleResId = R.string.brewing_section_3_title,
            contentResId = R.string.brewing_section_3_content,
            iconResId = R.drawable.ic_launcher_foreground // Replace with appropriate icon
        )
        
        // Section 4: Mead: Drink of Gods and Heroes
        HistorySection(
            titleResId = R.string.brewing_section_4_title,
            contentResId = R.string.brewing_section_4_content,
            iconResId = R.drawable.ic_launcher_foreground // Replace with appropriate icon
        )
        
        // Section 5: Ritual and Celebration
        HistorySection(
            titleResId = R.string.brewing_section_5_title,
            contentResId = R.string.brewing_section_5_content,
            iconResId = R.drawable.ic_launcher_foreground // Replace with appropriate icon
        )
        
        // Section 6: Legacy of Viking Brewing
        HistorySection(
            titleResId = R.string.brewing_section_6_title,
            contentResId = R.string.brewing_section_6_content,
            iconResId = R.drawable.ic_launcher_foreground // Replace with appropriate icon
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Return button
        VikingButton(
            text = "Return to Mead Hall",
            onClick = onNavigateBack
        )
        
        Spacer(modifier = Modifier.height(16.dp))
    }
}

/**
 * Composable for a section of the brewing history
 */
@Composable
fun HistorySection(
    titleResId: Int,
    contentResId: Int,
    iconResId: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.DarkWoodLight
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Section title with icon
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                // Icon
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(VikingColors.Gold.copy(alpha = 0.2f))
                        .padding(4.dp)
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                // Section title
                Text(
                    text = stringResource(id = titleResId),
                    fontFamily = vikingFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = VikingColors.Gold
                )
            }
            
            Divider(
                color = VikingColors.Gold.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            
            // Section content
            Text(
                text = stringResource(id = contentResId),
                fontFamily = vikingFontFamily,
                fontSize = 16.sp,
                color = VikingColors.Parchment,
                lineHeight = 24.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
