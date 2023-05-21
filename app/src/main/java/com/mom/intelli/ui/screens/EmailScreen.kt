package com.mom.intelli.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.ui.ImgEmailLogo
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.theme.CancelBtnClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.DecorColor
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.SendEmailBtnClr
import com.mom.intelli.ui.theme.TextColor
import com.mom.intelli.ui.theme.TextFieldColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen

//THIS IS THE WIDGET TO THE HOME SCREEN
@Composable
fun EmailWidget(
    paddingValues: Dp,
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = MainBackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .height(174.dp)
                .background(MainBackgroundColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.email_2),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ){
                Box(modifier = Modifier.align(Alignment.TopStart)) {
                    Icon(
                        painter = painterResource(id = R.drawable.mail_icon),
                        contentDescription = "Email_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "Email",
                        color = TextWhite,
                        fontFamily = CustomFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 5.dp)
                ){
                    Column(
                        modifier = Modifier.padding(end=5.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        //[Button to view emails]
                        Button(
                            shape = RoundedCornerShape(30.dp),
                            border = BorderStroke(1.dp, TextWhite),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Transparent),
                            modifier = Modifier
                                .height(40.dp)
                                .width(150.dp),
                            onClick = { intelliViewModel.showEmail() }
                        ) {
                            Text(
                                text = "View Emails",
                                color = TextWhite
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.mail_icon),
                                contentDescription = "View emails icon",
                                tint = TextWhite,
                                modifier = Modifier.padding(start=5.dp)

                            )
                        }
                        //[Button to Send email]
                        Button(
                            shape = RoundedCornerShape(30.dp),
                            border = BorderStroke(1.dp, TextWhite),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Transparent),
                            modifier = Modifier
                                .height(40.dp)
                                .width(150.dp),
                            onClick = {
                                navController.navigate(route = Screen.Email.route)
                            }
                        ) {
                            Text(
                                text = "Send Email",
                                color = TextWhite
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.send_icon),
                                contentDescription = "Send email icon",
                                tint = TextWhite,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .size(60.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
//@Preview
//@Composable
//fun EmailWidgetPrev() {
//    IntelliTheme() {
//        EmailWidget(paddingValues = 5.dp, navController = rememberNavController(), intelliViewModel = )
//    }
//}

//THIS IS THE EMAIL SCREEN
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailScreen(
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
                    { ImgEmailLogo() },
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
                paddingValues: PaddingValues ->
            500.dp
            EmainMainScreen(
                navController = navController,intelliViewModel
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmainMainScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    var emailText by remember{ mutableStateOf (TextFieldValue("") ) }
    var subjText by remember{ mutableStateOf (TextFieldValue("") ) }
    var text by remember{ mutableStateOf (TextFieldValue("") ) }
    Box(
        modifier = Modifier
            .background(MainBackgroundColor)
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 80.dp)
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(horizontal = 40.dp)
            ) {
                //[TEXTFIELD TO ADD THE EMAIL ADDRESS YOU WANT TO SEND]
                OutlinedTextField(
                    value = emailText,
                    label = { Text(text = "Email Address")},
                    onValueChange = {emailText = it},
                    maxLines = 1,
                    singleLine = false,
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = TextColor,
                        focusedBorderColor = TextFieldColor,
                        focusedLabelColor = TextColor,
                        focusedSupportingTextColor = TextColor,
                        cursorColor = DecorColor,
                        unfocusedLabelColor = TextColor
                    )
                )
                //[TEXTFIELD TO ADD THE SUBJECT OF THE EMAIL YOU WANT TO SEND]
                OutlinedTextField(
                    value = subjText,
                    label = { Text(text = "Subject")},
                    onValueChange = {subjText = it},
                    maxLines = 1,
                    singleLine = false,
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = TextColor,
                        focusedBorderColor = TextFieldColor,
                        focusedLabelColor = TextColor,
                        focusedSupportingTextColor = TextColor,
                        cursorColor = DecorColor,
                        unfocusedLabelColor = TextColor
                    )
                )
                //[TEXTFIELD TO ADD THE CONTEXT OF THE EMAIL YOU WANT TO SEND]
                OutlinedTextField(
                    value = text,
                    label = { Text(text = "Text")},
                    onValueChange = {text = it},
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = TextColor,
                        focusedBorderColor = TextFieldColor,
                        focusedLabelColor = TextColor,
                        focusedSupportingTextColor = TextColor,
                        cursorColor = DecorColor,
                        unfocusedLabelColor = TextColor
                    ),
                    singleLine = false,
                    modifier = Modifier
                        .height(250.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.outlinedButtonColors( containerColor = CancelBtnClr),
                    modifier = Modifier
                        .height(40.dp),
                    onClick = {navController.popBackStack()}
                ) {
                    Text(
                        text = "Cancel",
                        color = TextWhite
                    )
                }
                //[BUTTON TO SEND EMAIL]
                Button(
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.outlinedButtonColors( containerColor = SendEmailBtnClr), //TODO CHANGE SEND BUTTON COLOR TO SOMETHING BLUE
                    modifier = Modifier
                        .height(40.dp)
                    ,
                    onClick = {
                        intelliViewModel.sendEmail(emailAddress = emailText.text, emailSubject = subjText.text, emailBody = text.text )
                    }
                ) {
                    Text(
                        text = "Send Email",
                        color = TextWhite
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.send_icon),
                        contentDescription = "Send email icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .padding(start = 5.dp)

                    )
                }
            }
        }
    }

}


//@Preview
//@Composable
//fun EmailPrev(){
//    IntelliTheme {
//        EmainMainScreen(
//            navController = rememberNavController(),
//            intelliViewModel = intelliViewModel
//        )
//    }
//}