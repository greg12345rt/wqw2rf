package com.elevatecricket.app

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("ElevatePrefs", Context.MODE_PRIVATE)

    fun saveGoal(week: String, goal: String) {
        prefs.edit().putString("goal_$week", goal).apply()
    }

    fun getGoal(week: String): String {
        return prefs.getString("goal_$week", "") ?: ""
    }

    fun saveWorkoutCount(week: String, count: Int) {
        prefs.edit().putInt("workoutCount_$week", count).apply()
    }

    fun getWorkoutCount(week: String): Int {
        return prefs.getInt("workoutCount_$week", 0)
    }
}
