package com.mom.intelli.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.HeavyTrafficClr
import com.mom.intelli.ui.theme.LightTrafficClr
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.viewmodels.IntelliViewModel

@Composable
fun TrafficWidget(
    paddingValues: Dp
) {
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor)
            ,
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = MainBackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .height(174.dp)
                .background(MainBackgroundColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.traffic),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor)

            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
                Box(modifier = Modifier.align(Alignment.TopEnd)){
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_icon),
                        contentDescription = "go_to_app_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(30.dp),
                    )
                }

               Box(
                   modifier = Modifier
//                       .fillMaxHeight()
//                       .border(width = 1.dp, color = TextWhite ,shape = RoundedCornerShape(13.dp))
//                       .align(Alignment.CenterEnd)
               ) {
                   Row(
                       modifier = Modifier
                           .padding(top = 30.dp, end=15.dp)
                           .fillMaxWidth(),
                       horizontalArrangement = Arrangement.End,
                       verticalAlignment = Alignment.CenterVertically
                   ) {

                       Column() {
                           Icon(
                               painter = painterResource(id = R.drawable.car_icon),
                               contentDescription = "car_icon",
                               tint = LightTrafficClr,
                               modifier = Modifier
                                   .size(32.dp)
                                   .padding(end = 12.dp),
                           )
                       }
                       Column() {
                           Text(
                               text = "Syntagma - Peiraias | 7'",
                               fontSize = 10.sp,
                               fontWeight = FontWeight.Bold,
                               color = TextWhite
                           )
                       }
                   }
                   Row(
                       modifier = Modifier
                           .padding(top = 70.dp, end=15.dp)
                           .fillMaxWidth(),
                       horizontalArrangement = Arrangement.End,
                       verticalAlignment = Alignment.CenterVertically
                   ) {

                       Column() {
                           Icon(
                               painter = painterResource(id = R.drawable.car_icon),
                               contentDescription = "car_icon",
                               tint = HeavyTrafficClr,
                               modifier = Modifier
                                   .size(30.dp)
                                   .padding(end = 10.dp),
                           )
                       }
                       Column() {
                           Text(
                               text = "Syntagma - Omonia | 25'",
                               fontSize = 10.sp,
                               fontWeight = FontWeight.Bold,
                               color = TextWhite
                           )
                       }
                   }
               }
                Box(modifier = Modifier.align(Alignment.TopStart)) {
                    Icon(

                        painter = painterResource(id = R.drawable.traffic_icon),
                        contentDescription = "Weather_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "Traffic",
                        color = TextWhite,
                        fontFamily = CustomFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }

            }
        }
    }
}