package com.mom.intelli.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.data.user.User
import com.mom.intelli.ui.theme.CheckedClr
import com.mom.intelli.ui.theme.DeviceItemClr
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.SignInBtnClr
import com.mom.intelli.ui.theme.SignUpBtnClr
import com.mom.intelli.ui.theme.TextColor
import com.mom.intelli.ui.theme.TextFieldColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    intelliViewModel: IntelliViewModel,
    navController: NavController
) {
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
                        .centerAlignedTopAppBarColors(MainBackgroundColor)
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
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {

                    Text(
                        text = "Sign In",
                        color = TextWhite,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    //Textfields

                    var emailText by remember{ mutableStateOf (TextFieldValue("") ) }
                    var passwordText by remember{ mutableStateOf (TextFieldValue("") ) }

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

                    //remember me check box
                    val (checkedState, onStateChange) = remember { mutableStateOf(false) }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .toggleable(
                                value = checkedState,
                                onValueChange = { onStateChange(!checkedState) },
                                role = Role.Checkbox
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkedState,
                            onCheckedChange = null, // null recommended for accessibility with screenreaders
                            colors = CheckboxDefaults.colors(
                                checkedColor = CheckedClr
                            )
                        )
                        Text(
                            text = "remember me",
                            color = TextWhite,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    //Sign in button
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 10.dp)
                    ) {
                        Button(
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = SignInBtnClr),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .height(50.dp)
                                .fillMaxWidth(),
                            onClick = {
                                var correctData = false
                                coroutineScope.launch {
                                    withContext(Dispatchers.IO) {
                                        correctData = intelliViewModel.signIn(emailText.text,passwordText.text,checkedState)
                                    }
                                    if (correctData){
                                        navController.navigate(HOME_GRAPH_ROUTE)
                                    } else {
                                        Log.d("Sign in ", "fail")
                                        // δεν ξέρω
                                    }
                                }
                                //To evala na se phgainei sto homescreen mexri na to ftiaxeis

                            }
                        ) {
                            Text(
                                text = "Sign In",
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }

                    Text(
                        text = "You don't have an account? Sign up here!",
                        color = TextWhite,
                        fontSize = 14.sp
                    )
                    //Sign up button
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 10.dp)
                    ) {
                        Button(
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = SignUpBtnClr),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .height(50.dp)
                                .fillMaxWidth(),
                            onClick = {  navController.navigate(Screen.SignUp.route) }
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
                            .padding(vertical = 50.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.kaira_signin), contentDescription = null, modifier = Modifier.height(250.dp))
                    }
                }
            }
        }
    )
}