package com.hkbu.elderlytutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElderlyTutorialApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ElderlyTutorialTheme {
        ElderlyTutorialApp()
    }
}