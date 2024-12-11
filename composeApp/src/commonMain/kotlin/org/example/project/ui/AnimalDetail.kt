package org.example.project.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import animalsencyclopedia.composeapp.generated.resources.Res
import animalsencyclopedia.composeapp.generated.resources.ic_back
import animalsencyclopedia.composeapp.generated.resources.ic_copy
import org.example.project.data.Animal
import org.jetbrains.compose.resources.painterResource

@Composable
fun AnimalDetail(
    animal: Animal,
    showBackButton: Boolean = true,
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
                .padding(horizontal = 8.dp)
        ) {
            if (showBackButton) {
                IconButton(
                    modifier = Modifier.align(Alignment.TopStart),
                    onClick = onBackClick
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_back),
                        contentDescription = "Back"
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x1F7fb2d3))
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
        ) {
            Text(
                text = animal.name,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = animal.description,
                style = MaterialTheme.typography.body1
            )
        }
    }
}