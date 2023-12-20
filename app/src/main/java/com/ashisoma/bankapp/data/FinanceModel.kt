package com.ashisoma.bankapp.data;

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class FinanceModel(
        val id: Int,
        val title: String,
        val icon: ImageVector,
        val clr: Color
)