package uz.gita.bookappcompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.gita.bookappcompose.ui.theme.SELECTED_ICON_COLOR
import uz.gita.bookappcompose.ui.theme.UNSELECTED_ICON_COLOR

// Created by Jamshid Isoqov an 10/6/2022


@Composable
fun BottomNavItem(
    modifier: Modifier,
    imageRes: Int,
    name: String,
    isSelected: Boolean,
    block: () -> Unit
) {

    Column(
        modifier.clickable {
            block.invoke()
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(
                if (isSelected) SELECTED_ICON_COLOR
                else UNSELECTED_ICON_COLOR
            )
        )
        if (isSelected) {
            Text(text = name, color = SELECTED_ICON_COLOR)
        }
    }
}