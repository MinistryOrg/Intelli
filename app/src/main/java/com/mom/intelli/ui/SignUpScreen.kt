package com.mom.intelli.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.user.User
import com.mom.intelli.ui.components.DialogBox
import com.mom.intelli.ui.components.ImgLogo
import com.mom.intelli.ui.theme.DialogCredBtnClr
import com.mom.intelli.ui.theme.DialogCredClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.SignUpBtnClr
import com.mom.intelli.ui.theme.TextColor
import com.mom.intelli.ui.theme.TextFieldColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.util.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    var showErrorSignUpDialog by remember { mutableStateOf(false)}
    var showEmptySignUpDialog by remember { mutableStateOf(false)}
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier,
        topBar = {
            Column(
                modifier = Modifier
                    .background(MainBackgroundColor)
            ) {
                CenterAlignedTopAppBar(
                    { ImgLogo() },
                    colors = TopAppBarDefaults
                        .centerAlignedTopAppBarColors(MainBackgroundColor),
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_back),
                                contentDescription = "Back",
                                tint = IconsColor,
                                modifier = Modifier.padding(horizontal = 5.dp)
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
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {

                    Text(
                        text = "Sign Up",
                        color = TextWhite,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //Textfields
                    var nameText by remember { mutableStateOf(TextFieldValue("")) }
                    var emailText by remember { mutableStateOf(TextFieldValue("")) }
                    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
                    var confirmPasswordText by remember { mutableStateOf(TextFieldValue("")) }

                    OutlinedTextField(
                        value = nameText,
                        label = { Text(text = "Name") },
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
                            cursorColor = TextFieldColor,
                            unfocusedLabelColor = TextColor,
                            unfocusedBorderColor = TextFieldColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    )

                    OutlinedTextField(
                        value = emailText,
                        label = { Text(text = "Email") },
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
                            cursorColor = TextFieldColor,
                            unfocusedLabelColor = TextColor,
                            unfocusedBorderColor = TextFieldColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    )

                    OutlinedTextField(
                        value = passwordText,
                        label = { Text(text = "Password") },
                        onValueChange = { passwordText = it },
                        maxLines = 1,
                        singleLine = false,
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(15.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextColor,
                            unfocusedTextColor = TextColor,
                            focusedBorderColor = TextFieldColor,
                            focusedLabelColor = TextColor,
                            focusedSupportingTextColor = TextColor,
                            cursorColor = TextFieldColor,
                            unfocusedLabelColor = TextColor,
                            unfocusedBorderColor = TextFieldColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    )

                    OutlinedTextField(
                        value = confirmPasswordText,
                        label = { Text(text = "Confirm Password") },
                        onValueChange = { confirmPasswordText = it },
                        maxLines = 1,
                        singleLine = false,
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(15.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextColor,
                            unfocusedTextColor = TextColor,
                            focusedBorderColor = TextFieldColor,
                            focusedLabelColor = TextColor,
                            focusedSupportingTextColor = TextColor,
                            cursorColor = TextFieldColor,
                            unfocusedLabelColor = TextColor,
                            unfocusedBorderColor = TextFieldColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    )

                    //Sign up button

                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 10.dp)
                    ) {
                        Button(
                            shape = RoundedCornerShape(13.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = SignUpBtnClr),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .height(50.dp)
                                .fillMaxWidth(),
                            onClick = {
                                if(nameText.text.isEmpty() || emailText.text.isEmpty() || passwordText.text.isEmpty() || confirmPasswordText.text.isEmpty()){
                                    showEmptySignUpDialog = true
                                }
                                else{
                                    var userSignUp = false
                                    coroutineScope.launch {
                                        withContext(Dispatchers.IO) {
                                            userSignUp =  intelliViewModel.signUp(
                                                User(
                                                    0,
                                                    fullname = nameText.text,
                                                    email = emailText.text,
                                                    password = passwordText.text,
                                                    null,
                                                    rememberMe = true
                                                )
                                            )
                                        }
                                        if (userSignUp){
                                            navController.navigate(Screen.SignIn.route) // na pigenei sto sign up
                                        } else {
                                            //error sign up
                                            showErrorSignUpDialog = true
                                        }
                                    }
                                }


                            }
                        ) {
                            Text(
                                text = "Sign Up",
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 10.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.kaira_signup), contentDescription = null, modifier = Modifier.height(200.dp))
                    }

                    if(showErrorSignUpDialog){
                        Dialog(
                            onDismissRequest = { showErrorSignUpDialog= false },
                            properties = DialogProperties(dismissOnClickOutside = true)
                        ) {
                            DialogBox(
                                textTitle = "Something went wrong.\n Try Again Please.",
                                textBtn = "Try Again!",
                                DialogClr = DialogCredClr,
                                DialogBtnClr = DialogCredBtnClr,
                                onCloseWindow = {showErrorSignUpDialog = false}
                            )
                        }
                    }
                    if(showEmptySignUpDialog){
                        Dialog(
                            onDismissRequest = { showEmptySignUpDialog= false },
                            properties = DialogProperties(dismissOnClickOutside = true)
                        ) {
                            DialogBox(
                                textTitle = "Please fill all the fields.",
                                textBtn = "OK!",
                                DialogClr = DialogCredClr,
                                DialogBtnClr = DialogCredBtnClr,
                                onCloseWindow = {showEmptySignUpDialog = false}
                            )
                        }
                    }
                }
            }
        }
    )
}
