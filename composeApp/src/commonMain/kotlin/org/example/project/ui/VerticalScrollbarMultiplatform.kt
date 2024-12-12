package org.example.project.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun VerticalScrollbarMultiplatform(
    lazyListState: LazyListState,
    modifier: Modifier
)