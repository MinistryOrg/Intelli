package com.mom.intelli.util.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.screens.smart_home_screens.AddDeviceScreen
import com.mom.intelli.util.ESHOP_GRAPH_ROUTE
import com.mom.intelli.util.Screen

fun NavGraphBuilder.smarthomeNavGraph(
    navController: NavController,
    intelliViewModel : IntelliViewModel
) {
    navigation(
        startDestination = Screen.Eshop.route,
        route = ESHOP_GRAPH_ROUTE,
    ) {
        composable(
            route = Screen.SmartHomeAddDevice.route
        ){
            AddDeviceScreen(navController)
        }
    }
}