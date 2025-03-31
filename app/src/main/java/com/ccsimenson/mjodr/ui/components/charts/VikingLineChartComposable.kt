package com.ccsimenson.mjodr.ui.components.charts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.ccsimenson.mjodr.ui.components.charts.VikingLineChart
import android.graphics.Color

@Composable
fun VikingLineChartComposable(
    data: List<Double>,
    title: String,
    xAxisLabel: String,
    yAxisLabel: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val chart = VikingLineChart(context)
    
    chart.apply {
        setData(data, Color.parseColor("#FFD700"))
        setTitle(title)
        setXAxisLabel(xAxisLabel)
        setYAxisLabel(yAxisLabel)
    }
    
    AndroidView(
        factory = { chart },
        modifier = modifier
    ) { view ->
        view.invalidate()
    }
}
