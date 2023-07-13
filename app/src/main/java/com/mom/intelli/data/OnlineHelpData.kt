package com.mom.intelli.data
import androidx.compose.ui.graphics.Color
import com.mom.intelli.R
import com.mom.intelli.ui.theme.CalendarClr
import com.mom.intelli.ui.theme.EmailClr
import com.mom.intelli.ui.theme.EshopClr
import com.mom.intelli.ui.theme.InternetClr
import com.mom.intelli.ui.theme.MapClr
import com.mom.intelli.ui.theme.NewsClr
import com.mom.intelli.ui.theme.OtherAppsClr
import com.mom.intelli.ui.theme.SmartHomeClr
import com.mom.intelli.ui.theme.TrafficClr
import com.mom.intelli.ui.theme.WeatherClr

sealed class OnlineHelpData(
    val color: Color,
    val title: String,
    val icon: Int,
    val description1: String,
    val description2: String?,
    val description3: String?,
    val image1: Int,
    val image2: Int?,
    val image3: Int?,
){
    object Calendar: OnlineHelpData(
        color = CalendarClr,
        title = "Calendar",
        icon = R.drawable.calendar_icon,
        description1 = "This is a user-friendly calendar that allows you to select dates, add reminders, and view the current time and date. " +
                "It simplifies scheduling and ensures you never miss important events.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.calendar_prev,
        image2 = null,
        image3 = null
    )

    object Weather: OnlineHelpData(
        color = WeatherClr,
        title = "Weather",
        icon = R.drawable.weather_icon,
        description1 = "The weather option provides real-time weather information by accessing your location. With accurate temperature readings, location details, and real-feel descriptions, it keeps you informed about the current weather conditions and enhances your outdoor planning.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.weather_prev,
        image2 = null,
        image3 = null
    )

    object Internet: OnlineHelpData(
        color = InternetClr,
        title = "Internet",
        icon = R.drawable.search_icon,
        description1 = "The internet search is conveniently located in the main menu, offers a seamless internet search experience. With just a few taps, users can effortlessly search for anything they desire, seamlessly redirecting them to their preferred personal browser for further exploration.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.internet_prev,
        image2 = null,
        image3 = null
    )

    object Email: OnlineHelpData(
        color = EmailClr,
        title = "Email",
        icon = R.drawable.mail_icon,
        description1 = "This option is a comprehensive email feature. The widget in the main menu offers convenient access with two buttons - \"View Emails\" redirects users to their preferred email platform, while \"Send Email\" directs them to our own screen with text fields for composing and sending emails, providing a seamless and efficient email management experience.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.email_prev,
        image2 = null,
        image3 = null
    )
    object Map: OnlineHelpData(
        color = MapClr,
        title = "Maps",
        icon = R.drawable.map_icon_2,
        description1 = "This widget  is a map widget conveniently placed in the main menu. When selected, it seamlessly redirects you to Google Maps, providing easy access to detailed maps, directions, and location-based services.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.maps_prev,
        image2 = null,
        image3 = null
    )
    object Traffic: OnlineHelpData(
        color = TrafficClr,
        title = "Traffic",
        icon = R.drawable.traffic_icon,
        description1 = "This option is a traffic widget situated in the main menu, providing current traffic information for major roads through static text. Although it currently offers static information, the app is actively working on adding dynamic features to provide real-time updates on traffic conditions in the near future.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.traffic_prev,
        image2 = null,
        image3 = null
    )

    object News: OnlineHelpData(
        color = NewsClr,
        title = "News & Sports",
        icon = R.drawable.newspaper_icon,
        description1 = "This option is a news widget situated in the main menu, granting quick access to curated news content. Upon selection, users are redirected to our dedicated screen, which offers three categories: Major News, Sports News, and Personalized News, ensuring a tailored and comprehensive news browsing experience.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.news_prev,
        image2 = null,
        image3 = null
    )

    object Eshop: OnlineHelpData(
        color = EshopClr,
        title = "e-shop",
        icon = R.drawable.delivery_icon,
        description1 = "This is an e-shop widget placed in the main menu. With five product categories available, users can explore and order their desired items, add them to the cart, proceed to checkout, and track the progress of their orders, providing a seamless and comprehensive online shopping experience.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.eshop_prev,
        image2 = null,
        image3 = null
    )

    object SmartHome: OnlineHelpData(
        color = SmartHomeClr,
        title = "Smart Home",
        icon = R.drawable.smart_home_icon,
        description1 = "This is a smart home widget situated in the main menu. It provides an intuitive interface for users to add and manage up to four devices, allowing them to customize device names, control their power status, and easily remove them as needed, enhancing the convenience and control of their smart home ecosystem.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.smarthome_prev,
        image2 = null,
        image3 = null
    )
    object OtherApps: OnlineHelpData(
        color = OtherAppsClr,
        title = "Other Apps",
        icon = R.drawable.other_apps_icon,
        description1 = "This option is an \"Other Apps\" menu widget placed in the main menu, offering users six distinct options:\n" +
                "• Settings: Redirects users to their phone settings for easy customization.\n" +
                "• Alarm: Directs users to their preferred alarm app, ensuring timely reminders.\n" +
                "• Music: Redirects users to their favored music app, providing instant access to their favorite tunes.\n" +
                "• Phone: Launches the phone app for seamless communication.\n" +
                "• Messages: Redirects users to their SMS app for effortless messaging.\n" +
                "• Contacts: Opens the contact app, allowing users to easily manage and access their contacts." +
                "This widget provides a quick and centralized gateway to essential apps, enhancing user convenience and productivity.",
        description2 = null,
        description3 = null,
        image1 = R.drawable.other_apps_prev,
        image2 = null,
        image3 = null
    )

}