package com.mom.intelli.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mom.intelli.R
import com.mom.intelli.service.IntelliService
import com.mom.intelli.ui.theme.BorderClr
import com.mom.intelli.ui.theme.BoxClr
import com.mom.intelli.ui.theme.CardBorderClr
import com.mom.intelli.ui.theme.CardClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.TextWhite

@Composable
fun OtherAppWidget(
    paddingValues: Dp,
    intelliService: IntelliService
) {
    Card(
        modifier = Modifier
            .background(CardClr, shape = RoundedCornerShape(15.dp))
            .border(width = 2.dp, color = CardBorderClr, shape = RoundedCornerShape(15.dp))
            .padding(vertical = paddingValues)

    ) {
        Box(
            modifier = Modifier
                .background(CardClr)
                .fillMaxSize()
                .padding(10.dp)

        ) {
            Box(modifier = Modifier.align(Alignment.TopStart)) {
                Icon(
                    painter = painterResource(id = R.drawable.other_apps_icon),
                    contentDescription = "Email_icon",
                    tint = TextWhite,
                    modifier = Modifier
                        .size(25.dp),
                )
                Text(
                    text = "Other Apps",
                    color = TextWhite,
                    fontFamily = CustomFont,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 30.dp)
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 50.dp),
                modifier = Modifier
                    .height(250.dp),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    item { SettingsApp() }
                    item { AlarmApp() }
                    item { MusicApp() }
                    item { PhoneApp() }
                    item { MessageApp() }
                    item { ContactApp() }
                })
        }
    }
}

@Composable
fun SettingsApp() {
    Column(
        modifier = Modifier.clickable { /*todo*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.settings_icon),
            contentDescription = null,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Settings",
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AlarmApp() {
    Column(
        modifier = Modifier.clickable { /*todo*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(id = R.drawable.alarm_icon),
            contentDescription = null,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Alarm",
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MusicApp() {
    Column(
        modifier = Modifier.clickable { /*todo*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(id = R.drawable.music_icon),
            contentDescription = null,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Music",
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PhoneApp() {
    Column(
        modifier = Modifier.clickable { /*todo*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.phone_icon),
            contentDescription = null,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Phone",
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MessageApp() {
    Column(
        modifier = Modifier.clickable { /*todo*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(id = R.drawable.sms_icon),
            contentDescription = null,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Messages",
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactApp() {
    Column(
        modifier = Modifier.clickable { /*todo*/ },
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(id = R.drawable.contacts_icon),
            contentDescription = null,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Contacts",
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
    }
}