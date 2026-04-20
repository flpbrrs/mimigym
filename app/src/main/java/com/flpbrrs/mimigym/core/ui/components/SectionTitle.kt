package com.flpbrrs.mimigym.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.flpbrrs.mimigym.core.ui.theme.MimiGymTheme

@Composable
fun SectionTitle(modifier: Modifier = Modifier, title: String = "Title") {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = title,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.labelLarge
    )
}

@Preview(showBackground = true)
@Composable
private fun SectionTitlePreview() {
    MimiGymTheme {
        SectionTitle()
    }
}