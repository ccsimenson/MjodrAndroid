package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.data.BatchStatus
import com.ccsimenson.mjodr.data.MeadBatch
import com.ccsimenson.mjodr.ui.theme.VikingColors
import java.text.DecimalFormat

/**
 * A list item component for displaying a mead batch
 * Styled with the Viking theme
 */
@Composable
fun BatchListItem(
    batch: MeadBatch,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val decimalFormat = DecimalFormat("#.##")
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.LightWood,
            contentColor = VikingColors.TextDark
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Batch name and status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = batch.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = VikingColors.TextDark
                )
                
                StatusBadge(status = batch.status)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Batch details
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Started: ${batch.formattedStartDate}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = VikingColors.TextDark
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Text(
                        text = "Days: ${batch.daysInFermentation}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = VikingColors.TextDark
                    )
                }
                
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "OG: ${decimalFormat.format(batch.originalGravity)}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = VikingColors.TextDark
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Text(
                        text = "Current ABV: ${decimalFormat.format(batch.currentAbv)}%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = VikingColors.TextDark
                    )
                }
            }
            
            // Recipe preview if available
            if (batch.recipe.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = batch.recipe,
                    style = MaterialTheme.typography.bodySmall,
                    color = VikingColors.TextDark.copy(alpha = 0.7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/**
 * A badge component for displaying batch status
 * Styled with the Viking theme
 */
@Composable
fun StatusBadge(
    status: BatchStatus,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, textColor) = when (status) {
        BatchStatus.PLANNING -> VikingColors.Gold.copy(alpha = 0.7f) to VikingColors.TextDark
        BatchStatus.FERMENTING -> VikingColors.DeepRed.copy(alpha = 0.7f) to VikingColors.Parchment
        BatchStatus.AGING -> VikingColors.Gold to VikingColors.TextDark
        BatchStatus.BOTTLED -> VikingColors.LightWood.copy(alpha = 0.8f) to VikingColors.TextDark
        BatchStatus.COMPLETED -> VikingColors.DarkWood to VikingColors.Parchment
        BatchStatus.ARCHIVED -> VikingColors.TextDark to VikingColors.Parchment
    }
    
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = status.name,
            style = MaterialTheme.typography.bodySmall,
            color = textColor
        )
    }
}
