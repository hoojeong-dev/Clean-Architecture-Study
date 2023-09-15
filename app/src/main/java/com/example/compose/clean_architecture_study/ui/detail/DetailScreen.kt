package com.example.compose.clean_architecture_study.ui.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.compose.clean_architecture_study.ui.detail.component.rememberWebView


@Composable
fun DetailScreen(url: String) {

    val context = LocalContext.current
    val webView = rememberWebView(
        context = context,
        url = url
    )

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { webView }
    )
}