package com.mom.intelli.util.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mom.intelli.ui.HomeScreen
import com.mom.intelli.ui.screens.CalendarScreen
import com.mom.intelli.ui.screens.EmailScreen
import com.mom.intelli.ui.screens.EshopScreen
import com.mom.intelli.ui.screens.NewsScreen
import com.mom.intelli.ui.screens.SmartHomeScreen
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.Screen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Calendar.route
        ){
            CalendarScreen(navController = navController)
        }
        composable(
            route = Screen.Email.route
        ){
            EmailScreen(navController = navController)
        }
        composable(
            route = Screen.News.route
        ){
            NewsScreen(navController = navController)
        }
        composable(
            route = Screen.Eshop.route
        ){
            EshopScreen(navController = navController)
        }
        composable(
            route = Screen.SmartHome.route
        ){
            SmartHomeScreen(navController = navController)
        }
    }
}