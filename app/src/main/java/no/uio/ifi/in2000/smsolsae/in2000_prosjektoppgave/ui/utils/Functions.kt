package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun formatTime(time: String): String{
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = inputFormat.parse(time)

    val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getDefault()

    return outputFormat.format(date)
}