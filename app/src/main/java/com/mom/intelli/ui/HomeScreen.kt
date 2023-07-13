package com.mom.intelli.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.ui.screens.CalendarWidget
import com.mom.intelli.ui.screens.EmailWidget
import com.mom.intelli.ui.screens.EshopWidget
import com.mom.intelli.ui.screens.MapsWidget
import com.mom.intelli.ui.screens.NewsWidget
import com.mom.intelli.ui.screens.OtherAppWidget
import com.mom.intelli.ui.screens.SearchInternetWidget
import com.mom.intelli.ui.screens.SmartHomeWidget
import com.mom.intelli.ui.screens.TrafficWidget
import com.mom.intelli.ui.screens.WeatherWidget
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.FooterText
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.util.Screen
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.toLocalDateTime

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    intelliViewModel.init(LocalContext.current)
    Column {
        Scaffold(
            modifier = Modifier,
            topBar = {
                Column(
                    modifier = Modifier
                        .background(MainBackgroundColor)
                ) {
                    CenterAlignedTopAppBar(
                        { ImgLogo() },
                        colors = TopAppBarDefaults
                            .centerAlignedTopAppBarColors(MainBackgroundColor),
                        actions = {
                            IconButton(onClick = {  navController.navigate(route = Screen.OnBoarding.route) }) {
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
            content = { paddingValues: PaddingValues ->
                200.dp
                MainList(paddingValues, navController, intelliViewModel = intelliViewModel)

            }
        )
    }

}



@SuppressLint("RememberReturnType")
@Composable
fun MainList(
    paddingValues: PaddingValues,
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    val vrtpadding = 5.dp
    val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val startMorningTime = currentTime.date.atTime(5, 0)
    val endMorningTime = currentTime.date.atTime(12, 0)
    val startAfternoonTime = currentTime.date.atTime(12,0)
    val endAfternoonTime = currentTime.date.atTime(18,0)

    Box(
        modifier = Modifier
            .background(MainBackgroundColor)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(MainBackgroundColor)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = if(currentTime > startMorningTime && currentTime < endMorningTime )
                        { "Good morning, " + intelliViewModel.user!!.fullname}
                        else if(currentTime >= startAfternoonTime && currentTime < endAfternoonTime)
                        {"Good afternoon, " + intelliViewModel.user!!.fullname}
                        else
                        {"Good evening, Name" + intelliViewModel.user!!.fullname},
                color = TextWhite,
                fontFamily = CustomFont,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(12.dp)
            )

            CalendarWidget(paddingValues = vrtpadding, navController = navController)
            WeatherWidget(paddingValues = vrtpadding, navController = navController ,intelliViewModel)
            SearchInternetWidget(paddingValues = vrtpadding, intelliViewModel)
            EmailWidget(paddingValues = vrtpadding, navController = navController, intelliViewModel)
            MapsWidget(paddingValues = vrtpadding, navController = navController ,intelliViewModel)
            TrafficWidget(paddingValues=vrtpadding)
            NewsWidget(paddingValues = vrtpadding, navController= navController, intelliViewModel)
            EshopWidget(paddingValues = vrtpadding, navController = navController,intelliViewModel)
            SmartHomeWidget(paddingValues = vrtpadding, navController = navController)
            OtherAppWidget(paddingValues = vrtpadding, intelliViewModel)

            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Copyright of Ministry Org 2023-2024",
                    color = FooterText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}