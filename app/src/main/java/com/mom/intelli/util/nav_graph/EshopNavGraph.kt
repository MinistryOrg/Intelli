package com.mom.intelli.util.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mom.intelli.ui.screens.eshop_screens.CartScreen
import com.mom.intelli.ui.screens.eshop_screens.CheckOutScreen
import com.mom.intelli.ui.screens.eshop_screens.FashionScreen
import com.mom.intelli.ui.screens.eshop_screens.FurnitureScreen
import com.mom.intelli.ui.screens.eshop_screens.GroceriesScreen
import com.mom.intelli.ui.screens.eshop_screens.ProductPreviewScreen
import com.mom.intelli.ui.screens.eshop_screens.SportsScreen
import com.mom.intelli.ui.screens.eshop_screens.TechScreen
import com.mom.intelli.util.ESHOP_GRAPH_ROUTE
import com.mom.intelli.util.Screen

fun NavGraphBuilder.eshopNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.Eshop.route,
        route = ESHOP_GRAPH_ROUTE,

    ) {
        composable(
            route = Screen.EshopStoreTech.route
        ){
            TechScreen(navController)
        }
        composable(
            route = Screen.EshopStoreFurn.route
        ){
            FurnitureScreen(navController)
        }
        composable(
            route = Screen.EshopStoreGroc.route
        ){
            GroceriesScreen(navController)
        }
        composable(
            route = Screen.EshopStoreSports.route
        ){
            SportsScreen(navController)
        }
        composable(
            route = Screen.EshopStoreFash.route
        ){
            FashionScreen(navController)
        }
        composable(
            route = Screen.EshopCart.route
        ){
            CartScreen(navController)
        }
        composable(
            route = Screen.EshopCheckOut.route
        ){
            CheckOutScreen(navController)
        }
        composable(
            route = Screen.EshopProductPrev.route
        ){
            ProductPreviewScreen(navController)
        }
    }
}