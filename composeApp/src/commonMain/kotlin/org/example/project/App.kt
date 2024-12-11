package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.example.project.data.Animal
import org.example.project.data.AnimalMock
import org.example.project.ui.AnimalDetail
import org.example.project.ui.AnimalList

@Composable
@Preview
fun App() {
    MaterialTheme {
        val animals = remember { AnimalMock.mockList() }
        var selectedAnimalState by remember { mutableStateOf<Animal?>(null) }

        when (val selectedAnimal = selectedAnimalState) {
            null -> {
                AnimalList(
                    animals = animals,
                    onItemClick = { clickedAnimal ->
                        selectedAnimalState = clickedAnimal
                    },
                )
            }
            else -> {
                AnimalDetail(
                    animal = selectedAnimal,
                    onBackClick = { selectedAnimalState = null },
                )
            }
        }
    }
}