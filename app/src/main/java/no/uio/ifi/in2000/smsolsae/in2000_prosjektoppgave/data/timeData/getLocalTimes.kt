package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone
import kotlin.random.Random


//Returnerer nåværende dato og tid.

fun getLiveDateTime(): String {
    val dateFormat = SimpleDateFormat("dd.MMMM hh:mm a", Locale.getDefault())
    return dateFormat.format(Calendar.getInstance().time)
}

fun getNext7Dates(): List<String>{
    val dateFormat = SimpleDateFormat("dd.MM", Locale.getDefault())
    val dates = mutableListOf<String>()
    val calendar = Calendar.getInstance()

    for (i in 0 until 7){
        dates.add(dateFormat.format(calendar.time))
        calendar.add(Calendar.DAY_OF_WEEK, 1)
    }
    return dates
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


//Returnere en liste med de neste 12 timene
fun getNext12Hours() : List<String>{
    val timeFormat = SimpleDateFormat("hh a", Locale.getDefault())
    val times = mutableListOf<String>()
    val calendar = Calendar.getInstance()

    for (i in 0 until 12){
        times.add(timeFormat.format(calendar.time))
        calendar.add(Calendar.HOUR_OF_DAY, 1)
    }

    return times
}

fun getRandomTemp(): Int{
    return Random.nextInt(-20, 35)
}

fun getIconId(temp: Int): Int{
    if (temp <= 0){
        return R.drawable.ic_snowy
    }else if(temp in 0..12){
        return R.drawable.ic_rainy
    } else if(temp in 12 .. 24){
        return R.drawable.ic_sunnycloudy
    } else{
        return R.drawable.ic_sunny
    }
}