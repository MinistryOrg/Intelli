package com.mom.intelli.util.nav_graph

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mom.intelli.ui.HomeScreen
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.screens.CalendarScreen
import com.mom.intelli.ui.screens.EmailScreen
import com.mom.intelli.ui.screens.EshopScreen
import com.mom.intelli.ui.screens.NewsScreen
import com.mom.intelli.ui.screens.SmartHomeScreen
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.Screen
import com.mom.intelli.util.TextToSpeechHelper

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    intelliViewModel: IntelliViewModel,
    context: Context
){
    var clickCount = 0
    val selectedRoute = HOME_GRAPH_ROUTE
    val ttsHelper = TextToSpeechHelper(context)

    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ){
            //ttsHelper.speak("Home Screen")
            HomeScreen(navController = navController,intelliViewModel)
        }
        composable(
            route = Screen.Calendar.route
        ){
            CalendarScreen(navController = navController,intelliViewModel)
        }
        composable(
            route = Screen.Email.route
        ){
            EmailScreen(navController = navController,intelliViewModel)
        }
        composable(
            route = Screen.News.route
        ){
            //ttsHelper.speak("News")
            NewsScreen(navController = navController,intelliViewModel)
        }
        composable(
            route = Screen.Eshop.route
        ){
            //ttsHelper.speak("Eshop")
            EshopScreen(navController = navController,intelliViewModel)
        }
        composable(
            route = Screen.SmartHome.route
        ){
            //ttsHelper.speak("Smart home")
            SmartHomeScreen(navController = navController,intelliViewModel)
        }
    }
}