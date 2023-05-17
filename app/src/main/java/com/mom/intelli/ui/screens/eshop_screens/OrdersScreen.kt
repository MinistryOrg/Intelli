package com.mom.intelli.ui.screens.eshop_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.TextWhite

@Composable
fun OrdersScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Good Evening, Order",
            color = TextWhite,
            fontFamily = CustomFont,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(12.dp)
        )
    }
}