package ru.vafeen.concentration.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import ru.vafeen.concentration.presentation.navigation.BottomBarNavigator
import ru.vafeen.concentration.presentation.navigation.Screen
import kotlin.system.exitProcess

/**
 * ViewModel для управления состоянием главной активности приложения.
 * Обрабатывает обновления, миграцию данных, навигацию и общие ошибки.
 */
internal class MainActivityViewModel(context: Context) : ViewModel(), BottomBarNavigator {


    /**
     * Экран, который должен отображаться при запуске приложения.
     */
    val startScreen = Screen.Main

    /**
     * Контроллер навигации, управляющий переходами между экранами.
     */
    override var navController: NavHostController? = null

    /**
     * Поток состояния, отслеживающий текущий экран приложения.
     */
    private val _currentScreen: MutableStateFlow<Screen> = MutableStateFlow(startScreen)
    override val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    /**
     * Эмитирует текущий экран на основе стека навигации.
     * Отслеживает изменения в backStack навигации и обновляет состояние текущего экрана.
     */
    private fun emitCurrentScreen() {
        viewModelScope.launch(Dispatchers.Main) {
            navController?.currentBackStackEntryFlow?.collect { backStackEntry ->
                val destination = backStackEntry.destination
                when {
                    destination.hasRoute(Screen.Main::class) -> _currentScreen.emit(Screen.Main)
                    destination.hasRoute(Screen.Settings::class) -> _currentScreen.emit(Screen.Settings)
                }
            }
        }
    }

    /**
     * Обрабатывает действие "Назад". Переходит на предыдущий экран в навигации.
     */
    override fun back() {
        navController?.popBackStack()
        emitCurrentScreen()
    }

    /**
     * Переходит на указанный экран.
     *
     * @param screen Целевой экран для навигации.
     */
    override fun navigateTo(screen: Screen) {
        if (screen != Screen.Main)
            navController?.navigate(screen)
        else navController?.popBackStack()
        emitCurrentScreen()
    }


}