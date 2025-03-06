package com.ccsimenson.mjodr.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VikingButton(
    text: String,
    onClick: () -> Unit,
    isSecondary: Boolean = false,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp) // Viking theme: 10px padding
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!isSecondary) VikingColors.LightWood else VikingColors.DarkWoodLight,
            contentColor = if (!isSecondary) VikingColors.TextDark else VikingColors.Gold
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,  // Viking theme: raised relief
            pressedElevation = 5.dp
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}
