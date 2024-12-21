package ru.vafeen.concentration.presentation.ui.theme.palette

import androidx.compose.ui.graphics.Color
import ru.vafeen.concentration.presentation.ui.theme.mainDarkColor
import ru.vafeen.concentration.presentation.ui.theme.mainLightColor

internal data class Colors(
    val mainColor: Color,
    val singleTheme: Color,
    val oppositeTheme: Color,
    val buttonColor: Color,
    val cardColor: Color,
)

internal val baseLightPalette = Colors(
    mainColor = mainLightColor,
    singleTheme = Color.White,
    oppositeTheme = Color.Black,
    buttonColor = Color.White,
    cardColor = Color.Red
)
internal val baseDarkPalette = baseLightPalette.copy(
    mainColor = mainDarkColor,
    singleTheme = Color.Black,
    oppositeTheme = Color.White,
    buttonColor = Color(0xFF2D2D31)
)
