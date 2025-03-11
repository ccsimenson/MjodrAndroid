package com.ccsimenson.mjodr.ui.components.charts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ccsimenson.mjodr.ui.components.charts.VikingBarChart

@Composable
fun VikingBarChartComposable(
    data: List<Double>,
    modifier: Modifier = Modifier
) {
    val chart = VikingBarChart(context = LocalContext.current)
    chart.setData(data, VikingTheme.colors.lightWood.toArgb())
    AndroidView(
        factory = { chart },
        modifier = modifier
    )
}
