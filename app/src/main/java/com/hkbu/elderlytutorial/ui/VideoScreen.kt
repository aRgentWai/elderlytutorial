package com.hkbu.elderlytutorial.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.analytics.AnalyticsListener
import com.hkbu.elderlytutorial.R
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoScreen(
//    videoItem: Int
) {

    // TODO VideoPlayer
    SetupVideoPlayer()

}


@Composable
fun SetupVideoPlayer() {
    VideoPlayer(
        mediaItems = listOf(
            VideoPlayerMediaItem.RawResourceMediaItem(
                resourceId = R.raw.sending_message_v1_1080p,
            ),
//            VideoPlayerMediaItem.AssetFileMediaItem(
//                assetPath = "videos/test.mp4"
//            ),
//            VideoPlayerMediaItem.StorageMediaItem(
//                storageUri = "content://xxxxx"
//            ),
//            VideoPlayerMediaItem.NetworkMediaItem(
//                url = "https://storage.googleapis.com/wvmedia/cbcs/h264/tears/tears_aes_cbcs.mpd",
//                mediaMetadata = MediaMetadata.Builder().setTitle("Widevine DASH cbcs: Tears")
//                    .build(),
//                mimeType = MimeTypes.APPLICATION_MPD,
//                drmConfiguration = MediaItem.DrmConfiguration.Builder(C.WIDEVINE_UUID)
//                    .setLicenseUri("https://proxy.uat.widevine.com/proxy?provider=widevine_test")
//                    .build(),
//            )
        ),
        handleLifecycle = true,
        autoPlay = true,
        usePlayerController = true,
        enablePip = true,
        handleAudioFocus = true,
        controllerConfig = VideoPlayerControllerConfig(
            showSpeedAndPitchOverlay = false,
            showSubtitleButton = false,
            showCurrentTimeAndTotalTime = true,
            showBufferingProgress = false,
            showForwardIncrementButton = true,
            showBackwardIncrementButton = true,
            showBackTrackButton = true,
            showNextTrackButton = true,
            showRepeatModeButton = true,
            controllerShowTimeMilliSeconds = 5_000,
            showFullScreenButton = true,
            controllerAutoShow = true,
        ),
        volume = 0.5f,  // volume 0.0f to 1.0f
        repeatMode = RepeatMode.NONE,       // or RepeatMode.ALL, RepeatMode.ONE
        onCurrentTimeChanged = { // long type, current player time (millisec)
            Log.e("CurrentTime", it.toString())
        },
        playerInstance = { // ExoPlayer instance (Experimental)
            addAnalyticsListener(object : AnalyticsListener {
                // player logger
            })
        },
        modifier = Modifier
            .fillMaxSize()
    )
}

@Preview
@Composable
fun VideoPreview() {
    VideoScreen()
}



