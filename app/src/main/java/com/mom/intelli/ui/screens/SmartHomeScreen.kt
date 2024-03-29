package com.mom.intelli.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.ui.components.ImgSmartHomeLogo
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.CircleToggleClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.DeviceItemClr
import com.mom.intelli.ui.theme.FloatingAddDeviceClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.theme.ToggleOffClr
import com.mom.intelli.ui.theme.ToggleOnClr
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.util.Screen
import kotlinx.coroutines.launch

@Composable
fun SmartHomeWidget(
    paddingValues: Dp,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor)
            .clickable {
                navController.navigate(route = Screen.SmartHome.route)
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
                painter = painterResource(id = R.drawable.smart_home),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                Box(modifier = Modifier.align(Alignment.TopStart)) {
                    Icon(
                        painter = painterResource(id = R.drawable.smart_home_icon),
                        contentDescription = "smart_home_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "Smart Home",
                        color = TextWhite,
                        fontFamily = CustomFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }
                Box(modifier = Modifier.align(Alignment.TopEnd)) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_icon),
                        contentDescription = "go_to_app_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(40.dp),
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartHomeScreen(
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
                    { ImgSmartHomeLogo() },
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
                    .padding(10.dp)
                    .background(FloatingAddDeviceClr, shape = RoundedCornerShape(30.dp))
                    .padding(10.dp)
                    .clickable { navController.navigate(route = Screen.SmartHomeAddDevice.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
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
            ) {
                MainSmartHomeScreen(navController, intelliViewModel)
            }
        }
    )
}


@Composable
fun MainSmartHomeScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel,
) {

    var smarthome by remember { mutableStateOf<List<Smarthome>?>(null) }

    val onDeleteDevice: (Smarthome) -> Unit = { deletedDevice ->
        // Implement the logic to remove the deleted device from the screen
        // This could involve updating the state or re-fetching the updated device list
        // For example:
        smarthome = smarthome?.filter { it != deletedDevice }
    }

    LaunchedEffect(Unit) {
        smarthome = intelliViewModel.getSmarthome()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Devices",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .padding(horizontal = 15.dp)
                .background(BorderClr)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                smarthome?.let { value ->
                    value.forEach { smarthome ->
                        item { DeviceItems(smarthome = smarthome, intelliViewModel,onDeleteDevice) }
                    }
                }
            })

    }
}


@Composable
fun DeviceItems(
    smarthome: Smarthome,
    intelliViewModel: IntelliViewModel,
    onDeleteDevice: (Smarthome) -> Unit
) {
    var smarthomeOn by remember { mutableStateOf(true) }
    val checked = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .background(DeviceItemClr, shape = RoundedCornerShape(10.dp))
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = DeviceItemClr
        )

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            intelliViewModel.deleteSmarthomeDevice(smarthome)
                            onDeleteDevice(smarthome)
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.delete_icon),
                        contentDescription = "delete_device",
                        tint = TextWhite,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
            }
            Image(
                painter = painterResource(id = if (smarthomeOn) smarthome.image!!.toInt() else smarthome.offImage!!.toInt()),
                contentDescription = if (smarthomeOn) "light_on" else "light_off",
                modifier = Modifier.height(100.dp)
            )
            Text(text = smarthome.name.toString(), fontWeight = FontWeight.Bold, color = TextWhite)

            Switch(
                modifier = Modifier.semantics { contentDescription = "Demo" },
                checked = smarthomeOn,
                onCheckedChange = { smarthomeOn = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = CircleToggleClr,
                    uncheckedThumbColor = CircleToggleClr,
                    uncheckedBorderColor = ToggleOffClr,
                    checkedTrackColor = ToggleOnClr,
                    uncheckedTrackColor = ToggleOffClr
                )
            )
        }
    }
}