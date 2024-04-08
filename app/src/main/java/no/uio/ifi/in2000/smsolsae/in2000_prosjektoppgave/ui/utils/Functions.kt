package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


//Funksjon for å formattere tiden vi får fra api til å vise bare timer og min
fun formatTime(time: String): String{
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = inputFormat.parse(time)

    val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getDefault()

    return outputFormat.format(date)
}


//Funksjon for å fomatere dato fra Api til mer leselig og kortere versjon.
fun formatDate(date: String) : String{
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")

    val date = inputFormat.parse(date)

    val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getDefault()

    return outputFormat.format(date)
}

//hente dag bassert på dato
fun getDay(date: String): String{
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US) // Bruker Locale.US for engelsk
    format.timeZone = TimeZone.getTimeZone("UTC") // Sørger for at tiden tolkes som UTC
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
