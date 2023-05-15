package com.mom.intelli.util


const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"
const val ESHOP_GRAPH_ROUTE = "eshop"

sealed class Screen (val route : String) {
    object Home : Screen("home_screen")

    //CALENDAR SCREEN
    object Calendar : Screen("cal_screen")

    //EMAIL SCREEN
    object Email: Screen("email_screen")

    //NEWS SCREENS
    object News: Screen("news_screen")

    //ESHOP SCREENS
    object Eshop: Screen("eshop_screen")

    object EshopStoreTech: Screen("eshop_tech_screen")

    object EshopStoreFurn: Screen("eshop_furn_screen")

    object EshopStoreGroc: Screen("eshop_groc_screen")

    object EshopStoreSports: Screen("eshop_sports_screen")

    object EshopStoreFash: Screen("eshop_fash_screen")

    //SMART HOME SCREENS
    object SmartHome: Screen("smart_home_screen")

}