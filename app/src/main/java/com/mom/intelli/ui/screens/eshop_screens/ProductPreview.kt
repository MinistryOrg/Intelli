package com.mom.intelli.ui.screens.eshop_screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.ui.components.ImgEshopLogo
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.theme.FloatingCartClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.SelectTabTxtClr
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductPreviewScreen(navController: NavController,intelliViewModel : IntelliViewModel) {
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
                MainProductPreview(navController,intelliViewModel)
            }
        }
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainProductPreview(navController: NavController, intelliViewModel: IntelliViewModel) {
    val pageCount = 4
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val toastTxt = "Added to the cart successfully!"
    val duration = Toast.LENGTH_LONG
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
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
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Apple iPhone 13 Pro Max 5G (6GB/128GB) Graphite",
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "from 1.500,00€",
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(3.dp)
            .padding(vertical = 1.dp)
            .background(SelectTabTxtClr)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Key features:\n" +
                    "-2021 Model\n" +
                    "-Super Retina XDR OLED 6.7\" Display\n" +
                    "-NFC Support\n" +
                    "-Apple A15 Bionic chip\n" +
                    "-12MP/4K 60fps Triple Camera\n" +
                    "-4352mAh Battery (50% in 30min)",
            color = TextWhite,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(60.dp))
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Button(
                shape = RoundedCornerShape(13.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FloatingCartClr),
                modifier = Modifier
                    .height(60.dp),
                onClick = {
                    coroutineScope.launch {
                        intelliViewModel.insertDeviceToDatabase(Device(0,"Apple iPhone 13 Pro Max 5G (6GB/128GB) Graphite", R.drawable.iphone_13_pro_max.toInt()))

                        Toast.makeText(context, toastTxt, duration).show()
                    }

                }
            ) {
                Text(
                    text = "Add to Cart",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "cart icon",
                    tint = TextWhite,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(30.dp)
                )
            }
        }
    }


}
