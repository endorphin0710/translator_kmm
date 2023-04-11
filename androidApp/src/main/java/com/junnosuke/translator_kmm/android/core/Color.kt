package com.junnosuke.translator_kmm.android.core

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.junnosuke.translator_kmm.core.presentation.Colors

val AccentViolet = Color(Colors.AccentViolet)
val LightBlue = Color(Colors.LightBlue)
val LightBlueGray = Color(Colors.LightBlueGrey)
val TextBlack = Color(Colors.TextBlack)
val DarkGray = Color(Colors.DarkGrey)

val lightColors = lightColors(
    primary = AccentViolet,
    background = LightBlueGray,
    onPrimary = Color.White,
    onBackground = TextBlack,
    surface = Color.White,
    onSurface = TextBlack
)

val darkColors = darkColors(
    primary = AccentViolet,
    background = DarkGray,
    onPrimary = Color.White,
    onBackground = Color.White,
    surface = DarkGray,
    onSurface = Color.White
)