package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import android.content.Context
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R

/**
 * Gets a weather icon based on string input
 * @param symbolCode The weather id we get
 * @param context The Context of the app.
 * @return The weather icon corresponding to the string. If none of the symbol names match, a default value, sunny, is returned.
 */
fun getWeatherIcon(context: Context, symbolCode: String?): Int {
    var resName = symbolCode
    if (resName == null){
        resName = "lightsnow"
    }

    val resId = context.resources.getIdentifier(resName, "drawable", context.packageName)
    return if (resId != 0){
        resId
    }else{
        R.drawable.clearsky_day
    }
}

