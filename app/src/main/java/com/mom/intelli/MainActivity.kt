package com.mom.intelli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mom.intelli.ui.theme.IntelliTheme
import com.mom.intelli.util.nav_graph.SetupNavGraph


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntelliTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)

            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    IntelliTheme {
//        HomeScreen()
//    }
//}