package org.example.project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.example.project.data.Animal
import org.example.project.data.AnimalMock
import org.example.project.ui.AnimalDetail
import org.example.project.ui.AnimalList

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val navigator = rememberListDetailPaneScaffoldNavigator<Animal>()
        val animals = remember { AnimalMock.mockList() }

        ListDetailPaneScaffold(
            modifier = Modifier.fillMaxSize(),
            directive = navigator.scaffoldDirective,
            value = navigator.scaffoldValue,
            listPane = {
                AnimatedPane {
                    AnimalList(
                        animals = animals,
                        onItemClick = { item ->
                            // Navigate to the detail pane with the passed item
                            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, item)
                        },
                    )
                }
            },
            detailPane = {
                AnimatedPane {
                    // Show the detail pane content if selected item is available
                    navigator.currentDestination?.content?.let { animal ->
                        AnimalDetail(
                            animal = animal,
                            showBackButton = navigator.canNavigateBack(),
                            onBackClick = { navigator.navigateBack() },
                        )
                    }
                }
            },
        )
    }
}