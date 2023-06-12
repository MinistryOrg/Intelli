package com.mom.intelli.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mom.intelli.ui.theme.BoardingBtnClr
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.viewmodels.OnBoardingViewModel
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.OnBoardingPage
import com.mom.intelli.util.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {

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
                Column{
                    val pageCount = 6
                    val pagerState = rememberPagerState()
                    val pages = listOf(
                        OnBoardingPage.First,
                        OnBoardingPage.Second,
                        OnBoardingPage.Third,
                        OnBoardingPage.Fourth,
                        OnBoardingPage.Fifth,
                        OnBoardingPage.Sixth,
                    )

                    HorizontalPager(
                        pageCount = pageCount,
                        state = pagerState,

                        ) { position ->
                        PagerScreen(onBoardingPage = pages[position])
                    }

                    Row(
                        Modifier
                            .height(25.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        repeat(pageCount) { iteration ->
                            val color = if (pagerState.currentPage == iteration) Color(0xFFE3E2DE) else Color(0xFF8D8D8D)
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(10.dp)

                            )
                        }
                    }
                    FinishButton(
                        modifier = Modifier.padding(top = 25.dp),
                        pagerState = pagerState
                    ){
                        onBoardingViewModel.saveOnBoardingState(completed = true)
                        navController.navigate(Screen.SignIn.route)
                    }
                }
            }
        }
    )
}



@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 60.dp),
            text = onBoardingPage.description,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = TextWhite
        )
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.7f))

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 90.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 5
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BoardingBtnClr,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Continue",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}