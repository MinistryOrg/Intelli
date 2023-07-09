package com.mom.intelli.ui.screens.smart_home_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.ui.ImgSmartHomeLogo
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.theme.DeviceItemClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextColor
import com.mom.intelli.ui.theme.TextWhite
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceScreen(
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
                MainAddDeviceScreen(navController,intelliViewModel)
            }
        }
    )
}

//TODO prospathisa na to kanw clickable gia na kserei ti epilexei alla nomizw exw vlakeies kai tha prepei na to doume mazi auto pws tha ginei na epilegei thn swsth epilogh

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainAddDeviceScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    val pageCount = 4
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    var selected by remember{ mutableStateOf(false)} //todo gia selected device
    var selectedImage by remember{ mutableStateOf(R.drawable.light_bulb_on)}

    var lightSelected by remember { mutableStateOf(true) }
    var tvSelected by remember { mutableStateOf(false) }
    var speakerSelected by remember { mutableStateOf(false) }
    var webCameraSelected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
        HorizontalPager(
            pageCount = pageCount,
            state = pagerState,
            contentPadding = PaddingValues(start =5.dp, end = 5.dp)
        ) { page ->
            when (page) {
                0 -> {
                    Cardslider(
                        painter = painterResource(id = R.drawable.light_bulb_on),
                        title = "Light",
                        onClick = {
                            lightSelected = true
                            tvSelected = false
                            speakerSelected = false
                            webCameraSelected = false
                        },
                        intelliViewModel = intelliViewModel,
                        selected = lightSelected
                    )
                }
                1 -> {
                    Cardslider(
                        painter = painterResource(id = R.drawable.tv_on),
                        title = "Tv",
                        onClick = {
                            lightSelected = false
                            tvSelected = true
                            speakerSelected = false
                            webCameraSelected = false
                        },
                        intelliViewModel = intelliViewModel,
                        selected = tvSelected
                    )

                }
                2 -> {
                    Cardslider(
                        painter = painterResource(id = R.drawable.speaker_on),
                        title = "Speaker",
                        onClick = {
                            lightSelected = false
                            tvSelected = false
                            speakerSelected = true
                            webCameraSelected = false
                        },
                        intelliViewModel = intelliViewModel,
                        selected = speakerSelected
                    )
                }
                3 -> {
                    Cardslider(
                        painter = painterResource(id = R.drawable.web_camera_on),
                        title = "Web camee",
                        onClick = {
                            lightSelected = false
                            tvSelected = false
                            speakerSelected = false
                            webCameraSelected = true
                        },
                        intelliViewModel = intelliViewModel,
                        selected = webCameraSelected
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        var nameText by remember{ mutableStateOf (TextFieldValue("") ) }

        OutlinedTextField(
            value = nameText,
            label = { Text(text = "Name Device") },
            onValueChange = { nameText = it },
            maxLines = 1,
            singleLine = false,
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = TextColor,
                unfocusedTextColor = TextColor,
                focusedBorderColor = DeviceItemClr,
                focusedLabelColor = TextColor,
                focusedSupportingTextColor = TextColor,
                cursorColor = DeviceItemClr,
                unfocusedLabelColor = TextColor,
                unfocusedBorderColor = DeviceItemClr
            ),
            modifier = Modifier.fillMaxWidth()
        )

        //[Button order]
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 30.dp)
        ) {
            Button(
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DeviceItemClr),
                modifier = Modifier
                    .height(60.dp),
                onClick = { // auto prepei na paei stin sinartisi apo kato i na mpoun ola se ena
                    val selectedOnImage = when {
                        lightSelected -> R.drawable.light_bulb_on
                        tvSelected -> R.drawable.tv_on
                        speakerSelected -> R.drawable.speaker_on
                        webCameraSelected -> R.drawable.web_camera_on
                        else -> R.drawable.light_bulb_on
                    }

                    val selectedOffImage = when {
                        lightSelected -> R.drawable.light_bulb_off
                        tvSelected -> R.drawable.tv_off
                        speakerSelected -> R.drawable.speaker_off
                        webCameraSelected -> R.drawable.web_camera_off
                        else -> R.drawable.light_bulb_off
                    }

                    coroutineScope.launch {
                        intelliViewModel.insertSmarthomeToDatabase(Smarthome(id = 0,nameText.text,selectedOnImage, selectedOffImage))
                    }
                    /*todo*/
                }
            ) {
                Text(
                    text = "Add Device",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cardslider(
    painter: Painter,
    title: String,
    onClick: () -> Unit,
    intelliViewModel: IntelliViewModel,
    selected: Boolean
) {
    Card(
        modifier = Modifier
            .background(DeviceItemClr, shape = RoundedCornerShape(10.dp))
            .padding(5.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = DeviceItemClr
        ),
    ) {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(onClick = {
                onClick()
            }) {
                if (selected) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                } else { // den vrika eikona p na kanei otan vreis nai na ginete prasion
                   // Icon(imageVector = Icons.Default.Circle, contentDescription = null)
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painter, contentDescription = null, modifier = Modifier.height(150.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = title, fontWeight = FontWeight.Bold, color = TextWhite)
        }
    }
}
