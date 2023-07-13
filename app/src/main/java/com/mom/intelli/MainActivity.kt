package com.mom.intelli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mom.intelli.ui.viewmodels.IntelliViewModel
import com.mom.intelli.ui.viewmodels.SplashViewModel
import com.mom.intelli.ui.theme.IntelliTheme
import com.mom.intelli.util.nav_graph.SetupNavGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val intelliViewModel: IntelliViewModel by viewModels()
    lateinit var navController: NavHostController

    @Inject
    lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        intelliViewModel.init(this)

        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{
            !splashViewModel.isLoading.value
        }
        setContent {
            IntelliTheme {
                val screen by splashViewModel.startDestination
                navController = rememberNavController()
                SetupNavGraph(navController = navController, intelliViewModel,this, startDestination = screen)
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