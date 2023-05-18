package com.mom.intelli.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import com.mom.intelli.service.IntelliService
import com.mom.intelli.ui.screens.CalendarWidget
import com.mom.intelli.ui.screens.EmailWidget
import com.mom.intelli.ui.screens.EshopWidget
import com.mom.intelli.ui.screens.MapsWidget
import com.mom.intelli.ui.screens.NewsWidget
import com.mom.intelli.ui.screens.OtherAppWidget
import com.mom.intelli.ui.screens.SmartHomeWidget
import com.mom.intelli.ui.screens.WeatherWidget
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.FooterText
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite

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
            content = { paddingValues: PaddingValues ->
                200.dp
                MainList(paddingValues, navController, intelliViewModel = intelliViewModel)

            }
        )
    }

}



@Composable
fun MainList(
    paddingValues: PaddingValues,
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    val context = LocalContext.current
    val intelliService = IntelliService(context)
    val vrtpadding = 5.dp
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
                text = "Good Evening, Name",
                color = TextWhite,
                fontFamily = CustomFont,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )

            CalendarWidget(paddingValues = vrtpadding, navController = navController)
            WeatherWidget(paddingValues = vrtpadding, navController = navController ,intelliViewModel)
            // TODO ADD SEARCH WIDGET
            EmailWidget(paddingValues = vrtpadding, navController = navController, intelliViewModel)
            MapsWidget(paddingValues = vrtpadding, navController = navController ,intelliViewModel)
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