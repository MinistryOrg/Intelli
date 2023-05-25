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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
    var size = 100.dp
    var backgroundimg = R.drawable.d01d_background
    var paddIcon = 15.dp
    weather?.let {
        when(weather!!.iconID){
            "01d" -> {
                icon = R.drawable.d01d
                size = 100.dp
                backgroundimg = R.drawable.d01d_background
                paddIcon = 15.dp
            }
            "02d" -> {
                icon = R.drawable.d02d
                size = 140.dp
                backgroundimg = R.drawable.d02d_background
                paddIcon = 5.dp
            }
            "03d" -> {
                icon = R.drawable.d03d
                size = 140.dp
                backgroundimg = R.drawable.d03d_d04d_background
                paddIcon = 5.dp
            }
            "04d" -> {
                icon = R.drawable.d04d
                size = 140.dp
                backgroundimg = R.drawable.d03d_d04d_background
                paddIcon = 5.dp
            }
            "09d" -> {
                icon = R.drawable.d09d
                size = 130.dp
                backgroundimg = R.drawable.d09d_background
                paddIcon = 5.dp
            }
            "10d" -> {
                icon = R.drawable.d10d
                size = 130.dp
                backgroundimg = R.drawable.d10d_background
                paddIcon = 5.dp
            }
            "11d" -> {
                icon = R.drawable.d11d
                size = 130.dp
                backgroundimg = R.drawable.d11d_background
                paddIcon = 5.dp
            }
            "13d" -> {
                icon = R.drawable.d13d
                size = 130.dp
                backgroundimg = R.drawable.d13d_background
                paddIcon = 5.dp
            }
            "01n" -> {
                icon = R.drawable.n01n
                size = 90.dp
                backgroundimg = R.drawable.n01n_background
                paddIcon = 35.dp
            }
            "02n" -> {
                icon = R.drawable.n02n
                size = 120.dp
                backgroundimg = R.drawable.n02n_background
                paddIcon = 20.dp
            }
            "03n" -> {
                icon = R.drawable.d03d
                size = 140.dp
                backgroundimg = R.drawable.n03_n04n_background
                paddIcon = 5.dp
            }
            "04n" -> {
                icon = R.drawable.d04d
                size = 140.dp
                backgroundimg = R.drawable.n03_n04n_background
                paddIcon = 5.dp
            }
            "09n" -> {
                icon = R.drawable.n09n
                size = 120.dp
                backgroundimg = R.drawable.n09n_background
                paddIcon = 25.dp
            }
            "10n" -> {
                icon = R.drawable.d10d
                size = 120.dp
                backgroundimg = R.drawable.n10n_background
                paddIcon = 20.dp
            }
            "11n" -> {
                icon = R.drawable.d11d
                size = 120.dp
                backgroundimg = R.drawable.n11n_background
                paddIcon = 20.dp
            }
            "13n" -> {
                icon = R.drawable.d13d
                size = 120.dp
                backgroundimg = R.drawable.n13n_background
                paddIcon = 20.dp
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
                        .padding(paddIcon)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(size)
                        )
                    }
                }
               Box(
                   modifier = Modifier
                       .align(Alignment.TopEnd)
                       .padding(vertical = 10.dp)
                       .padding(end = 10.dp)
               ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .width(180.dp)
                        .padding(10.dp)
                    ) {
                        weather?.let { w ->
                            Text(
                                text = w.location,
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
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