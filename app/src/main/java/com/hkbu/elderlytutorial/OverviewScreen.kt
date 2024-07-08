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
import com.hkbu.elderlytutorial.ui.grid.AlarmScreen
import com.hkbu.elderlytutorial.ui.grid.AppsScreen
import com.hkbu.elderlytutorial.ui.grid.CalendarScreen
import com.hkbu.elderlytutorial.ui.grid.ContactScreen
import com.hkbu.elderlytutorial.ui.DataSource
import com.hkbu.elderlytutorial.ui.ForumScreen
import com.hkbu.elderlytutorial.ui.elderly.ElderlyScreen
import com.hkbu.elderlytutorial.ui.elderly.ElderlyViewModel
import com.hkbu.elderlytutorial.ui.HomeScreen
import com.hkbu.elderlytutorial.ui.VideoScreen
import com.hkbu.elderlytutorial.ui.grid.WhatsappScreen
import com.hkbu.elderlytutorial.ui.grid.WifiScreen
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme

@Composable
fun ElderlyTutorialApp(
    viewModel: ElderlyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    //  val currentScreen = ElderlyScreen.Home

    ElderlyTutorialTheme {

        Scaffold { innerPadding ->

            val uiState by viewModel.uiStateFlow.collectAsState()
            var videoResId = R.raw.mobile_05_new_alarm_v1

            NavHost(
                navController = navController,
                startDestination = ElderlyScreen.Home.name,
                modifier = Modifier.padding(innerPadding),
            ) {
                composable(route = ElderlyScreen.Home.name) {
                    HomeScreen(
                        gridOptions = DataSource.gridOptions,
                        onGridItemClick = {
                            // TODO
                            navController.navigate(it)
                        },
                        navController,
                    )
                }
                composable(route = ElderlyScreen.Whatsapp.name) {
                    WhatsappScreen(
                        onWhatsappItemClicked = {
                            videoResId = DataSource.WhatsappItems.values()
                                .find { item -> item.title == it }?.resourceId!!
                            viewModel.setVideoId(videoResId)
                            navController.navigate("VideoScreen/{$videoResId}")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Calendar.name) {
                    CalendarScreen(
                        onCalendarItemClicked = {
                            videoResId = DataSource.CalendarItems.values()
                                .find { item -> item.title == it }?.resourceId!!
                            viewModel.setVideoId(videoResId)
                            navController.navigate("VideoScreen/{$videoResId}")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Alarm.name) {
                    AlarmScreen(
                        onAlarmItemClicked = {
                            videoResId = DataSource.AlarmItems.values()
                                .find { item -> item.title == it }?.resourceId!!
                            viewModel.setVideoId(videoResId)
                            navController.navigate("VideoScreen/{$videoResId}")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Contact.name) {
                    ContactScreen(
                        onContactItemClicked = {
                            videoResId = DataSource.ContactItems.values()
                                .find { item -> item.title == it }?.resourceId!!
                            viewModel.setVideoId(videoResId)
                            navController.navigate("VideoScreen/{$videoResId}")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Wifi.name) {
                    WifiScreen(
                        onWifiItemClicked = {
                            videoResId = DataSource.WifiItems.values()
                                .find { item -> item.title == it }?.resourceId!!
                            viewModel.setVideoId(videoResId)
                            navController.navigate("VideoScreen/{$videoResId}")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Apps.name) {
                    AppsScreen(
                        onAppsItemClicked = {
                            videoResId = DataSource.AppsItems.values()
                                .find { item -> item.title == it }?.resourceId!!
                            viewModel.setVideoId(videoResId)
                            navController.navigate("VideoScreen/{$videoResId}")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(
                    route = "VideoScreen/{$videoResId}",
                ) {
                    val whatsappVideoId = uiState.videoId
                    VideoScreen(whatsappVideoId)
                }

                composable(route = ElderlyScreen.Forum.name) {
                    ForumScreen(
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }

            }
        }
    }
}