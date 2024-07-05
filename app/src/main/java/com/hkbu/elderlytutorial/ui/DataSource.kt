package com.hkbu.elderlytutorial.ui

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.hkbu.elderlytutorial.R

object DataSource {

    val gridOptions = listOf(
        GridOption.Whatsapp,
        GridOption.Calendar,
        GridOption.Alarm,
        GridOption.Contact,
        GridOption.Wifi,
        GridOption.Apps
    )

    enum class GridOption(@StringRes val title: Int, @DrawableRes val image: Int) {
        Whatsapp(title = R.string.whatsapp, image = R.drawable.baseline_whatsapp_24),
        Calendar(title = R.string.calendar, image = R.drawable.baseline_calendar_month_24),
        Alarm(title = R.string.time_alarm, image = R.drawable.baseline_access_alarm_24),
        Contact(title = R.string.story_and_whatsapp_dialing, image = R.drawable.baseline_groups_24),
        Wifi(title = R.string.wifi_setting, image = R.drawable.baseline_wifi_24),
        Apps(title = R.string.application, image = R.drawable.baseline_apps_24)
    }

    enum class WhatsappItems(@StringRes val title: Int, @RawRes val resourceId: Int) {
        Setup(title = R.string.setup_name_and_icon, resourceId = R.raw.whatsapp_setup_icon_and_name),
        SendText(title = R.string.send_message_text, resourceId = R.raw.whatsapp_send_message_text),
        SendVoice(title = R.string.send_message_voice,  resourceId = R.raw.whatsapp_send_message_voice),
        Dial(title = R.string.voice_dial, resourceId = R.raw.whatsapp_voice_dial),
        Photo(title = R.string.release_photo,  resourceId = R.raw.whatsapp_release_photo)
    }

    enum class CalendarItems(@StringRes val title: Int) {
        NewCalendar(title = R.string.new_calendar),
        EditAndDelete(title = R.string.edit_and_delete_calendar),
    }

    enum class AlarmItems(@StringRes val title: Int) {
        NewAlarm(title = R.string.new_alarm),
        TimerSetup(title = R.string.timer_setup),
    }

    enum class ContactItems(@StringRes val title: Int) {
        NewGroup(title = R.string.new_group),
        NewMember(title = R.string.new_group_member),
        QuitGroup(title = R.string.quit_group),
        Contact(title = R.string.contact),
        ModifyContact(title = R.string.modify_and_delete_contact)
    }

    enum class AppsItems(@StringRes val title: Int) {
        New(title = R.string.download_applications),
        Update(title = R.string.update_and_delete_installation_update),
        Uninstall(title = R.string.update_and_delete_installation_uninstall),
    }

    enum class WifiItems(@StringRes val title: Int) {
        Setup(title = R.string.setup_wifi_connection),
        TurnOnOrOff(title = R.string.turn_on_and_off_wifi),
    }

}