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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.mom.intelli.R
import com.mom.intelli.data.calendar.Reminder
import com.mom.intelli.ui.viewmodels.CalendarViewModel
import com.mom.intelli.ui.ImgCalendarLogo
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.theme.CalTextFieldBorderClr
import com.mom.intelli.ui.theme.CalendarBoxClr
import com.mom.intelli.ui.theme.CalendarReminderBoxClr
import com.mom.intelli.ui.theme.CustomFont
import com.mom.intelli.ui.theme.DaysClr
import com.mom.intelli.ui.theme.DialogBoxClr
import com.mom.intelli.ui.theme.IconsColor
import com.mom.intelli.ui.theme.MainBackgroundColor
import com.mom.intelli.ui.theme.OtherMonthTxtClr
import com.mom.intelli.ui.theme.SelectedDayClr
import com.mom.intelli.ui.theme.TextColor
import com.mom.intelli.ui.theme.TextWhite
import com.mom.intelli.util.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale

//THIS IS THE WIDGET TO THE HOME SCREEN
@Composable
fun CalendarWidget(
    paddingValues: Dp,
    navController: NavController,
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
                painter = painterResource(id = R.drawable.calendar_1),
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
                Column {
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
    navController: NavController,
    intelliViewModel: IntelliViewModel
) {
    val calendarViewModel: CalendarViewModel = CalendarViewModel()
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
                CalendarScreen(calendarViewModel, navController, intelliViewModel)
            }
        }
    )
}

@Composable
fun CalendarScreen(viewModel: CalendarViewModel, navController: NavController, intelliViewModel: IntelliViewModel) {
    val currentMonth by viewModel.currentMonth.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()
    var showAddReminderDialog by remember { mutableStateOf(false) }
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

    var calendar by remember { mutableStateOf(Calendar.getInstance().time) }
    var dateFormat by remember { mutableStateOf(DateFormat.getDateInstance(DateFormat.FULL).format(calendar)) }

    var reminders by remember { mutableStateOf<List<Reminder>?>(null) }

    LaunchedEffect(Unit) { // to change the time in real time
        while (true) {
            delay(1000) // Delay for 1 second
            calendar = Calendar.getInstance().time
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)
        }
    }
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(CalendarBoxClr)
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            Text(
                text = dateFormat,
                color = DaysClr,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .padding(vertical = 1.dp, horizontal = 5.dp)
            .background(DaysClr)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = { viewModel.navigateMonth(-1) }) {
                Icon(painter = painterResource(id = R.drawable.navigate_before_icon), contentDescription = "Previous Month", tint = DaysClr)
            }
            Text(
                text = "${currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} ${currentMonth.year}",
                modifier = Modifier.align(Alignment.CenterVertically),
                color = TextWhite,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = { viewModel.navigateMonth(1) }) {
                Icon(painter = painterResource(id = R.drawable.navigate_next_icon), contentDescription = "Previous Month", tint = DaysClr)
            }

        }
        Row(Modifier.fillMaxWidth()) {
            for (dayOfWeek in daysOfWeek) {
                Text(
                    text = dayOfWeek,
                    modifier = Modifier.weight(1f),
                    color = DaysClr,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        }

        CalendarGrid(currentMonth, selectedDate, viewModel::selectDate)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                shape = RoundedCornerShape(13.dp),
                onClick = { showAddReminderDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = SelectedDayClr
                )
            ) {
                Icon(painter = painterResource(id = R.drawable.calendar_add_icon), contentDescription = null, tint = TextWhite, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Text("Add Reminder")
            }
        }

        LaunchedEffect(selectedDate) {
            selectedDate?.let { date ->
                reminders = intelliViewModel.getRemindersByDate(date)
            }
        }

        reminders?.let {
            ReminderList(it)
        }

        if (showAddReminderDialog) {
            Dialog(
                onDismissRequest = {
                    showAddReminderDialog = false
                },
                properties = DialogProperties(dismissOnClickOutside = true)
            ) {
                AddReminderScreen(
                    viewModel = viewModel,
                    navController,
                    intelliViewModel,
                    showAddReminderDialog,
                    onCloseWindow = { showAddReminderDialog = false }
                )
            }
        }
    }
}

@Composable
fun CalendarGrid(
    currentMonth: LocalDate,
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate) -> Unit
) {
    val dates = remember(currentMonth) { generateDatesForMonth(currentMonth) }
    val currentMonthYear = YearMonth.from(currentMonth)
    val currentDate = LocalDate.now()
    LazyVerticalGrid(columns = GridCells.Fixed(7)) {
        items(dates) { date ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .aspectRatio(1f)
                    .clickable { onDateSelected(date) },
                contentAlignment = Alignment.Center
            ) {

                val textColor = if (date.month == currentMonthYear.month) {
                    if (date == currentDate) {
                        // Highlight the current date
                        DaysClr
                    } else {
                        // Color for dates in the current month
                        TextWhite
                    }
                } else {
                    // Color for dates outside the current month
                    OtherMonthTxtClr
                }

                Text(
                    text = date.dayOfMonth.toString(),
                    color = textColor,
                    modifier = Modifier
                        .background(
                            if (date == selectedDate) SelectedDayClr else Color.Transparent,
                            shape = CircleShape
                        )
                        .padding(8.dp)
                )
            }
        }
    }
}

fun generateDatesForMonth(month: LocalDate): List<LocalDate> {
    val firstDayOfMonth = month.withDayOfMonth(1)
    val firstDayOfWeek = firstDayOfMonth.minusDays(firstDayOfMonth.dayOfWeek.value.toLong() % 7)
    val dates = mutableListOf<LocalDate>()

    val firstDayOfNextMonth = month.plusMonths(1).withDayOfMonth(1)
    var currentDate = firstDayOfWeek
    while (currentDate.isBefore(firstDayOfNextMonth)) {
        dates.add(currentDate)
        currentDate = currentDate.plusDays(1)
    }

    return dates
}
@Composable
fun ReminderList(reminders : List<Reminder>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(CalendarReminderBoxClr)
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(50.dp))
                .height(7.dp)
                .padding(vertical = 1.dp, horizontal = 140.dp)
                .background(DaysClr, shape = RoundedCornerShape(50.dp))
        )

        reminders.let { value ->
            value.forEach { reminder ->
                Text(
                    text = reminder.title,
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = reminder.description,
                    color = TextWhite,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(50.dp))
                        .height(3.dp)
                        .padding(vertical = 1.dp)
                        .background(DaysClr, shape = RoundedCornerShape(50.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}


    @Composable
    fun AddReminderScreen(
        viewModel: CalendarViewModel,
        navController: NavController,
        intelliViewModel: IntelliViewModel,
        showAddReminderDialog: Boolean,
        onCloseWindow: () -> Unit // Callback function to close the window
    ) {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(CalTextFieldBorderClr)
                .fillMaxWidth()
                .padding(vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add New Reminder",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                singleLine = false,
                maxLines = 1,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedBorderColor = DialogBoxClr,
                    focusedLabelColor = TextColor,
                    focusedSupportingTextColor = TextColor,
                    cursorColor = DialogBoxClr,
                    unfocusedLabelColor = TextColor,
                    unfocusedBorderColor = DialogBoxClr
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                singleLine = false,
                maxLines = 1,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedBorderColor = DialogBoxClr,
                    focusedLabelColor = TextColor,
                    focusedSupportingTextColor = TextColor,
                    cursorColor = DialogBoxClr,
                    unfocusedLabelColor = TextColor,
                    unfocusedBorderColor = DialogBoxClr
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                shape = RoundedCornerShape(13.dp),
                onClick = {
                    coroutineScope.launch {
                        val reminder =
                            Reminder(0, viewModel.selectedDate.value!!, title, description)
                        intelliViewModel.insertReminderToDatabase(reminder)
                        onCloseWindow() // Close the window

                    }


                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = SelectedDayClr
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_add_icon),
                    contentDescription = null,
                    tint = TextWhite,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("Add Reminder")
            }
        }
    }
