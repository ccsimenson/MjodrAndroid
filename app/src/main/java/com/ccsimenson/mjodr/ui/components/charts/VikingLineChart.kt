package com.ccsimenson.mjodr.ui.components.charts

import android.content.Context
import android.widget.LinearLayout
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.ccsimenson.mjodr.ui.theme.VikingTheme

class VikingLineChart(context: Context) : LineChart(context) {

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

    fun setData(data: List<Double>, lineColor: Int) {
        val entries = data.mapIndexed { index, value ->
            Entry(index.toFloat(), value.toFloat())
        }

        val dataSet = LineDataSet(entries, "")
        dataSet.color = lineColor
        dataSet.valueTextColor = VikingTheme.colors.parchment.toArgb()
        dataSet.lineWidth = 2f
        dataSet.setCircleColor(lineColor)
        dataSet.circleRadius = 4f
        dataSet.setDrawCircleHole(false)

        this.data = LineData(dataSet)
        invalidate()
    }
}
