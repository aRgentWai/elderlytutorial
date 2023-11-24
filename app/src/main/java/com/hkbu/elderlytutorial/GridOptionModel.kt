package com.hkbu.elderlytutorial

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//data class GridOptionModel(
//    val imageRes: Int,
//    val stringRes: Int,
//    val key: String
//)

enum class GridOption(@StringRes val title: Int, @DrawableRes val image: Int) {
    Whatsapp(title = R.string.whatsapp, image = R.drawable.baseline_whatsapp_24),
    Calendar(title = R.string.calendar, image = R.drawable.baseline_calendar_month_24),
    Alarm(title = R.string.create_and_quit_group, image = R.drawable.baseline_access_alarm_24),
    Contact(title = R.string.story_and_whatsapp_dialing, image = R.drawable.outline_contact_page_24),
    WIFI(title = R.string.wifi_setting, image = R.drawable.baseline_wifi_24),
    Application(title = R.string.application, image = R.drawable.baseline_apps_24)

}


