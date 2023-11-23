/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hkbu.elderlytutorial.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hkbu.elderlytutorial.R

@Composable
fun WhatsappScreen(
    options: List<Int>,
//    onWhatsappItemClicked: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    // TODO TopAppBar

    Column(
        modifier = modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        options.forEach { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        BorderStroke(4.dp, Color(0xFF444444)),
                        RoundedCornerShape(4.dp)
                    ),
            ) {
                Text(
                    text = LocalContext.current.resources.getString(item),
                    modifier = Modifier
                        .padding(0.dp, 8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

        }

    }

}

@Composable
fun VideoButton() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.setup_name_and_icon))
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.send_message))
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.create_and_quit_group))
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.story_and_whatsapp_dialing))
        }
    }
}

@Preview
@Composable
fun WhatsappPreview() {
    WhatsappScreen(
        options = DataSource.WhatsappItems.values().map { it.title },
        modifier = Modifier.fillMaxHeight()
    )
}
