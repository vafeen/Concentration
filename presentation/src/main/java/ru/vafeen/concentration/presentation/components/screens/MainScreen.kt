package ru.vafeen.concentration.presentation.components.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import org.koin.compose.getKoin
import org.koin.core.parameter.parameterArrayOf
import ru.vafeen.concentration.resources.R
import ru.vafeen.concentration.presentation.components.TextForThisTheme
import ru.vafeen.concentration.presentation.components.viewModels.MainScreenViewModel
import ru.vafeen.concentration.presentation.navigation.BottomBarNavigator
import ru.vafeen.concentration.presentation.navigation.Screen


@Composable
internal fun MainScreen(navigator: BottomBarNavigator) {
    val viewModel: MainScreenViewModel = getKoin().get { parameterArrayOf(navigator) }
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.openPlayScreen(context)
        }) {
            TextForThisTheme(text = stringResource(R.string.start_game))
        }
    }
}