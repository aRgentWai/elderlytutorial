package com.hkbu.elderlytutorial.ui

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.Log

import androidx.annotation.RawRes

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player.REPEAT_MODE_OFF
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.analytics.AnalyticsListener
import androidx.media3.ui.AspectRatioFrameLayout
import com.hkbu.elderlytutorial.R
import com.hkbu.elderlytutorial.ui.elderly.ElderlyViewModel
import com.hkbu.elderlytutorial.ui.theme.ElderlyTutorialTheme
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.cache.VideoPlayerCacheManager
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoScreen(
    @RawRes videoResId: Int?
) {
    // TODO VideoPlayer
    val viewModel: ElderlyViewModel = viewModel()
    // Use the ViewModel using collectAsState to safely access the value
//    val myStateFlow: State<Int> by viewModel.uiStateFlow.collectAsState()

    // Access the value of myStateFlow within the composition
//    val video = myStateFlow.value
    SetupVideoPlayer(videoResId ?: R.raw.whatsapp_release_photo)

}


@Composable
fun SetupVideoPlayer(@RawRes videoItem: Int) {

//    @Composable
//    fun VideoLayout(@RawRes rawResource: Int) {
//        val context = LocalContext.current
//        val uri = RawResourceDataSource.buildRawResourceUri(rawResource)
//        val mediaItem = MediaItem.fromUri(uri)
//        val exoPlayer = remember(context, mediaItem) {
//            ExoPlayer.Builder(context).build().apply {
//                addMediaItem(mediaItem)
//                prepare()
//                play()
//                repeatMode = REPEAT_MODE_OFF
//            }
//        }
//
//        DisposableEffect(exoPlayer) { onDispose { exoPlayer.release() } }
//
//        AndroidView(
//            modifier = Modifier.fillMaxSize(),
//            factory = {
//                StyledPlayerView(it).apply {
//                    player = exoPlayer
//                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
//                    useController = false
//                }
//            }
//        )
//    }

//    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
    LocalConfiguration.current.orientation = Configuration.ORIENTATION_PORTRAIT

    VideoPlayer(
        mediaItems = listOf(
            VideoPlayerMediaItem.RawResourceMediaItem(
                resourceId = videoItem,
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
        enablePip = false,
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
        repeatMode = RepeatMode.ALL,       // or RepeatMode.ALL, RepeatMode.ONE
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
    VideoScreen(R.raw.whatsapp_release_photo)
}



