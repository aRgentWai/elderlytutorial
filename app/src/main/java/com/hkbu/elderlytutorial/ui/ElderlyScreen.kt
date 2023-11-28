package com.hkbu.elderlytutorial.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hkbu.elderlytutorial.R

enum class ElderlyScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Whatsapp(title = R.string.whatsapp_title),
    Video(title = R.string.title_activity_video_screen),
    Calendar(title = R.string.calendar_title),
    Alarm(title = R.string.alarm_title),
    Contact(title = R.string.contact_title),
    WIFI(title = R.string.wifi_title),
    Application(title = R.string.application_title),
}