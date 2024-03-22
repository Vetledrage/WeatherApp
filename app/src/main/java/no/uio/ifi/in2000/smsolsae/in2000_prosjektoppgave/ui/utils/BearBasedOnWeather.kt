package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R

//Returns a string with bear-type based Temperature (Double)
fun pickBear(temp: Double) : String{
    return if (temp > 20) "pandaBear"
    else if (temp < 0) "polarBear"
    else "brownBear"
}

//Displays image based on strig input
@Composable
fun DisplayImage(bear: String) {
    var bearImage = painterResource(R.drawable.brown_bear) //default
    var bearDescription = "Brown Bear" //default
    when(bear) {
        "polarBear" -> {
            bearImage = painterResource(R.drawable.polar_bear)
            bearDescription = "Polar Bear"}
        "brownBear" -> {
            bearImage = painterResource(R.drawable.brown_bear)
            bearDescription = "Brown Bear"}
        "pandaBear" -> {
            bearImage = painterResource(R.drawable.panda_bear)
            bearDescription = "Panda Bear"}
    }
    Box {
        Image(
            painter = bearImage,
            contentDescription = bearDescription,
            contentScale = ContentScale.Crop,
            alpha = 1.0F
        )
    }
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MVPDemo(){
    var unitInput: Double by remember { mutableDoubleStateOf(0.0) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        TextField(
            value = "$unitInput",
            onValueChange = { unitInput = it.toDouble()},
            label = { Text("Amount (Integer) to convert:") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )
        DisplayImage(bear = pickBear(unitInput))
    }
}


//Preview - change temp to change preview
@Preview(showSystemUi = true)
@Composable
fun PreviewBearImage(){
    //DisplayImage(bear = pickBear(22.0))
    MVPDemo()
}
