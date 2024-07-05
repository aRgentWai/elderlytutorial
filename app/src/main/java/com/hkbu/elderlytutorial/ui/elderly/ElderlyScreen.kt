package com.hkbu.elderlytutorial.ui.elderly

import androidx.annotation.StringRes
import com.hkbu.elderlytutorial.R

enum class ElderlyScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Whatsapp(title = R.string.whatsapp),
    Video(title = R.string.title_activity_video_screen),
    Calendar(title = R.string.calendar_title),
    Alarm(title = R.string.alarm_title),
    Contact(title = R.string.contact_title),
    Wifi(title = R.string.wifi_title),
    Apps(title = R.string.application_title),
    Forum(title = R.string.comments)
}