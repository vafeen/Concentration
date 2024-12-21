package ru.vafeen.concentration.presentation.components.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.compose.ui.unit.dp
import org.koin.compose.getKoin
import ru.vafeen.concentration.presentation.components.PlayCard
import ru.vafeen.concentration.presentation.components.viewModels.PlayScreenViewModel
import ru.vafeen.concentration.presentation.ui.theme.Theme

@Composable
internal fun PlayScreen() {
    val viewModel: PlayScreenViewModel = getKoin().get()
    val settings by viewModel.settingsFlow.collectAsState()
    val theme by rememberUpdatedState(Theme.icons.theme)

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        columns = GridCells.Adaptive(minSize = 80.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(theme + theme + theme) {
            Box {
                PlayCard(it)
            }
        }
    }
}