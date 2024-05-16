package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import android.content.Context
import android.content.SharedPreferences
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*

/**
 * Class to manage the daily facts. Will ensure that a new fact is generated each day.
 *
 * @param context The context used to access application assets and preferences.
 */
class DailyFactManager(private val context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("DailyFactPrefs", Context.MODE_PRIVATE)

    /**
     * Gets the daily fact. If the stored date does not match the current date, a new fact is generated and stored.
     *
     * @return A string containing the daily fact.
     */
    fun getDailyFact(): String {
        val currentDate = getCurrentDate()
        val storedDate = preferences.getString("date", null)
        if (storedDate == null || storedDate != currentDate) {
            val newFact = generateRandomFact()
            preferences.edit().putString("date", currentDate).apply()
            preferences.edit().putString("fact", newFact).apply()
            return newFact
        }
        return preferences.getString("fact", "No fact available") ?: "No fact available"
    }

    /**
     * Gets the current date formatted as "yyyy-MM-dd".
     *
     * @return A string representing the current date.
     */
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(Date())
    }

    /**
     * Generates a random fact by reading from a "facts.csv" file in the assets.
     *
     * @return A string containing a randomly selected fact.
     */
    private fun generateRandomFact(): String {
        val facts = mutableListOf<String>()
        try {
            context.assets.open("facts.csv").use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        line?.let { facts.add(it) }
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (facts.isEmpty()) {
            return "No facts available"
        }
        return facts.random()
    }
}