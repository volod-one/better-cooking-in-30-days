package com.example.bebetteratcookingin30days.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(

)

private val LightColorPalette = lightColors(
    background = Primary,
    surface = PrimaryText,
    onPrimary = PrimaryText,
    onSecondary = SecondaryText,
    onBackground = PrimaryText,
    onSurface = SecondaryText,
)

@Composable
fun BeBetterAtCookingIn30DaysTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}