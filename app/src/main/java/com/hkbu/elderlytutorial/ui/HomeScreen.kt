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

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hkbu.elderlytutorial.R

@Composable
fun HomeScreen(
    gridOptions: List<DataSource.GridOption>,
    onGridItemClick: (String) -> Unit,
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Title()
            TabButton(navController)
            GridView(gridOptions, onGridItemClick, modifier = modifier)
        }
        FabButton()
    }
}

@Composable
fun TabButton(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Button(
                onClick = {
                    navController.navigate("Forum")
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue),
                    contentColor = Color.White,
                ), contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = stringResource(R.string.comments))
            }
//            Button(
//                onClick = {
//                    //TODO navigate to ForumScreen/ AIMessagingScreen
//                },
//                modifier = Modifier
//                    .padding(8.dp)
//                    .fillMaxWidth()
//                    .weight(1f),
//                shape = RoundedCornerShape(4.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = colorResource(id = R.color.blue),
//                    contentColor = Color.White,
//                ), contentPadding = PaddingValues(0.dp)
//            ) {
//                Text(text = stringResource(R.string.aiMessaging))
//            }
        }

    }
}

// GridView button
@Composable
fun Title() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(300.dp, 90.dp)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                Text(
                    text = stringResource(R.string.welcome),
                    color = Color(0xFF999999),
                    modifier = Modifier.padding(16.dp, 0.dp)
                )
                Text(
                    text = stringResource(R.string.application_learning_centre),
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(16.dp, 0.dp)
                )
            }
        }
//        Box(
//            modifier = Modifier
//                .size(90.dp)
//                .padding(end = 8.dp),
//            contentAlignment = Alignment.Center,
//        ) {
//            ImageButton(
//                onClick = {
//                    //TODO
//                },
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(shape = RectangleShape)
//                    .border(
//                        // to be transparent
//                        BorderStroke(2.dp, Color(0xFF999999)),
//                        RoundedCornerShape(10.dp)
//                    ),
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(5.dp)
//                )
//            }
//        }
    }
}

@Composable
fun GridView(
    listOfItems: List<DataSource.GridOption>,
    onItemClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
    ) {
        Column {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(listOfItems) { item ->
                    GridItem(
                        imageRes = item.image,
                        textRes = item.title,
                        onClick = { onItemClicked(item.name) }
                    )
                }
            }
        }
    }
}

@Composable
fun FabButton(
//    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxWidth()
    ) {
        FloatingActionButton(
            onClick = {
//                onClick()
            },
            shape = CircleShape,
            containerColor = colorResource(id = R.color.blue),
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = stringResource(R.string.favorite),
                tint = Color.White,
            )
        }
    }
}

@Composable
fun GridItem(imageRes: Int, textRes: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier.border(
                // TODO
                BorderStroke(4.dp, Color(0xFF444444)),
                RoundedCornerShape(4.dp)
            )
        )
        ImageButton(
            onClick = { onClick() },
            modifier = Modifier.size(120.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = LocalContext.current.resources.getString(textRes),
            modifier = Modifier.padding(0.dp, 8.dp)
        )

    }
}

@Composable
fun ImageButton(
    onClick: () ->
    Unit, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent
        ), contentPadding = PaddingValues(0.dp), modifier = modifier
    ) {
        content()
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen(
        gridOptions = DataSource.gridOptions,
        onGridItemClick = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium))
    )
}
