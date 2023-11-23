package com.hkbu.elderlytutorial.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hkbu.elderlytutorial.R

enum class ElderlyScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Whatsapp(title = R.string.whatsapp),
    Video(title = R.string.title_activity_video_screen)
}

@Composable
fun WhatsappAppBar(
    currentScreen: ElderlyScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {

//    TopAppBar(
//        title = { Text(stringResource(currentScreen.title)) },
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer
//        ),
//        modifier = modifier,
//        navigationIcon = {
//            if (canNavigateBack) {
//                IconButton(onClick = navigateUp) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = stringResource(R.string.back_button)
//                    )
//                }
//            }
//        }
//    )
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    TODO("Not yet implemented")
}