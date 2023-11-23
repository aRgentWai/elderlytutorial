package com.hkbu.elderlytutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hkbu.elderlytutorial.R
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme

class WhatsappScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElderlyTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SmallTopAppBarExample()
                    VideoButton()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Small Top App Bar")
                }
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@Composable
fun VideoButton() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.setup_name_and_icon))
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.send_message))
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.create_and_quit_group))
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.story_and_whatsapp_dialing))
        }
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ElderlyTutorialTheme {
        SmallTopAppBarExample()
    }
}