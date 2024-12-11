package org.example.project

import platform.UIKit.UIPasteboard

class IOSClipboard: Clipboard {
    override fun setString(value: String) {
        UIPasteboard.generalPasteboard.string = value
    }

}

actual fun getClipboard(): Clipboard {
    UIPasteboard.generalPasteboard.string = "Hello"
    return IOSClipboard()
}