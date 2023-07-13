package com.mom.intelli.util


const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"
const val ESHOP_GRAPH_ROUTE = "eshop"
const val SMART_HOME_GRAPH_ROUTE = "smarthome"

sealed class Screen (val route : String) {

    object OnBoarding : Screen("onboarding_screen")

    object SignIn : Screen("signin_screen")

    object SignUp : Screen("signup_screen")

    object OnlineHelp : Screen("online_help_screen")

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

    object EshopCart: Screen("eshop_cart_screen")

    object EshopCheckOut: Screen("eshop_checkout_screen")
    object EshopProductPrev: Screen("eshop_product_preview_screen")

    //SMART HOME SCREENS
    object SmartHome: Screen("smart_home_screen")
    object SmartHomeAddDevice: Screen("smart_home_add_device_screen")

}