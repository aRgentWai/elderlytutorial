package com.hkbu.elderlytutorial.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.hkbu.elderlytutorial.R

object DataSource {

    val gridOptions = listOf(
        GridOption.Whatsapp,
        GridOption.Calendar,
        GridOption.Alarm,
        GridOption.Contact,
        GridOption.WIFI,
        GridOption.Application
    )

    enum class GridOption(@StringRes val title: Int, @DrawableRes val image: Int) {
        Whatsapp(title = R.string.whatsapp, image = R.drawable.baseline_whatsapp_24),
        Calendar(title = R.string.calendar, image = R.drawable.baseline_calendar_month_24),
        Alarm(title = R.string.create_and_quit_group, image = R.drawable.baseline_access_alarm_24),
        Contact(title = R.string.story_and_whatsapp_dialing, image = R.drawable.outline_contact_page_24),
        WIFI(title = R.string.wifi_setting, image = R.drawable.baseline_wifi_24),
        Application(title = R.string.application, image = R.drawable.baseline_apps_24)
    }

    enum class WhatsappItems(@StringRes val title: Int) {
        Setup(title = R.string.setup_name_and_icon),
        Send(title = R.string.send_message),
        Create(title = R.string.create_and_quit_group),
        Story(title = R.string.story_and_whatsapp_dialing)
    }

}