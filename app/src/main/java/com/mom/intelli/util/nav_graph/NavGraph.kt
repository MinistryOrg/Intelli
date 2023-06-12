package com.mom.intelli.util.nav_graph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.OnBoardingScreen
import com.mom.intelli.ui.SignInScreen
import com.mom.intelli.ui.SignUpScreen
import com.mom.intelli.util.ROOT_GRAPH_ROUTE
import com.mom.intelli.util.Screen


//Xrhsimopoioume thn texnikh nested nav graph gia kaluterh organwsh
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    intelliViewModel: IntelliViewModel,
    context: Context,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        route = ROOT_GRAPH_ROUTE
    ){
        composable(
            route = Screen.OnBoarding.route
        ){
            OnBoardingScreen(navController = navController)
        }
        composable(
            route = Screen.SignIn.route
        ){
            SignInScreen(navController = navController, intelliViewModel = intelliViewModel)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController = navController, intelliViewModel =  intelliViewModel)
        }

        homeNavGraph(navController = navController, intelliViewModel = intelliViewModel,context)

        eshopNavGraph(navController = navController, intelliViewModel = intelliViewModel)

        smarthomeNavGraph(navController = navController,intelliViewModel = intelliViewModel)
    }
}