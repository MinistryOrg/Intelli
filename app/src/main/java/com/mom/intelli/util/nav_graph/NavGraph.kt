package com.mom.intelli.util.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mom.intelli.ui.HomeScreen
import com.mom.intelli.ui.screens.CalendarScreen
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.ROOT_GRAPH_ROUTE
import com.mom.intelli.util.Screen


//Xrhsimopoioume thn texnikh nested nav graph gia kaluterh organwsh
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ){
        homeNavGraph(navController = navController)
    }
}