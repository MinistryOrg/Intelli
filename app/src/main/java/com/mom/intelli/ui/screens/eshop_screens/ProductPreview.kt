package com.mom.intelli.ui.screens.eshop_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.ui.ImgEshopLogo
import com.mom.intelli.ui.theme.FloatingCartClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductPreviewScreen(navController: NavController) {
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
                        IconButton(onClick = { /*TODO*/ }) {
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
                    .clickable {/*TODO ADD NAV ACTION*/ }
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
                MainProductPreview(navController)
            }
        }
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainProductPreview(navController: NavController) {
    val pageCount = 4
    val pagerState = rememberPagerState()

    HorizontalPager(
        pageCount = pageCount,
        state = pagerState
    ) { page ->
        when(page){
            0->{
                Image(
                    painter = painterResource(id = R.drawable.iphone_13_pro_max),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            1->{
                Image(
                    painter = painterResource(id = R.drawable.iphone_1),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            2->{
                Image(
                    painter = painterResource(id = R.drawable.iphone_2),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            3->{
                Image(
                    painter = painterResource(id = R.drawable.iphone_3),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }
    }
}