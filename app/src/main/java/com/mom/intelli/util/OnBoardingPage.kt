package com.mom.intelli.util

import androidx.annotation.DrawableRes
import com.mom.intelli.R

sealed class OnBoardingPage (
    @DrawableRes
    val image: Int,
    val description: String
    ){
    object First : OnBoardingPage(
        image = R.drawable.kaira_onboarding_1,
        description = "Hello, my name is Kaira. \n" +
                "I’m your personal virtual assistant."
    )
    object Second : OnBoardingPage(
        image = R.drawable.kaira_onboarding_2,
        description = "I’m here to help you with everyday\n" +
                "tasks, like..."
    )
    object Third : OnBoardingPage(
        image = R.drawable.kaira_onboarding_3,
        description = "Planning your days"
    )
    object Fourth : OnBoardingPage(
        image = R.drawable.kaira_onboarding_4,
        description = "Check your forecast"
    )
    object Fifth : OnBoardingPage(
        image = R.drawable.kaira_onboarding_5,
        description = "Shopping"
    )
    object Sixth : OnBoardingPage(
        image = R.drawable.kaira_onboarding_6,
        description = "and a lot more!"
    )
}