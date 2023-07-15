package com.mom.intelli.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen


@Composable
fun DialogBox(
    textTitle: String,
    textBtn: String,
    DialogClr: Color,
    DialogBtnClr: Color,
    onCloseWindow: () -> Unit
){
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(DialogClr)
            .fillMaxWidth()
            .padding(vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = textTitle,
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 1.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        Button(
            shape = RoundedCornerShape(13.dp),
            onClick = { onCloseWindow() },
            colors = ButtonDefaults.buttonColors(
                containerColor = DialogBtnClr
            )
        ) {
            Text(textBtn)
        }
    }
}


@Composable
fun DialogBoxThankYou(
    navController: NavController,
    textTitle: String,
    textBtn: String,
    DialogClr: Color,
    DialogBtnClr: Color,
    onCloseWindow: () -> Unit
){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(DialogClr)
            .fillMaxWidth()
            .padding(vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = textTitle,
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            shape = RoundedCornerShape(13.dp),
            onClick = {
                onCloseWindow()
                navController.navigate(Screen.Eshop.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = DialogBtnClr
            )
        ) {
            Text(textBtn)
        }
    }
}

