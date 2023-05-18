package com.mom.intelli.ui.screens.eshop_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.TextWhite

@Composable
fun OrdersScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(15.dp),
            content = {
               item { OrderItems( ) }
            })

    }

}


@Composable
fun OrderItems() {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = BorderClr, shape = RoundedCornerShape(10.dp))
            .padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Text(text = "id", color = TextWhite, fontWeight = FontWeight.Bold)
//        if (device.image!! != 0){
            Image(
                painter = painterResource(id = R.drawable.iphone_13_pro_max),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .height(50.dp)
            )
//        }
        Column() {
            Text(text ="title of product", color = TextWhite, fontWeight = FontWeight.Bold)
            Text(text ="Status: Shipping", color = TextWhite, fontWeight = FontWeight.Bold)
        }
    }
}