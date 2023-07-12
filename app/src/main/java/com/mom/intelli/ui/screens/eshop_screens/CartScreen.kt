package com.mom.intelli.ui.screens.eshop_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.ui.DialogBox
import com.mom.intelli.ui.ImgEshopLogo
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.DialogCredBtnClr
import com.mom.intelli.ui.theme.DialogCredClr
import com.mom.intelli.ui.theme.FloatingCartClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
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
        content = {
            Box(
                modifier = Modifier
                    .background(MainBackgroundColor)
                    .fillMaxSize()
                    .padding(top = 70.dp)
            ){
                MainCartScreen(navController,intelliViewModel)
            }
        }
    )
}

@Composable
fun MainCartScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    var devices by remember {
        mutableStateOf<List<Device>?>(null)
    }
    LaunchedEffect(Unit) {
        val fetchedDevices = intelliViewModel.getCartDevices()
        devices = fetchedDevices
        // Handle the completion of the database operation if needed
    }

    val coroutineScope = rememberCoroutineScope()
    var showEmptyCart by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(
                text = "Cart",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(3.dp)
            .padding(horizontal = 15.dp)
            .background(BorderClr)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Clear Cart",
                color = TextWhite,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        intelliViewModel.deleteCheckOutDevices(intelliViewModel.getCartDevices())
                        navController.popBackStack()
                    } }
            )
        }
        LazyColumn(
            modifier = Modifier
                .padding(15.dp),
            content = {
                devices?.let { value ->
                    value.forEach { device ->
                        item { CartItems(device) }
                    }
                }
        })

        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Button(
                shape = RoundedCornerShape(13.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FloatingCartClr),
                modifier = Modifier
                    .height(60.dp),
                onClick = {
                    if(devices.isNullOrEmpty()){
                        showEmptyCart = true
                    }else{
                        navController.navigate(route = Screen.EshopCheckOut.route)
                    }
                }
            ) {
                Text(
                    text = "Check out",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        if(showEmptyCart){
            Dialog(
                onDismissRequest = { showEmptyCart = false },
                properties = DialogProperties(dismissOnClickOutside = true)
            ) {
                DialogBox(
                    "Your Cart is empty!",
                    "OK",
                    DialogCredClr,
                    FloatingCartClr,
                    onCloseWindow = { showEmptyCart = false}
                )

            }
        }
    }
}


@Composable
fun CartItems(device : Device) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = BorderClr, shape = RoundedCornerShape(10.dp))
            .padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = device.id.toString(), color = TextWhite, fontWeight = FontWeight.Bold)
        if (device.image!! != 0){
            Image(
                painter = painterResource(id =device.image.toInt()),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .height(50.dp)
            )
        }

        Text(text = device.name.toString(), color = TextWhite, fontWeight = FontWeight.Bold)

    }
}