package ru.vafeen.concentration.presentation.components.viewModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import ru.vafeen.concentration.presentation.navigation.BottomBarNavigator
import ru.vafeen.concentration.presentation.navigation.Screen
import ru.vafeen.concentration.resources.R

internal class MainScreenViewModel(
    private val navigator: BottomBarNavigator,
) : ViewModel() {

    fun openPlayScreen(context: Context) {
        navigator.navigateTo(Screen.Play)
        Toast.makeText(context, context.getString(R.string.game_started), Toast.LENGTH_LONG).show()
    }

}