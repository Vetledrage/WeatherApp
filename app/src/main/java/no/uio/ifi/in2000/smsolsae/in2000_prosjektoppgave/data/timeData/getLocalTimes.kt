package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
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
    val wholeDate = date.split("-")
    var year = wholeDate[0].toInt()
    var month = wholeDate[1].toInt()-1
    var day = wholeDate[2].toInt()

    val calendar = Calendar.getInstance()
    calendar.set(year, month, day)

    val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

    return dayFormat.format(calendar.time)
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