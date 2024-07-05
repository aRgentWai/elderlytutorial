package com.hkbu.elderlytutorial


import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import androidx.annotation.RawRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NamedNavArgument
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
                            // TODO
                            navController.navigate(it)
                        },
                        navController,
                    )
                }
                composable(route = ElderlyScreen.Whatsapp.name) {
//                    val videoRes = R.raw.whatsapp_new_group
                    WhatsappScreen(
//                        options = DataSource.WhatsappItems.values().map {
//                            it.title
//                        },
                        onWhatsappItemClicked = {
                            val videoRes = DataSource.WhatsappItems.values().find { item -> item.title == it }?.resourceId
                            Log.d("videoRes", videoRes.toString())
                            Log.d("videoRes", DataSource.WhatsappItems.Setup.resourceId.toString())
                            navController.navigate("VideoScreen/$videoRes")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Calendar.name) {
                    CalendarScreen(
                        options = DataSource.WhatsappItems.values().map { it.title },
                        onCalendarItemClicked = {
                            navController.navigate("VideoScreen")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Alarm.name) {
                    AlarmScreen(
                        options = DataSource.AlarmItems.values().map { it.title },
                        onAlarmItemClicked = {
                            navController.navigate("VideoScreen")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Contact.name) {
                    ContactScreen(
                        options = DataSource.WhatsappItems.values().map { it.title },
                        onContactItemClicked = {
                            navController.navigate("VideoScreen")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Wifi.name) {
                    WifiScreen(
                        options = DataSource.WifiItems.values().map { it.title },
                        onWifiItemClicked = {
                            navController.navigate("VideoScreen")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Apps.name) {
                    val videoRes = R.raw.whatsapp_new_group
                    AppsScreen(
                        options = DataSource.AppsItems.values().map { it.title },
                        onAppsItemClicked = {
                            navController.navigate("VideoScreen")
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier
                    )
                }
                composable(route = ElderlyScreen.Video.name) {
                    val videoRes = DataSource.WhatsappItems.Dial.resourceId

                    VideoScreen(
                        videoItem = videoRes,
                    )
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