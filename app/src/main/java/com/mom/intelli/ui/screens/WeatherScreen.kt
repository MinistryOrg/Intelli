package com.mom.intelli.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

<<<<<<< Updated upstream
import coil.compose.AsyncImagePainter.State.Empty.painter
=======
>>>>>>> Stashed changes
import com.mom.intelli.R
import com.mom.intelli.data.weather.WeatherData
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite


@Composable
fun WeatherWidget(
    paddingValues: Dp,
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    var weather by remember {
        mutableStateOf<WeatherData?>(null)
    }

    LaunchedEffect(Unit) {
        try {
            val fetchedWeather = intelliViewModel.getWeather()
            weather = fetchedWeather
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //  Το εικονίδια που είπαμε θα αλλάζουν με το id , την θερμοκρασία, it feels like και την περιοχή /πόλη θέλω μόν
    //      weather!!.temp
    //      weather!!.feelsLike
    //      weather!!.location
    // για να πάρεις την εικόνα.. για παράδειγμα αν η εικόνα που θες να επιστρέψεις είναι 04d και το όνομα στο αρχείο είναι d04d για να το δεχθεί
    var icon = R.drawable.d01d
    var size = 120.dp
    var backgroundimg = R.drawable.d01d_background
    weather?.let {
        when(weather!!.iconID){
            "01d" -> {
                icon = R.drawable.d01d
                size = 120.dp
                backgroundimg = R.drawable.d01d_background
            }
            "02d" -> {
                icon = R.drawable.d02d
            }
            "03d" -> {
                icon = R.drawable.d03d
            }
        }
    }

    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor)
            .clickable {
                //intelliViewModel.openWeather()
            },
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = MainBackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .height(174.dp)
                .background(MainBackgroundColor)
        ) {
            Image(
                painter = painterResource(id = backgroundimg),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
<<<<<<< Updated upstream
                Box(modifier = Modifier.align(Alignment.CenterStart)) {
                    weather?.let { w ->
                        Text(
                            text = w.temp.toString(),
                            color = TextWhite,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(50.dp))
                        Text(
                            text = w.location,
                            color = TextWhite,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
=======
>>>>>>> Stashed changes
                Box(modifier = Modifier.align(Alignment.TopStart)) {
                    Icon(

                        painter = painterResource(id = R.drawable.weather_icon),
                        contentDescription = "Weather_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "Weather",
                        color = TextWhite,
                        fontFamily = CustomFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.d01d),
                        contentDescription = null,
                        modifier = Modifier.size(size)
                    )
                }
               Box(
                   modifier = Modifier
                       .align(Alignment.CenterEnd)
                       .padding( vertical = 10.dp)
                       .padding(end=30.dp)
               ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .padding(10.dp)
                    ) {
                        weather?.let { w ->
                            Text(
                                text = w.location,
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = w.temp.toString() + "℃",
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                text = w.description,
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )

                        }
                    }
                }

                Box(modifier = Modifier.align(Alignment.TopEnd)){
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_icon),
                        contentDescription = "go_to_app_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(30.dp),
                    )
                }
            }
        }
    }
}