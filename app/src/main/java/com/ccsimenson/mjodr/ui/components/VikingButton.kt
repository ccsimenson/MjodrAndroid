package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.ui.theme.VikingColors

@Composable
fun VikingButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 48.dp)
            .padding(10.dp),  // Viking theme requirement: 10px padding
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = VikingColors.LightWood,        // Light wood brown (#B08968)
            contentColor = VikingColors.TextDark,           // Dark text on light background
            disabledContainerColor = VikingColors.LightWoodAlpha70,
            disabledContentColor = VikingColors.TextDark.copy(alpha = 0.6f)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,                        // Raised relief effect
            pressedElevation = 2.dp,
            disabledElevation = 0.dp
        ),
        contentPadding = PaddingValues(16.dp)              // Internal content padding
    ) {
        Text(
            text = text,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )
    }
}
