package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


/**
 * Function for formatting the time we get from the API to show only hours and minutes.
 *
 * @param time The time expressed as a string
 * @return the time showing only hours and minutes
 */
fun formatTime(time: String): String{
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = inputFormat.parse(time)

    val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getDefault()

    return outputFormat.format(date)
}


/**
 * Function for formatting data from API to be shorter and more readable
 * @param date The date
 * @return The date in a shorter and more readable format
 */
fun formatDate(date: String) : String{
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())


    val date = inputFormat.parse(date)

    val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getDefault()

    return outputFormat.format(date)
}

/**
 * Function for formatting data from metalerts API to be shorter and more readable
 * @param date The date
 * @return The date in a shorter and more readable format
 */

fun formatAlertsDate(date: String) : String{
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")

    val date = inputFormat.parse(date)

    val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getDefault()

    return outputFormat.format(date)
}

//hente dag bassert på dato
fun getDay(date: String): String{
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US) // Bruker Locale.US for engelsk

    val date = format.parse(date) ?: return "Unknown"

    val calendar = Calendar.getInstance()
    calendar.time = date

    // Bruker SimpleDateFormat igjen for å utlede dagen i uken på engelsk
    val dayFormat = SimpleDateFormat("EEEE", Locale.US) // 'EEEE' representerer fullstendig navn på ukedagen

    return dayFormat.format(date)
}

//Returnerer nåværende dato og tid.

fun getLiveDateTime(): String {
    val dateFormat = SimpleDateFormat("dd.MMMM HH:mm", Locale.getDefault())
    return dateFormat.format(Calendar.getInstance().time)
}
