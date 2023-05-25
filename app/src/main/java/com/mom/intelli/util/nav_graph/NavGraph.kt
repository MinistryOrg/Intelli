package com.mom.intelli.util.nav_graph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.ROOT_GRAPH_ROUTE


//Xrhsimopoioume thn texnikh nested nav graph gia kaluterh organwsh
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    intelliViewModel: IntelliViewModel,
    context: Context
) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ){
        homeNavGraph(navController = navController, intelliViewModel = intelliViewModel,context)

        eshopNavGraph(navController = navController, intelliViewModel = intelliViewModel)

        smarthomeNavGraph(navController = navController,intelliViewModel = intelliViewModel)
    }
}