package com.mom.intelli.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mom.intelli.R
import com.mom.intelli.ui.theme.MainBackgroundColor

//LOGO FOR HOME SCREEN
@Composable
fun ImgLogo() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxHeight()
            .background(MainBackgroundColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.intelli_logo), // Replace with your image resource
            contentDescription = "Image",
            modifier = Modifier
                .width(100.dp)
                .height(40.dp), // Set the desired height of the image
            alignment = Alignment.Center
        )
    }
}

//IMAGE LOGO FOR CALENDAR
@Composable
fun ImgCalendarLogo() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxHeight()
            .background(MainBackgroundColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.intelli_calendar_logo), // Replace with your image resource
            contentDescription = "Image",
            modifier = Modifier
                .width(150.dp)
                .height(100.dp), // Set the desired height of the image
            alignment = Alignment.Center
        )
    }
}

//IMAGE LOGO FOR CALENDAR
@Composable
fun ImgEmailLogo() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxHeight()
            .background(MainBackgroundColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.intelli_email_logo), // Replace with your image resource
            contentDescription = "Image",
            modifier = Modifier
                .width(110.dp)
                .height(100.dp), // Set the desired height of the image
            alignment = Alignment.Center
        )
    }
}