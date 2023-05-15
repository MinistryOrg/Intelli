package com.mom.intelli.data

import com.mom.intelli.R

sealed class EshopCategories(
    val imageResource: Int,
    val text: String
)

object TechCategory : EshopCategories(R.drawable.phone_img, "Tech")
object FurnitureCategory : EshopCategories(R.drawable.furniture_img,"Furniture")
object GroceriesCategory : EshopCategories(R.drawable.grocery_cart_img, "Groceries")
object SportsCategory : EshopCategories(R.drawable.sports_img,"Sports")
object FashionCategory : EshopCategories(R.drawable.fashion_img,"Fashion")

sealed class TechProducts(
    val imgProduct: Int,
    val titleProduct: String,
    val priceProduct: String
)

object IphoneProduct: TechProducts(R.drawable.iphone_13_pro_max,"Iphone 13 Pro Max 5G", "1.500,00€")