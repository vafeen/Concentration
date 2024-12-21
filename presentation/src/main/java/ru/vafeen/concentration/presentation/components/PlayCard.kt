package ru.vafeen.concentration.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vafeen.concentration.presentation.ui.theme.FontSize
import ru.vafeen.concentration.presentation.ui.theme.Theme

@Composable
fun PlayCard(icon: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Theme.colors.cardColor)
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            text = icon, fontSize = FontSize.gigant50
        )
    }
}