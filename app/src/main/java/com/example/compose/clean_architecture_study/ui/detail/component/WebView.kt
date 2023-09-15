package com.example.compose.clean_architecture_study.ui.detail.component

import android.content.Context
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember


@Composable
fun rememberWebView(
    context: Context,
    url: String
): WebView {

    return remember {
        WebView(context).apply {

            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            loadUrl(url)
        }
    }
}