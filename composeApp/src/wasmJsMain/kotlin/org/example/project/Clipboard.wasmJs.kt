package org.example.project

import kotlinx.browser.window

class WasmClipboard: Clipboard {
    override fun setString(value: String) {
        window.navigator.clipboard.writeText(value)
    }
}

actual fun getClipboard(): Clipboard = WasmClipboard()