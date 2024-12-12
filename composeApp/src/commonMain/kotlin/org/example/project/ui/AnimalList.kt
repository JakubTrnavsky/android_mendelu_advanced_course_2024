package org.example.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.example.project.data.Animal

@Composable
fun AnimalList(
    animals: List<Animal>,
    onItemClick: (Animal) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = rememberLazyListState()

    Row(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFF7fb2d3)),
            state = state
        ) {
            items(items = animals) { animal ->
                AnimalListItem(
                    animal = animal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(animal) }
                        .padding(
                            horizontal = 16.dp,
                            vertical = 4.dp
                        )
                )
            }
        }
        VerticalScrollbarMultiplatform(
            modifier = Modifier.fillMaxHeight(),
            lazyListState = state,
        )
    }
}

@Composable
fun AnimalListItem(
    animal: Animal,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colors.surface)
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
    ) {
        Text(
            text = animal.name,
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}