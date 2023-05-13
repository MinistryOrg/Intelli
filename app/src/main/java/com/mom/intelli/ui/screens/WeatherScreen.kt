package com.mom.intelli.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.R
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
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor)
            .clickable {
                intelliViewModel.openWeather()
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
                painter = painterResource(id = R.drawable.clear_sky_night),
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