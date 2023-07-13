package com.mom.intelli.ui.screens.eshop_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mom.intelli.data.eshop.EshopCategories
import com.mom.intelli.data.eshop.FashionCategory
import com.mom.intelli.data.eshop.FurnitureCategory
import com.mom.intelli.data.eshop.GroceriesCategory
import com.mom.intelli.data.eshop.SportsCategory
import com.mom.intelli.data.eshop.TechCategory
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.BoxClr
import com.mom.intelli.ui.theme.UnSelectTabTxtClr

val categData = listOf(
    TechCategory,
    FurnitureCategory,
    GroceriesCategory,
    SportsCategory,
    FashionCategory
)


@Composable
fun StoreScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(categData.size){ index ->
                    CategoryBoxes(navController, categData[index])
                }

            }
        )
    }
}

@Composable
fun CategoryBoxes(
    navController: NavController,
    categData: EshopCategories
) {
    Column(
        modifier = Modifier
            .background(BoxClr, shape = RoundedCornerShape(18.dp))
            .border(width = 2.dp, color = BorderClr, shape = RoundedCornerShape(18.dp))
            .padding(10.dp)
            .height(160.dp)
            .clickable { navController.navigate(getCategoryRoute(categData)) },
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = categData.imageResource),
            contentDescription = "tech",
            modifier = Modifier
                .size(130.dp)
                .padding(vertical = 20.dp)
        )
        Column(
            modifier = Modifier.padding(top=1.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = categData.text, color = UnSelectTabTxtClr, fontWeight = FontWeight.Bold)
        }
    }
}

fun getCategoryRoute(categData: EshopCategories):String{
    return when(categData){
        TechCategory -> "eshop_tech_screen"
        FurnitureCategory -> "eshop_furn_screen"
        GroceriesCategory -> "eshop_groc_screen"
        SportsCategory -> "eshop_sports_screen"
        FashionCategory -> "eshop_fash_screen"
    }
}
