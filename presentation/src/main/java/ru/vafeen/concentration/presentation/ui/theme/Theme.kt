package ru.vafeen.concentration.presentation.ui.theme

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import org.koin.compose.getKoin
import ru.vafeen.concentration.domain.IconsTheme
import ru.vafeen.concentration.domain.service.SettingsManager
import ru.vafeen.concentration.presentation.ui.theme.palette.Colors
import ru.vafeen.concentration.presentation.ui.theme.palette.IconsPalette
import ru.vafeen.concentration.presentation.ui.theme.palette.animalsPalette
import ru.vafeen.concentration.presentation.ui.theme.palette.baseDarkPalette
import ru.vafeen.concentration.presentation.ui.theme.palette.baseLightPalette
import ru.vafeen.concentration.presentation.ui.theme.palette.emojiPalette
import ru.vafeen.concentration.presentation.ui.theme.palette.sportPalette


@Composable
internal fun MainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val settingsManager: SettingsManager = getKoin().get()
    val settings by settingsManager.settingsFlow.collectAsState()
    val iconsTheme =
        when (settings.cardsTheme) {
        IconsTheme.SPORT_THEME -> sportPalette
        IconsTheme.ANIMALS_THEME -> animalsPalette
        IconsTheme.EMOJI_THEME -> emojiPalette
    }

    val colors = if (!darkTheme) baseLightPalette
    else baseDarkPalette

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalIcons provides iconsTheme,
        content = content
    )
}

internal object Theme {
    val colors: Colors
        @ReadOnlyComposable @Composable
        get() = LocalColors.current
    val icons: IconsPalette
        @ReadOnlyComposable @Composable
        get() = LocalIcons.current
}

private val LocalColors = staticCompositionLocalOf<Colors> {
    error("Composition error")
}
private val LocalIcons = staticCompositionLocalOf<IconsPalette> {
    error("Composition error")
}