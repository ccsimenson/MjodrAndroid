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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ccsimenson.mjodr.data.YoutubeVideo
import com.ccsimenson.mjodr.ui.theme.VikingColors

/**
 * A card component for displaying a YouTube recipe video
 * Styled with the Viking theme colors
 */
@Composable
fun RecipeVideoItem(
    video: YoutubeVideo,
    onClick: (YoutubeVideo) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick(video) },
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.LightWood.copy(alpha = 0.9f),
            contentColor = VikingColors.TextDark
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Thumbnail
            Box(
                modifier = Modifier
                    .size(width = 120.dp, height = 90.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(VikingColors.DarkWood)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(video.snippet?.thumbnails?.medium?.url)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Video thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            
            // Video details
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            ) {
                Text(
                    text = video.snippet?.title ?: "Unknown Title",
                    style = MaterialTheme.typography.titleMedium,
                    color = VikingColors.TextDark,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = video.snippet?.channelTitle ?: "Unknown Channel",
                    style = MaterialTheme.typography.bodyMedium,
                    color = VikingColors.TextDark.copy(alpha = 0.7f)
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = video.snippet?.description ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    color = VikingColors.TextDark.copy(alpha = 0.6f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
