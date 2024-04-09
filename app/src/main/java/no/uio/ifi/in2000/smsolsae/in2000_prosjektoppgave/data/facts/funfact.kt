package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.facts

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.time.LocalDate
import kotlin.random.Random

fun readSpecificLine(filename: String, lineNumber: Int): String? {
    var lineCount = 0
    File(filename).useLines { lines ->
        for (line in lines) {
            if (lineCount == lineNumber - 1) {
                return line // Assuming CSV is comma-separated, adjust delimiter if needed
            }
            lineCount++
        }
    }
    return null
}
@RequiresApi(Build.VERSION_CODES.O)
fun factByDay(): String {
    val current = LocalDate.now()
    return "hei"
}
fun factByRandom() {
    val filename = "facts.csv"
    val lineNumber = Random.nextInt(0, 99)
    val chosenLine = readSpecificLine(filename, lineNumber)
    if (chosenLine != null) {
        println("Chosen line $lineNumber: $chosenLine")
    } else {
        println("Line $lineNumber not found in file.")
    }
}