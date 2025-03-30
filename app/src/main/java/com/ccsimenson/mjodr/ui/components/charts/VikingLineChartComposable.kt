package com.ccsimenson.mjodr.ui.components.charts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ccsimenson.mjodr.ui.components.charts.VikingLineChart

@Composable
fun VikingLineChartComposable(
    data: List<Double>,
    modifier: Modifier = Modifier
) {
    val chart = VikingLineChart(context = LocalContext.current)
    chart.setData(data, VikingTheme.colors.gold.toArgb())
    AndroidView(
        factory = { chart },
        modifier = modifier
    )
}
