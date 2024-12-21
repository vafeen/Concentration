package ru.vafeen.concentration.presentation.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.getKoin
import ru.vafeen.concentration.presentation.components.viewModels.PlayScreenViewModel

@Composable
internal fun PlayScreen() {
    val viewModel: PlayScreenViewModel = getKoin().get()
    Column(modifier = Modifier.fillMaxSize()) {

    }
}