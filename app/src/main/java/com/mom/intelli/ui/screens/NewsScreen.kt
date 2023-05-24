package com.mom.intelli.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mom.intelli.R
import com.mom.intelli.data.news.NewsApiResponse
import com.mom.intelli.data.news.Results
import com.mom.intelli.ui.ImgnNewsLogo
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.DividerClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.MajorNewsBoxClr
import com.mom.intelli.ui.theme.NewsTitleClr
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.ui.theme.TitleForYouNewsClr
import com.mom.intelli.ui.theme.TitleMajorNewsClr
import com.mom.intelli.ui.theme.TitleSportsNewsClr
import com.mom.intelli.util.Screen

@Composable
fun NewsWidget(
    paddingValues: Dp,
    navController: NavController,
    intelliViewModel : IntelliViewModel
) {
    Card(
        modifier = Modifier
            .padding(vertical = paddingValues)
            .background(MainBackgroundColor)
            .clickable {
                navController.navigate(route = Screen.News.route)
            },
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = MainBackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .height(174.dp)
                .background(MainBackgroundColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.news_and_sports),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                Box(modifier = Modifier.align(Alignment.BottomStart)) {
                    Icon(
                        painter = painterResource(id = R.drawable.newspaper_icon),
                        contentDescription = "news_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "News and Sports",
                        color = TextWhite,
                        fontFamily = CustomFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }
                Box(modifier = Modifier.align(Alignment.TopEnd)){
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_icon),
                        contentDescription = "go_to_app_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(30.dp),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsScreen(
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
                    { ImgnNewsLogo() },
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
        content = { paddingValues: PaddingValues ->
            200.dp
            NewsMainScreen(
                navController = navController,
                intelliViewModel = intelliViewModel
            )
        }
    )
}

@Composable
fun NewsMainScreen(
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    var sportNews by remember {
        mutableStateOf<NewsApiResponse?>(null)
    }
    var majorNews by remember {
        mutableStateOf<NewsApiResponse?>(null)
    }
    var newsForYou by remember {
        mutableStateOf<NewsApiResponse?>(null)
    }

    LaunchedEffect(Unit) {
        try {
            val fetchedSportNews = intelliViewModel.getNews("sports")
            val fetchedMajorNews = intelliViewModel.getNews("politics")
            val fetchedNewsForYou = intelliViewModel.getNews("technology")
            sportNews = fetchedSportNews
            majorNews = fetchedMajorNews
            newsForYou = fetchedNewsForYou
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    Box(
        modifier = Modifier
            .background(MainBackgroundColor)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            //[TITLE]
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, top = 64.dp)
            ) {
                Text(
                    text = "Your Briefing",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            //[MAJOR NEWS SECTION]
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            ) {
                Text(
                    text =  "Major News",
                    color = TitleMajorNewsClr,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            LazyColumn(
                modifier = Modifier
                    .height(460.dp)
                    .padding(top = 10.dp),
                userScrollEnabled = true
            ){
                majorNews?.let { news ->
                    items(5) {
                        NewsBoxItem(news.results[it],intelliViewModel)
                    }
                }
            }
            //[DIVIDER]
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .padding(vertical = 1.dp)
                .background(TitleSportsNewsClr)
            )
            //[Sports NEWS SECTION]
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            ) {

                Text(
                    text = "Sports News",
                    color = TitleSportsNewsClr,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            LazyColumn(
                modifier = Modifier
                    .height(460.dp)
                    .padding(top = 10.dp),
                userScrollEnabled = true
            ){
                sportNews?.let { news ->
                    items(5) {
                        NewsBoxItem(news.results[it],intelliViewModel)
                    }
                }
            }
            //[DIVIDER]
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .padding(vertical = 1.dp)
                .background(TitleForYouNewsClr)
            )
            //[Based On Your Preferences NEWS SECTION]
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            ) {

                Text(
                    text = "News For you",
                    color = TitleForYouNewsClr,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            LazyColumn(
                modifier = Modifier
                    .height(460.dp)
                    .padding(top = 10.dp),
                userScrollEnabled = true
            ){
                newsForYou?.let { news ->
                    items(5) {
                        NewsBoxItem(news.results[it],intelliViewModel)
                    }
                }
            }
        }
    }

}

@Composable
fun NewsBoxItem(news : Results, intelliViewModel: IntelliViewModel) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MajorNewsBoxClr),
        shape = RoundedCornerShape(12.dp)
    ){
//        Log.d("key", news.imageUrl)
        AsyncImage(
            modifier =Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp)),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            model = news.image_url,
            contentDescription = news.description
        )
        Text(
            text = news.title,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .clickable {
                    intelliViewModel.openNewsLink(news.link,"link")
                },
            color = NewsTitleClr,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}