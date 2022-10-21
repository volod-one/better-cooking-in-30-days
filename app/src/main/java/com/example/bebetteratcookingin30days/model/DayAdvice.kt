package com.example.bebetteratcookingin30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DayAdvice(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)