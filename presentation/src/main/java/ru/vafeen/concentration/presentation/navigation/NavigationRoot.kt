package ru.vafeen.concentration.presentation.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vafeen.concentration.presentation.MainActivityViewModel
import ru.vafeen.concentration.presentation.ui.theme.Theme
import ru.vafeen.concentration.presentation.ui.theme.mainDarkColor

@Composable
internal fun NavigationRoot(
    viewModel: MainActivityViewModel,
) {
    // Инициализация контроллера навигации
    viewModel.navController = rememberNavController()
    // Определение текущей темы (светлая или темная)
    val dark = isSystemInDarkTheme()
    val defaultColor = Theme.colors.mainColor

    // Получение настроек пользователя
//    val settings by viewModel.settings.collectAsState()

    // Определение основного цвета в зависимости от текущей темы
//    val mainColor by remember {
//        derivedStateOf {
//            settings.getMainColorForThisTheme(isDark = dark) ?: defaultColor
//        }
//    }


    // Scaffold для отображения интерфейса с нижней панелью
    Scaffold(containerColor = Theme.colors.singleTheme,
        bottomBar = {
            val selectedScreen by viewModel.currentScreen.collectAsState()
            BottomBar(
                selectedScreen = selectedScreen,
                bottomBarNavigator = viewModel,
                containerColor = mainDarkColor,
            )
        }) { innerPadding ->
        // Основное содержимое экрана
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Theme.colors.singleTheme)
        ) {
            // Навигация между экранами с помощью NavHost
            NavHost(
                modifier = Modifier.weight(1f),
                navController = viewModel.navController as NavHostController,
                startDestination = viewModel.startScreen
            ) {
                composable<Screen.Main> {

                }
                composable<Screen.Settings> {

                }
            }

        }
    }
}