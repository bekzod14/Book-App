package uz.gita.bookappcompose.data.models

import androidx.compose.ui.graphics.Color


data class IntroData(
    val tittle:String,
    val img:Int,
    val content:String,
    val backgroundColor: Color = Color.Blue
)
