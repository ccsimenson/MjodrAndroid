package com.ccsimenson.mjodr.ui.components.charts

import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter

class VikingBarChart(context: Context) : BarChart(context) {

    init {
        setBackgroundColor(Color.parseColor("#2C1B0D"))
        description.isEnabled = false
        legend.isEnabled = false
        setTouchEnabled(true)
        isDragEnabled = true
        setScaleEnabled(true)
        setPinchZoom(true)

        // Configure X axis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.textColor = Color.parseColor("#F5F5DC")

        // Configure Y axis
        axisLeft.textColor = Color.parseColor("#F5F5DC")
        axisRight.isEnabled = false
    }

    fun setData(data: List<Double>, barColor: Int) {
        val entries = data.mapIndexed { index, value ->
            BarEntry(index.toFloat(), value.toFloat())
        }

        val dataSet = BarDataSet(entries, "")
        dataSet.color = barColor
        dataSet.valueTextColor = Color.parseColor("#F5F5DC")
        dataSet.valueTextSize = 10f

        this.data = BarData(dataSet)
        invalidate()
    }

    fun setTitle(title: String) {
        description.isEnabled = true
        description.text = title
        description.textColor = Color.parseColor("#F5F5DC")
        description.textSize = 16f
    }

    fun setXAxisLabel(label: String) {
        xAxis.labelCount = 5
        xAxis.granularity = 1f
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return "$label ${value.toInt()}"
            }
        }
    }

    fun setYAxisLabel(label: String) {
        axisLeft.labelCount = 5
        axisLeft.granularity = 1f
        axisLeft.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return "$label ${value.toInt()}"
            }
        }
    }
}
