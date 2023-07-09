package com.mom.intelli.ui.viewmodels

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mom.intelli.data.OnBoardingStoreData
import com.mom.intelli.util.HOME_GRAPH_ROUTE
import com.mom.intelli.util.Screen
import dagger.hilt.android.HiltAndroidApp


class SplashViewModel @Inject constructor(
    private val repository: OnBoardingStoreData
) : ViewModel() {
    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.OnBoarding.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = HOME_GRAPH_ROUTE
                } else {
                    _startDestination.value = Screen.OnBoarding.route
                }
                _isLoading.value = false // Move this line inside the collect block
            }
        }
    }

}