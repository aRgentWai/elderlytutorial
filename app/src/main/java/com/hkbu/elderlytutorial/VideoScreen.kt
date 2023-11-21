package com.hkbu.elderlytutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.analytics.AnalyticsListener
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

class VideoScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElderlyTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SetupVideoPlayer()
                }
            }
        }
    }
}

@Composable
fun SetupVideoPlayer() {
    VideoPlayer(
        mediaItems = listOf(
            VideoPlayerMediaItem.RawResourceMediaItem(
                resourceId = R.raw.sending_message_v1,
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



