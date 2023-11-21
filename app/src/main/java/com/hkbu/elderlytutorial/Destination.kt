package com.hkbu.elderlytutorial

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    //    val icon: ImageVector
    val route: String
//    val screen: @Composable () -> Unit
}

//sealed class Screen(val route: String) {
//    object Overview : Screen("overview")
//    object Whatsapp : Screen("whatsapp")
//}

object Overview : Destination {
    //    override val icon = Icons.Filled.PieChart
    override val route = "overview"
}

//object Whatsapp : Destination {
//    override val route = "whatsapp"
//}

