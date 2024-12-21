package ru.vafeen.concentration.presentation.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vafeen.concentration.presentation.MainActivityViewModel
import ru.vafeen.concentration.presentation.components.screens.MainScreen
import ru.vafeen.concentration.presentation.components.screens.PlayScreen
import ru.vafeen.concentration.presentation.ui.theme.Theme
import ru.vafeen.concentration.presentation.ui.theme.mainDarkColor

@OptIn(ExperimentalAnimationApi::class)
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
    Scaffold(containerColor = Theme.colors.singleTheme, bottomBar = {
        val selectedScreen by viewModel.currentScreen.collectAsState()
        if (selectedScreen != Screen.Play) {
            BottomBar(
                selectedScreen = selectedScreen,
                bottomBarNavigator = viewModel,
                containerColor = mainDarkColor,
            )
        }
    }) { innerPadding ->
        // Основное содержимое экрана
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Theme.colors.singleTheme)
        ) {
            // Навигация между экранами с помощью NavHost
            val tween: FiniteAnimationSpec<Float> = tween(0)
            NavHost(
                modifier = Modifier.weight(1f),
                navController = viewModel.navController as NavHostController,
                startDestination = viewModel.startScreen,
                enterTransition = { fadeIn(animationSpec = tween) }, // No enter animation
                exitTransition = { fadeOut(animationSpec = tween) },  // No exit animation
                popEnterTransition = { fadeIn(animationSpec = tween) }, // No pop enter animation
                popExitTransition = { fadeOut(animationSpec = tween) }  // No pop exit animation
            ) {
                composable<Screen.Main> {
                    MainScreen(viewModel)
                }
                composable<Screen.Settings> {

                }
                composable<Screen.Play> {
                    PlayScreen()
                }
            }

        }
    }
}