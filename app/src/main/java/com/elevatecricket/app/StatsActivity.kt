package com.elevatecricket.app

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class StatsActivity : AppCompatActivity() {
    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        barChart = findViewById(R.id.barChart)
        val prefManager = SharedPrefManager(this)

        val entries = listOf(
            BarEntry(1f, prefManager.getWorkoutCount("Week1").toFloat()),
            BarEntry(2f, prefManager.getWorkoutCount("Week2").toFloat()),
            BarEntry(3f, prefManager.getWorkoutCount("Week3").toFloat()),
            BarEntry(4f, prefManager.getWorkoutCount("Week4").toFloat())
        )

        val barDataSet = BarDataSet(entries, "Weekly Workouts")
        barDataSet.color = Color.parseColor("#4CAF50")

        val data = BarData(barDataSet)
        data.barWidth = 0.5f
        barChart.data = data

        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.axisLeft.axisMinimum = 0f
        barChart.axisRight.isEnabled = false
        barChart.description.text = "Workout Progress"
        barChart.animateY(1000)
        barChart.invalidate()
    }
}
