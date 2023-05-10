package com.mom.intelli.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.ui.theme.MainBackgroundColor

@Composable
fun EshopWidget(
    paddingValues: Dp,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor),
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.eshop),
            contentDescription = null,
            modifier = Modifier
                .background(MainBackgroundColor)
        )
    }
}

@Composable
fun EshopScreen(
    navController: NavController
) {

}
