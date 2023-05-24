package com.mom.intelli.ui.screens

import android.annotation.SuppressLint
import android.icu.text.DateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.calendar.CalendarDay
import com.mom.intelli.data.calendar.Reminder
import com.mom.intelli.ui.ImgCalendarLogo
import com.mom.intelli.ui.theme.CalendarBoxClr
import com.mom.intelli.ui.theme.CurrentMonthTxtClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.DaysClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.OtherMonthTxtClr
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen
import kotlinx.coroutines.delay
import java.time.Month
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale

val listOfDays = listOf(
    "M","T","W","T","F","S","S"
)

//THIS IS THE WIDGET TO THE HOME SCREEN
@Composable
fun CalendarWidget(
    paddingValues: Dp,
    navController: NavController
) {

    var calendar by remember { mutableStateOf(Calendar.getInstance().time) }
    var dateFormat by remember { mutableStateOf(DateFormat.getDateInstance(DateFormat.FULL).format(calendar)) }
    var timeFormat by remember { mutableStateOf(DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar)) }

    LaunchedEffect(Unit) { // to change the time in real time
        while (true) {
            delay(1000) // Delay for 1 second
            calendar = Calendar.getInstance().time
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)
            timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar)
        }
    }

    Card(
        modifier = Modifier
            .background(MainBackgroundColor)
            .padding(vertical = paddingValues)
            .clickable {
                navController.navigate(route = Screen.Calendar.route)
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
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier
                    .background(MainBackgroundColor),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
                Column() {
                    Text(
                        text = dateFormat,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = timeFormat,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Box(modifier = Modifier.align(Alignment.BottomStart)) {
                    Icon(
                        painter = painterResource(id = R.drawable.calendar_icon),
                        contentDescription = "Calendar_icon",
                        tint = TextWhite,
                        modifier = Modifier
                            .size(25.dp),
                    )
                    Text(
                        text = "Calendar",
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

//THIS IS THE CALENDAR SCREEN
//TODO !!TO GO BACK TO HOME SCREEN USE navController.popBackStack()

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Column(
                modifier = Modifier
                    .background(MainBackgroundColor)
            ) {
                CenterAlignedTopAppBar(
                    { ImgCalendarLogo() },
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
        content = {
            Box(
                modifier = Modifier
                    .background(MainBackgroundColor)
                    .fillMaxSize()
                    .padding(top = 80.dp)

            ){
                MainCalendarScreen()
            }
        }
    )
}


/*
###########################################################################################################################################################################################
#TODO DEN EXW IDEA TI ME EVALE NA GRAPSW TO BOTAKI ALLA DOULEUEI. TWRA APO EDW KAI PERA KANE OTI THES METAKINHSE SE ALLO ARXEIO OTI THES DEN KSERW KANE OTI THES. EGW THA FTIAXW TO DESIGN#
###########################################################################################################################################################################################
*/
@Composable
fun ReminderList(reminders: List<Reminder>) {
    LazyColumn {
        items(reminders) { reminder ->
            ReminderItem(reminder)
        }
    }
}
@Composable
fun ReminderItem(reminder: Reminder) {
    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = reminder.time.toJavaLocalTime().format(timeFormatter),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = reminder.title,
            modifier = Modifier.weight(3f)
        )
    }
}


@Composable
fun Calendar(days: List<java.time.LocalDate>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(0, 0, 8, 8))
            .fillMaxWidth()
            .background(CalendarBoxClr)

    ) {
        items(days.size) { index ->
            val day = days[index]
            val isCurrentMonth = day.monthValue == java.time.LocalDate.now().monthValue
            val textColor = if (isCurrentMonth) CurrentMonthTxtClr else OtherMonthTxtClr

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day.dayOfMonth.toString(),
                    color = textColor
                )
            }
        }
    }
}

@Composable
fun CalendarDayItem(day: CalendarDay, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(
                color = when {
                    day.isSelected -> Color.Blue
                    day.isToday -> Color.Yellow
                    day.isDisabled -> Color.Gray
                    else -> Color.White
                }
            )
            .clickable(onClick = onClick)
            .size(48.dp)
    ) {
        Text(
            text = day.date.dayOfMonth.toString(),
            color = when {
                day.isSelected -> Color.White
                day.isDisabled -> Color.LightGray
                else -> Color.Black
            },
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

fun generateCalendarDays(monthYear: YearMonth): List<java.time.LocalDate> {
    val firstDayOfMonth = monthYear.atDay(1)
    val firstDayOfGrid = firstDayOfMonth.minusDays(firstDayOfMonth.dayOfWeek.value.toLong() - 1)
    val lastDayOfMonth = monthYear.atEndOfMonth()
    val lastDayOfGrid = lastDayOfMonth.plusDays(7 - lastDayOfMonth.dayOfWeek.value.toLong())

    return generateSequence(firstDayOfGrid) { it.plusDays(1) }
        .takeWhile { it.isBefore(lastDayOfGrid) }
        .toList()
}


@Composable
fun CalendarHeader(month: Int, year: Int, onPreviousMonth: () -> Unit, onNextMonth: () -> Unit) {
    val monthName = Month.of(month).getDisplayName(TextStyle.FULL, Locale.getDefault())

    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(20, 20, 0, 0))
            .fillMaxWidth()
            .background(CalendarBoxClr)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onPreviousMonth) {
            Icon(painter = painterResource(id = R.drawable.navigate_before_icon), contentDescription = "Previous Month", tint = DaysClr)
        }

        Text(text = "$monthName $year", color = TextWhite)

        IconButton(onClick = onNextMonth) {
            Icon(painter = painterResource(id = R.drawable.navigate_next_icon), contentDescription = "Next Month", tint = DaysClr)
        }
    }
    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth()
            .background(CalendarBoxClr)
            .padding(horizontal = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "M", color = DaysClr)
        Text(text = "T", color = DaysClr)
        Text(text = "W", color = DaysClr)
        Text(text = "T", color = DaysClr)
        Text(text = "F", color = DaysClr)
        Text(text = "S", color = DaysClr)
        Text(text = "S", color = DaysClr)
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MainCalendarScreen() {
    val currentMonthYear = remember { mutableStateOf(YearMonth.now()) }

    Column {
        CalendarHeader(
            month = currentMonthYear.value.monthValue,
            year = currentMonthYear.value.year,
            onPreviousMonth = {
                currentMonthYear.value = currentMonthYear.value.minusMonths(1)
            },
            onNextMonth = {
                currentMonthYear.value = currentMonthYear.value.plusMonths(1)
            }
        )

        val days = generateCalendarDays(currentMonthYear.value)
        Calendar(days)
    }

}
