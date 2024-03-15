package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R

@Composable
fun FrontPage(){
    Column {

        TekstVedSun()
        ShowSun()
        TekstTemp()


    }
}
@Composable
fun ShowSun(){
    ConstraintLayout(
        //modifier = Modifier.fillMaxSize()
    ){
        val (sun) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.sun),
            contentDescription = "sol",
            modifier = Modifier
                .size(300.dp, 150.dp)
                .constrainAs(sun) {
                    linkTo(parent.start, parent.end, bias = 0.50f)
                    linkTo(parent.top, parent.bottom, bias = 0.2f)

                }
        )
    }
}

@Composable
fun TekstVedSun(){
    Row(
        modifier = Modifier
            .padding(40.dp)
    ){
        Text(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            text = "15.03.24 Fredag")
    }
}

@Composable
fun TekstTemp(){
    Row(
        modifier = Modifier
            .padding(40.dp)
    ){


            Text(
            style = TextStyle(color = Color.Black, fontSize = 28.sp),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            text = "18 grader")
    }
}




@Composable
@Preview (showSystemUi = true)
fun ShowSunPreview(){
    FrontPage()
}