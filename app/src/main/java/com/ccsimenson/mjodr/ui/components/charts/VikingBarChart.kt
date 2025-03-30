package com.ccsimenson.mjodr.ui.components.charts

import android.content.Context
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.ccsimenson.mjodr.ui.theme.VikingTheme

class VikingBarChart(context: Context) : BarChart(context) {

    init {
        setBackgroundColor(VikingTheme.colors.darkWood.toArgb())
        description.isEnabled = false
        legend.isEnabled = false
        setTouchEnabled(true)
        isDragEnabled = true
        setScaleEnabled(true)
        setPinchZoom(true)

        // Configure X axis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.textColor = VikingTheme.colors.parchment.toArgb()

        // Configure Y axis
        axisLeft.textColor = VikingTheme.colors.parchment.toArgb()
        axisRight.isEnabled = false
    }

    fun setData(data: List<Double>, barColor: Int) {
        val entries = data.mapIndexed { index, value ->
            BarEntry(index.toFloat(), value.toFloat())
        }

        val dataSet = BarDataSet(entries, "")
        dataSet.color = barColor
        dataSet.valueTextColor = VikingTheme.colors.parchment.toArgb()

        this.data = BarData(dataSet)
        barData.barWidth = 0.5f
        invalidate()
    }
}
