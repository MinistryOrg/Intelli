package com.mom.intelli.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.OnlineHelpData
import com.mom.intelli.ui.components.ExpandableCard
import com.mom.intelli.ui.components.ImgLogo
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnlineHelpScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Column(
                modifier = Modifier
                    .background(MainBackgroundColor)
            ) {
                CenterAlignedTopAppBar(
                    { ImgLogo() },
                    colors = TopAppBarDefaults
                        .centerAlignedTopAppBarColors(MainBackgroundColor),
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_back),
                                contentDescription = "Back",
                                tint = IconsColor,
                                modifier = Modifier.padding(horizontal = 5.dp)
                            )
                        }
                    }
                )
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .background(MainBackgroundColor)
                    .fillMaxSize()
                    .padding(top = 70.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Text(
                        text = "Online Help",
                        color = TextWhite,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Calendar.color,
                        title = OnlineHelpData.Calendar.title,
                        icon = OnlineHelpData.Calendar.icon,
                        description1 = OnlineHelpData.Calendar.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Calendar.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Weather.color,
                        title = OnlineHelpData.Weather.title,
                        icon = OnlineHelpData.Weather.icon,
                        description1 = OnlineHelpData.Weather.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Weather.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Internet.color,
                        title = OnlineHelpData.Internet.title,
                        icon = OnlineHelpData.Internet.icon,
                        description1 = OnlineHelpData.Internet.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Internet.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Email.color,
                        title = OnlineHelpData.Email.title,
                        icon = OnlineHelpData.Email.icon,
                        description1 = OnlineHelpData.Email.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Email.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Map.color,
                        title = OnlineHelpData.Map.title,
                        icon = OnlineHelpData.Map.icon,
                        description1 = OnlineHelpData.Map.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Map.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Traffic.color,
                        title = OnlineHelpData.Traffic.title,
                        icon = OnlineHelpData.Traffic.icon,
                        description1 = OnlineHelpData.Traffic.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Traffic.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.News.color,
                        title = OnlineHelpData.News.title,
                        icon = OnlineHelpData.News.icon,
                        description1 = OnlineHelpData.News.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.News.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.Eshop.color,
                        title = OnlineHelpData.Eshop.title,
                        icon = OnlineHelpData.Eshop.icon,
                        description1 = OnlineHelpData.Eshop.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.Eshop.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.SmartHome.color,
                        title = OnlineHelpData.SmartHome.title,
                        icon = OnlineHelpData.SmartHome.icon,
                        description1 = OnlineHelpData.SmartHome.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.SmartHome.image1,
                        Image2 = null,
                        Image3 = null
                    )

                    ExpandableCard(
                        cardColor = OnlineHelpData.OtherApps.color,
                        title = OnlineHelpData.OtherApps.title,
                        icon = OnlineHelpData.OtherApps.icon,
                        description1 = OnlineHelpData.OtherApps.description1,
                        description2 = null,
                        Image1 = OnlineHelpData.OtherApps.image1,
                        Image2 = null,
                        Image3 = null
                    )
                }
            }
        }
    )
}