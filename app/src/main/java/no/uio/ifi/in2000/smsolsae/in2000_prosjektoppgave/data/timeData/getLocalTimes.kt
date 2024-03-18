package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


//Returnerer nåværende dato og tid.

fun getLiveDateTime(): String {
    val calendarFormat = SimpleDateFormat("dd:MM:yyyy HH:mm:ss", Locale.getDefault())
    var todaysDate = calendarFormat.format(Calendar.getInstance().time)
    return todaysDate
}