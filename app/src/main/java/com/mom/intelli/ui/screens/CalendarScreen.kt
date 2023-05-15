package com.mom.intelli.ui.screens

import android.annotation.SuppressLint
import android.icu.text.DateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.ui.ImgCalendarLogo
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen
import kotlinx.coroutines.delay
import java.util.Calendar

//THIS IS THE WIDGET TO THE HOME SCREEN
@Composable
fun CalendarWidget(
    paddingValues: Dp,
    navController: NavController
) {

    var calendar by remember { mutableStateOf(Calendar.getInstance().time) }
    var dateFormat by remember { mutableStateOf(DateFormat.getDateInstance(DateFormat.FULL).format(calendar)) }
    var timeFormat by remember { mutableStateOf(DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar)) }

    LaunchedEffect(Unit) { // to change the time in real time
        while (true) {
            delay(1000) // Delay for 1 second
            calendar = Calendar.getInstance().time
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)
            timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar)
        }
    }

    Card(
        modifier = Modifier
            .background(MainBackgroundColor)
            .padding(vertical = paddingValues)
            .clickable {
                navController.navigate(route = Screen.Calendar.route)
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
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
                Column() {
                    Text(
                        text = dateFormat,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = timeFormat,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Box(modifier = Modifier.align(Alignment.BottomStart)) {
                    Icon(
                        painter = painterResource(id = R.drawable.calendar_icon),
                        contentDescription = "Calendar_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "Calendar",
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

//THIS IS THE CALENDAR SCREEN
//TODO !!TO GO BACK TO HOME SCREEN USE navController.popBackStack()

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Column(
                modifier = Modifier
                    .background(MainBackgroundColor)
            ) {
                CenterAlignedTopAppBar(
                    { ImgCalendarLogo() },
                    colors = TopAppBarDefaults
                        .centerAlignedTopAppBarColors(MainBackgroundColor),
                    navigationIcon = {
                                     IconButton(
                                         onClick = { navController.popBackStack() }
                                     ) {
                                         Icon(
                                             painter = painterResource(id = R.drawable.arrow_back),
                                             contentDescription = "Back Home",
                                             tint = IconsColor,
                                             modifier = Modifier.padding(horizontal = 5.dp)
                                         )
                                     }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Online Help",
                                tint = IconsColor,
                                modifier = Modifier
                                    .size(30.dp),
                            )
                        }
                    }
                )
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .background(MainBackgroundColor)
                    .fillMaxSize()
            ){

            }
        }
    )
    
}

