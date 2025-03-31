package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccsimenson.mjodr.data.BatchStatistics
import com.ccsimenson.mjodr.ui.viewmodels.BatchStatisticsViewModel
import com.ccsimenson.mjodr.ui.components.charts.VikingLineChartComposable
import com.ccsimenson.mjodr.ui.components.charts.VikingBarChartComposable

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
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            VikingLineChartComposable(
                data = statistics.abvTrend,
                title = "ABV Trend",
                xAxisLabel = "Days",
                yAxisLabel = "ABV %"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Temperature Trend",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            VikingBarChartComposable(
                data = statistics.temperatureTrend,
                title = "Temperature Trend",
                xAxisLabel = "Days",
                yAxisLabel = "Temperature (°C)"
            )
        }
    }
}
