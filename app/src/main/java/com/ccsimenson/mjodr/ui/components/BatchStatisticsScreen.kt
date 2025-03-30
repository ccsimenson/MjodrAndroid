package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccsimenson.mjodr.data.BatchStatistics
import com.ccsimenson.mjodr.ui.theme.VikingTheme
import com.ccsimenson.mjodr.ui.viewmodels.BatchStatisticsViewModel

@Composable
fun BatchStatisticsScreen(
    batchId: String,
    viewModel: BatchStatisticsViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val statistics by viewModel.statistics.collectAsState(initial = BatchStatistics())

    LaunchedEffect(batchId) {
        viewModel.loadStatistics(batchId)
    }

    VikingTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Batch Statistics",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Total Measurements: ${statistics.totalMeasurements}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Days Fermenting: ${statistics.daysFermenting}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "ABV Trend",
                    style = MaterialTheme.typography.titleLarge
                )
                VikingLineChartComposable(
                    data = statistics.abvTrend,
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Temperature Trend",
                    style = MaterialTheme.typography.titleLarge
                )
                VikingBarChartComposable(
                    data = statistics.temperatureTrend,
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )
            }
        }
    }
}
