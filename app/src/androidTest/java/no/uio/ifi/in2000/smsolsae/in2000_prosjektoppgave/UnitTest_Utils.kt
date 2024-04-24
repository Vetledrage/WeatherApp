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
    fun testPickBear_WhenTempAbove20AndSunny_ReturnsSunBear() {
        val result = pickBear(21, 50, "sunny")
        assertEquals("sunBear", result)
    }

    @Test
    fun testPickBear_WhenTempBelowZero_ReturnsPolarBear() {
        val result = pickBear(-6, 50, "snowy")
        assertEquals("polarBear", result)
    }

    @Test
    fun testPickBear_WhenTempBetween0And20AndRainy_ReturnsBrownBear() {
        val result = pickBear(10, 50, "rainy")
        assertEquals("brownBear", result)
    }

    @Test
    fun testPickBear_WhenHighHumidityAndModerateTemperature_ReturnsPandaBear() {
        val result = pickBear(14, 80, "cloudy")
        assertEquals("pandaBear", result)
    }
}


//Testing to see if the displayed images are correct
class DisplayImageTests {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun displayImage_DisplaysPolarBear_WhenPolarBearIsProvided() {
        composeTestRule.setContent {
            Image(
                painter = painterResource(getBearImageResource("polarBear")),
                contentDescription = "Polar Bear Image"
            )
        }
        composeTestRule.onNodeWithContentDescription("Polar Bear Image").assertIsDisplayed()
    }

    @Test
    fun displayImage_DisplaysBrownBear_WhenBrownBearIsProvided() {
        composeTestRule.setContent {
            Image(
                painter = painterResource(getBearImageResource("brownBear")),
                contentDescription = "Brown Bear Image"
            )
        }
        composeTestRule.onNodeWithContentDescription("Brown Bear Image").assertIsDisplayed()
    }

    @Test
    fun displayImage_DisplaysPandaBear_WhenPandaBearIsProvided() {
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