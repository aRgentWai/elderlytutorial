package com.hkbu.elderlytutorial


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hkbu.elderlytutorial.ui.DataSource
import com.hkbu.elderlytutorial.ui.ElderlyScreen
import com.hkbu.elderlytutorial.ui.ElderlyViewModel
import com.hkbu.elderlytutorial.ui.HomeScreen
import com.hkbu.elderlytutorial.ui.VideoScreen
import com.hkbu.elderlytutorial.ui.WhatsappScreen
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme

@Composable
fun ElderlyTutorialApp(
    viewModel: ElderlyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
//    val currentScreen = ElderlyScreen.Start

    ElderlyTutorialTheme {

        Scaffold { innerPadding ->

            val uiState by viewModel.uiState.collectAsState()

            NavHost(
                navController = navController,
                startDestination = ElderlyScreen.Home.name,
                modifier = Modifier.padding(innerPadding),
            ) {
                composable(route = ElderlyScreen.Home.name) {
                    HomeScreen(
                        gridOptions = DataSource.gridOptions,
                        onGridItemClick = {
                            // TODO change to position
                            navController.navigate(ElderlyScreen.Whatsapp.name)
                        },
                    )
                }
                composable(route = ElderlyScreen.Whatsapp.name) {
                    WhatsappScreen(
                        options = DataSource.WhatsappItems.values().map { it.title },
                        onWhatsappItemClicked = {
                            navController.navigate(ElderlyScreen.Video.name)
                        },
                        modifier = Modifier
                    )

                }
                composable(route = ElderlyScreen.Video.name) {
                    VideoScreen(
//                        videoItem = DataSource.,
                    )
                }
            }
        }
    }
}