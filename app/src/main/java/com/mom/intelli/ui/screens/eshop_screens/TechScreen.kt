package com.mom.intelli.ui.screens.eshop_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.IphoneProduct
import com.mom.intelli.data.TechProducts
import com.mom.intelli.ui.ImgEshopLogo
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.BoxClr
import com.mom.intelli.ui.theme.FloatingCartClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.theme.UnSelectTabTxtClr

val productData = listOf(
    IphoneProduct
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TechScreen(
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
                MainTechScreen(navController)
            }
        }
    )
}

@Composable
fun MainTechScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .background(BoxClr, shape = RoundedCornerShape(18.dp))
                .border(width = 2.dp, color = BorderClr, shape = RoundedCornerShape(12.dp))
                .padding(10.dp)
                .height(20.dp),

        ){
            Text(
                text = "Category - Tech",
                color = UnSelectTabTxtClr,
                fontWeight = FontWeight.Bold
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 1.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(productData.size){ index ->
                    ProductBoxes(navController, productData[index])
                }

            }
        )
    }
}

@Composable
fun ProductBoxes(
    navController: NavController,
    productData : TechProducts
) {
    Column(
        modifier = Modifier
            .background(BoxClr, shape = RoundedCornerShape(10.dp))
            .border(width = 2.dp, color = BorderClr, shape = RoundedCornerShape(10.dp))
            .padding(1.dp)
            .height(250.dp)
            .clickable { /*TODO*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = productData.imgProduct), contentDescription = "tech_prod", modifier = Modifier.size(160.dp).padding(10.dp))
        }
        Column(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = productData.titleProduct, color = TextWhite, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text ="from " + productData.priceProduct, color = TextWhite, fontWeight = FontWeight.Bold, fontSize = 14.sp)

        }
    }
}