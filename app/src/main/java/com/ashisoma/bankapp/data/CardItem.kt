package com.ashisoma.bankapp.data

import androidx.compose.ui.graphics.Color

data class CardItemModel(
    val id: Int,
    val title: String,
    val imageRes: Int,
    val gradientColors: List<Color>
)
