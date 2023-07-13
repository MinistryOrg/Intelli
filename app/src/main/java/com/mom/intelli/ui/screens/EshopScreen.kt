package com.mom.intelli.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.ui.components.ImgEshopLogo
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.screens.eshop_screens.OrdersScreen
import com.mom.intelli.ui.screens.eshop_screens.StoreScreen
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.FloatingCartClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.SelectTabTxtClr
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.theme.UnSelectTabTxtClr
import com.mom.intelli.util.Screen
import kotlinx.coroutines.launch

@Composable
fun EshopWidget(
    paddingValues: Dp,
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor)
            .clickable {
                navController.navigate(route = Screen.Eshop.route)
            },
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = MainBackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .height(174.dp)
                .background(MainBackgroundColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.eshop),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
                Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                    Text(
                        text = "e-Shop",
                        color = TextWhite,
                        fontFamily = CustomFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 30.dp)
                    )
                }
                Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                    Icon(
                        painter = painterResource(id = R.drawable.delivery_icon),
                        contentDescription = "delivery_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                }
                Box(modifier = Modifier.align(Alignment.TopEnd)){
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_icon),
                        contentDescription = "go_to_app_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(30.dp),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EshopScreen(
    navController: NavController,
    intelliViewModel : IntelliViewModel
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Column(
                modifier = Modifier
                    .background(MainBackgroundColor)
            ) {
                CenterAlignedTopAppBar(
                    { ImgEshopLogo() },
                    colors = TopAppBarDefaults
                        .centerAlignedTopAppBarColors(MainBackgroundColor),
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_back),
                                contentDescription = "Back Home",
                                tint = IconsColor,
                                modifier = Modifier.padding(horizontal = 5.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { navController.navigate(route = Screen.OnlineHelp.route) }) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Online Help",
                                tint = IconsColor,
                                modifier = Modifier
                                    .size(30.dp),
                            )
                        }
                    }
                )
            }
        },
        //FLOATING ICON CART
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .background(FloatingCartClr, shape = RoundedCornerShape(30.dp))
                    .padding(10.dp)
                    .clickable {navController.navigate(route = Screen.EshopCart.route) }
            ){
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "cart",
                    tint = TextWhite,
                    modifier = Modifier.size(35.dp)
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
                EshopMainScreen(navController, intelliViewModel)
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EshopMainScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
        val tabData = listOf(
            "Store" ,
            "Orders"
        )
        val pagerState = rememberPagerState(
            initialPage = 0
        )
        val tabIndex = pagerState.currentPage
        val coroutineScope = rememberCoroutineScope()
        Column {
            TabRow(
                selectedTabIndex = tabIndex,
                containerColor = MainBackgroundColor,
                divider = {},
                indicator = {tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[tabIndex])
                            .height(5.dp)
                            .padding(horizontal = 55.dp)
                            .background(color = SelectTabTxtClr, shape = RoundedCornerShape(12.dp))
                    )
                }
            ) {
                tabData.forEachIndexed { index, _ ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = tabData[index],
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        selectedContentColor = SelectTabTxtClr,
                        unselectedContentColor = UnSelectTabTxtClr
                    )
                }
            }
            HorizontalPager(
                pageCount = tabData.size,
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { index ->

                when(index){
                    0->{
                        StoreScreen( navController)
                    }
                    1->{
                        OrdersScreen(navController,intelliViewModel)
                    }
                }
            }
        }
}
