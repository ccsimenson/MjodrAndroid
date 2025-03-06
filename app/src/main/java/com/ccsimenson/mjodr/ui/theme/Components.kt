package com.ccsimenson.mjodr.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VikingButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = VikingColors.LightWood,
            contentColor = VikingColors.TextDark
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = VikingColors.TextDark
        )
    }
}

@Composable
fun VikingTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, style = MaterialTheme.typography.bodyLarge) },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(8.dp)
            ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = VikingColors.Parchment,
            unfocusedContainerColor = VikingColors.Parchment,
            focusedTextColor = VikingColors.TextDark,
            unfocusedTextColor = VikingColors.TextDark,
            focusedBorderColor = VikingColors.Gold,
            unfocusedBorderColor = VikingColors.LightWood
        ),
        shape = RoundedCornerShape(8.dp),
        textStyle = MaterialTheme.typography.bodyLarge
    )
}
