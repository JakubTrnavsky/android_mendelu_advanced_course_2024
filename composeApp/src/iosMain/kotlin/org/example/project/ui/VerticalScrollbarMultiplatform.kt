package org.example.project.ui

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;

@Composable
actual fun VerticalScrollbarMultiplatform(
    lazyListState:LazyListState,
    modifier:Modifier
) {
    // No scrollbar for iOS
}