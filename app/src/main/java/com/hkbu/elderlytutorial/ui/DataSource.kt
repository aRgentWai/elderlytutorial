package com.hkbu.elderlytutorial.ui

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.hkbu.elderlytutorial.R

object DataSource {

//    val images = listOf(
//        R.drawable.baseline_whatsapp_24,
//        R.drawable.baseline_calendar_month_24,
//        R.drawable.baseline_access_alarm_24,
//        R.drawable.outline_contact_page_24,
//        R.drawable.baseline_wifi_24,
//        R.drawable.baseline_apps_24,
////        Icons.Default.Phone,
//    )
//
//    val strings = listOf(
//        R.string.whatsapp,
//        R.string.calendar,
//        R.string.time_alarm,
//        R.string.contact,
//        R.string.wifi_setting,
//        R.string.application
//    )

    val gridOptions = listOf(
        Pair(R.drawable.baseline_whatsapp_24, R.string.whatsapp),
        Pair(R.drawable.baseline_calendar_month_24, R.string.calendar),
        Pair(R.drawable.baseline_access_alarm_24, R.string.time_alarm),
        Pair(R.drawable.outline_contact_page_24, R.string.contact),
        Pair(R.drawable.baseline_wifi_24, R.string.wifi_setting),
        Pair(R.drawable.baseline_apps_24, R.string.application)
    )

//    val whatsappItems = listOf(
//        R.string.setup_name_and_icon,
//        R.string.send_message,
//        R.string.create_and_quit_group,
//        R.string.story_and_whatsapp_dialing
//    )

    enum class WhatsappItems(@StringRes val title: Int) {
        Setup(title = R.string.setup_name_and_icon),
        Send(title = R.string.send_message),
        Create(title = R.string.create_and_quit_group),
        Story(title = R.string.story_and_whatsapp_dialing)
    }

}