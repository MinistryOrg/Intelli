package com.mom.intelli.util


const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"

sealed class Screen (val route : String) {
    object Home : Screen("home_screen")

    object Calendar : Screen("cal_screen")

    object Email: Screen("email_screen")

    object News: Screen("news_screen")

    object Eshop: Screen("eshop_screen")

    object SmartHome: Screen("smart_home_screen")

}