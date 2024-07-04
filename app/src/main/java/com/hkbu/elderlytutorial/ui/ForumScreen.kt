/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hkbu.elderlytutorial.ui

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.hkbu.elderlytutorial.R
import com.hkbu.elderlytutorial.ui.DataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumScreen(
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    // TODO TopAppBar

    TopAppBar(
        title = { Text(text = stringResource(R.string.comments)) },
        navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action 2 click */ }) {
                Icon(painterResource(
                    id = R.drawable.baseline_qr_code_scanner_24),
                    contentDescription = "More",
                    modifier.size(100.dp).padding(8.dp )

                )
            }
        }
    )

    WebViewExample("https://eclub.hkbu.app/")
}

@Composable
fun WebViewExample(url: String) {
    val webViewState = remember { WebViewState() }

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(url)
                webViewState.setupWebView(this)
            }
        },
        update = { webView ->
            webView.loadUrl(url)
            webView.settings.javaScriptEnabled = true
            webViewState.setupWebView(webView)
        }
    )


}

private class WebViewState {
    private var webView: WebView? = null

    fun setupWebView(webView: WebView) {
        this.webView = webView
    }

    // Add any additional state or functionality that you need to manage here

    // For example:
    fun reloadPage() {
        webView?.reload()
    }
}

@Preview
@Composable
fun ForumPreview() {
    ForumScreen(
        modifier = Modifier.fillMaxHeight()
    )
}
