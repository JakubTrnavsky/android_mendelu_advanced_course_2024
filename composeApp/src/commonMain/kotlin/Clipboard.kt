package org.example.project

interface Clipboard {
    fun setString(value: String)
}

expect fun getClipboard(): Clipboard