package com.mom.intelli.ui.screens.eshop_screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.eshop.CheckOut
import com.mom.intelli.ui.ImgEshopLogo
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.DecorColor
import com.mom.intelli.ui.theme.FloatingCartClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.SelectTabTxtClr
import com.mom.intelli.ui.theme.TextColor
import com.mom.intelli.ui.theme.TextFieldColor
import com.mom.intelli.ui.theme.TextWhite
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckOutScreen(
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
                MainCheckoutScreen(navController,intelliViewModel)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCheckoutScreen(
    navController: NavController,
    intelliViewModel : IntelliViewModel
) {
    var nameText by remember{ mutableStateOf (TextFieldValue("") ) }
    var emailText by remember{ mutableStateOf (TextFieldValue("") ) }
    var addressText by remember{ mutableStateOf (TextFieldValue("") ) }
    var countryText by remember{ mutableStateOf (TextFieldValue("") ) }

    val radioOptions = listOf("Credit Card", "Debit Card", "Paypal")
    var (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Check Out",
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
        Column(
            modifier = Modifier.padding(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            //[TEXTFIELD TO ADD THE full name]
            OutlinedTextField(
                value = nameText,
                label = { Text(text = "Full Name") },
                onValueChange = { nameText = it },
                maxLines = 1,
                singleLine = false,
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedBorderColor = TextFieldColor,
                    focusedLabelColor = TextColor,
                    focusedSupportingTextColor = TextColor,
                    cursorColor = DecorColor,
                    unfocusedLabelColor = TextColor
                )
            )
            //[TEXTFIELD TO ADD THE email address]
            OutlinedTextField(
                value = emailText,
                label = { Text(text = "Email Address") },
                onValueChange = { emailText = it },
                maxLines = 1,
                singleLine = false,
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedBorderColor = TextFieldColor,
                    focusedLabelColor = TextColor,
                    focusedSupportingTextColor = TextColor,
                    cursorColor = DecorColor,
                    unfocusedLabelColor = TextColor
                )
            )
            //[TEXTFIELD TO ADD THE address]
            OutlinedTextField(
                value = addressText,
                label = { Text(text = "Address") },
                onValueChange = { addressText = it },
                maxLines = 1,
                singleLine = false,
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedBorderColor = TextFieldColor,
                    focusedLabelColor = TextColor,
                    focusedSupportingTextColor = TextColor,
                    cursorColor = DecorColor,
                    unfocusedLabelColor = TextColor
                )
            )
            //[TEXTFIELD TO ADD THE country]
            OutlinedTextField(
                value = countryText,
                label = { Text(text = "Country") },
                onValueChange = { countryText = it },
                maxLines = 1,
                singleLine = false,
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedBorderColor = TextFieldColor,
                    focusedLabelColor = TextColor,
                    focusedSupportingTextColor = TextColor,
                    cursorColor = DecorColor,
                    unfocusedLabelColor = TextColor
                )
            )
        }
        //[Radio buttons]
        OutlinedCard(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .align(Alignment.CenterHorizontally),
            colors = CardDefaults.cardColors(MainBackgroundColor)
        ) {
            Column(
                Modifier.selectableGroup(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = null, // null recommended for accessibility with screenreaders
                            colors = RadioButtonDefaults.colors(
                                selectedColor = SelectTabTxtClr,
                                unselectedColor = Color.DarkGray
                            )
                        )
                        Text(
                            text = text,
                            color = TextWhite,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }
        //[Button order]
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 10.dp)
        ) {
            Button(
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FloatingCartClr),
                modifier = Modifier
                    .height(60.dp),
                onClick = {
                    coroutineScope.launch {
                        intelliViewModel.insertCheckOut(CheckOut(0,nameText.text,addressText.text,countryText.text,selectedOption.toString(),intelliViewModel.getCartDevices()))
                        intelliViewModel.deleteDevice(intelliViewModel.getCartDevices())
                    }
                }
            ) {
                Text(
                    text = "Order",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}


//@Preview
//@Composable
//fun CheckOutPrev() {
//    IntelliTheme() {
//        MainCheckoutScreen(navController = rememberNavController())
//    }
//}