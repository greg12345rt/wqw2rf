package com.elevatecricket.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private val eventDays = mutableListOf<EventDay>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)

        val trainingDay = Calendar.getInstance()
        trainingDay.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY)
        eventDays.add(EventDay(trainingDay, R.drawable.ic_event))

        calendarView.setEvents(eventDays)

        calendarView.setOnDayClickListener { eventDay ->
            val clickedDayCalendar = eventDay.calendar
            val msg = "Selected: ${clickedDayCalendar.get(Calendar.DAY_OF_MONTH)}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
