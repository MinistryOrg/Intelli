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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.eshop.CheckOut
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.screens.DeviceItems
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.TextWhite

@Composable
fun OrdersScreen(navController: NavController, intelliViewModel: IntelliViewModel) {
    var checkOut by remember {
        mutableStateOf<List<CheckOut>?>(null)
    }
    LaunchedEffect(Unit) {
        val fetchedCheckOut = intelliViewModel.getCheckOut()
        checkOut  = fetchedCheckOut
    }
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(15.dp),
            content = {
                checkOut?.let { value ->
                    value.forEach { checkOut ->
                        item { OrderItems(checkOut) }
                    }
                }
            })

    }

}


@Composable
fun OrderItems(checkOut: CheckOut) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = BorderClr, shape = RoundedCornerShape(10.dp))
            .padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = checkOut.id.toString()+".", color = TextWhite, fontWeight = FontWeight.Bold)
//        if (device.image!! != 0){
            Image(
                painter = painterResource(id = R.drawable.iphone_13_pro_max),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .height(70.dp)
            )
//        }
        Column() {
            Text(text = "Name: "+ checkOut.fullname!!, color = TextWhite, fontWeight = FontWeight.Bold)
            checkOut.device.let { value ->
                value.forEach { device ->
                    Text(text =device.name!!, color = TextWhite, fontWeight = FontWeight.Bold)
                    Text(text ="Status: Shipping", color = TextWhite, fontWeight = FontWeight.Bold)
                }
            }

        }
    }
}