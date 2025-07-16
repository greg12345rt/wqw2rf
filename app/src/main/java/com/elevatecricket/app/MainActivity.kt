package com.elevatecricket.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goalInput = findViewById<EditText>(R.id.goalInput)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val calendarButton = findViewById<Button>(R.id.calendarButton)
        val statsButton = findViewById<Button>(R.id.statsButton)

        val prefManager = SharedPrefManager(this)
        val currentWeek = "Week1"

        saveButton.setOnClickListener {
            val goalText = goalInput.text.toString()
            prefManager.saveGoal(currentWeek, goalText)
            Toast.makeText(this, "Goal saved!", Toast.LENGTH_SHORT).show()
        }

        val savedGoal = prefManager.getGoal(currentWeek)
        goalInput.setText(savedGoal)

        calendarButton.setOnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))
        }

        statsButton.setOnClickListener {
            startActivity(Intent(this, StatsActivity::class.java))
        }
    }
}
