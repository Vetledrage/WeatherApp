package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.DisplayImage
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.pickBear
import org.junit.Assert.assertEquals
import org.junit.Test
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
class BearPickerTests {

    @Test
    fun testPickBear_WhenTempAbove20_ReturnsPandaBear() {
        val result = pickBear(21)
        assertEquals("pandaBear", result)
    }

    @Test
    fun testPickBear_WhenTempBelowZero_ReturnsPolarBear() {
        val result = pickBear(-1)
        assertEquals("polarBear", result)
    }

    @Test
    fun testPickBear_WhenTempBetween0And20_ReturnsBrownBear() {
        val result = pickBear(10)
        assertEquals("brownBear", result)
    }
}



class DisplayImageTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displayImage_DisplaysPolarBear_WhenPolarBearIsProvided() {
        composeTestRule.setContent {
            DisplayImage(bear = "polarBear")
        }

        composeTestRule
            .onNodeWithContentDescription("Polar Bear")
            .assertIsDisplayed()
    }

    @Test
    fun displayImage_DisplaysBrownBear_WhenBrownBearIsProvided() {
        composeTestRule.setContent {
            DisplayImage(bear = "brownBear")
        }

        composeTestRule
            .onNodeWithContentDescription("Brown Bear")
            .assertIsDisplayed()
    }

    @Test
    fun displayImage_DisplaysPandaBear_WhenPandaBearIsProvided() {
        composeTestRule.setContent {
            DisplayImage(bear = "pandaBear")
        }

        composeTestRule
            .onNodeWithContentDescription("Panda Bear")
            .assertIsDisplayed()
    }
}
