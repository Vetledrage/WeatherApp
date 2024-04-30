package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.formatAlertsDate
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.formatDate
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.formatTime
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getBearImageResource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getDay
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getLiveDateTime
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.pickBear
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
//Test must be changed to the appropiate new names they have been given in BearBasedOnWeather File
//Test to see if we get the right bear from the temperature
class BearPickerTests {

    @Test
    fun testPickBear_PolarBear() {
        //temp: < -5
        val result = pickBear(temperature = -6)
        assertEquals("polarBear", result)
    }

    @Test
    fun testPickBear_AmericanBlackBear() {
        //temp: -5 <= temp < 30, humid&weather: not that of another bear's
        val resultLow = pickBear(temperature = -5)
        val resultMid = pickBear(temperature = 15, humidity = 69) //notRainyOrFoggy
        val resultHigh = pickBear(temperature = 29, humidity = 69, weatherCode = "cloudy") //notRainyOrSunny
        assertEquals("americanBlackBear", resultLow)
        assertEquals("americanBlackBear", resultMid)
        assertEquals("americanBlackBear", resultHigh)
    }

    @Test
    fun testPickBear_AsianBlackBear() {
        //temp: 15 <= temp < 30, weather: rainy
        val resultLow = pickBear(temperature = 15, weatherCode = "rain")
        val resultHigh = pickBear(temperature = 29, weatherCode = "rain")
        assertEquals("asianBlackBear", resultLow)
        assertEquals("asianBlackBear", resultHigh)
    }

    @Test
    fun testPickBear_BrownBear() {
        //temp: -5 <= temp < 15, weather: rainy, snow, sleet
        val resultLow = pickBear(temperature = -5, weatherCode = "snow")
        val resultHigh = pickBear(temperature = 14, weatherCode = "rain")
        assertEquals("brownBear", resultLow)
        assertEquals("brownBear", resultHigh)
    }

    @Test
    fun testPickBear_SpectacledBear() {
        //temp: 5 <= temp < 25, weather: cloudy or foggy
        val resultLow = pickBear(temperature = 5, weatherCode = "cloudy")
        val resultHigh = pickBear(temperature = 24, weatherCode = "cloudy")
        assertEquals("spectacledBear", resultLow)
        assertEquals("spectacledBear", resultHigh)
    }

    @Test
    fun testPickBear_PandaBear() {
        //temp: 10 <= temp < 20, humidity >= 70, weather: not rainy
        val resultLow = pickBear(temperature = 10, humidity = 70)
        val resultHigh = pickBear(temperature = 19, humidity = 70)
        assertEquals("pandaBear", resultLow)
        assertEquals("pandaBear", resultHigh)
    }

    @Test
    fun testPickBear_SunBear() {
        //temp: 20-29, humidity: < 70 (when temp >= 25), weather: sunny
        val resultLow = pickBear(temperature = 20, humidity = 69, weatherCode = "clearsky_day")
        val resultHigh = pickBear(temperature = 29, humidity = 69, weatherCode = "clearsky_day")
        assertEquals("sunBear", resultLow)
        assertEquals("sunBear", resultHigh)
    }

    @Test
    fun testPickBear_SlothBear() {
        //Case 1 -> temp: 25 <= temp < 30, humidity: >= 70, weather: not rainy or sunny
        //Case 2 -> temp: <=30
        val resultLow = pickBear(temperature = 25, humidity = 70, weatherCode = "cloudy")
        val resultHigh = pickBear(temperature = 30)
        assertEquals("slothBear", resultLow)
        assertEquals("slothBear", resultHigh)
    }

    @Test
    fun testPickBear_RedPanda() { //OBS: not fully implemented in app
        //error = true
        val result = pickBear(error = true)
        assertEquals("redPanda", result)
    }
}


//Testing to see if the displayed images are correct
class DisplayImageTests {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun displayImage_PolarBear() {
        composeTestRule.setContent {
            Image(
                painter = painterResource(getBearImageResource("polarBear")),
                contentDescription = "Polar Bear Image"
            )
        }
        composeTestRule.onNodeWithContentDescription("Polar Bear Image").assertIsDisplayed()
    }

    @Test
    fun displayImage_BrownBear() {
        composeTestRule.setContent {
            Image(
                painter = painterResource(getBearImageResource("brownBear")),
                contentDescription = "Brown Bear Image"
            )
        }
        composeTestRule.onNodeWithContentDescription("Brown Bear Image").assertIsDisplayed()
    }

    @Test
    fun displayImage_PandaBear() {
        composeTestRule.setContent {
            Image(
                painter = painterResource(getBearImageResource("pandaBear")),
                contentDescription = "Panda Bear Image"
            )
        }
        composeTestRule.onNodeWithContentDescription("Panda Bear Image").assertIsDisplayed()
    }
}



class TimeFormatTests {

    @Test
    fun testFormatTime() {
        val time = "2024-04-04T04:00:00Z"
        val expected = "04:00"
        assertEquals(expected, formatTime(time))
    }

    @Test
    fun testFormatDate() {
        val date = "2024-04-04T04:00:00Z"
        val expected = "04.04.2024"
        assertEquals(expected, formatDate(date))
    }

    @Test
    fun testFormatAlertsDate() {
        val date = "2024-04-04T04:00:00+00:00"
        val expected = "04.04.2024"
        assertEquals(expected, formatAlertsDate(date))
    }

    @Test
    fun testGetDay() {
        val date = "2024-04-04T04:00:00Z"
        val expected = "Thursday"
        assertEquals(expected, getDay(date))
    }

    @Test
    fun testGetLiveDateTime() {
        // This is tricky because it uses the current date and time
        // To test this, you might consider using a library like Mockito to mock `Calendar.getInstance()`
        // Or adjust the test to only verify the format of the return string matches expected regex.
        val result = getLiveDateTime()
        val regex = "\\d{2}\\.\\w+ \\d{2}:\\d{2}".toRegex()
        assert(result.matches(regex))
    }
}