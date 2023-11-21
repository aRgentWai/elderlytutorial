package com.hkbu.elderlytutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun OverviewScreen(navController: NavHostController) {
    HomeScreen(navController)
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
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(4.dp),
            ) {
                Text(text = "留言區")
            }
            Button(
                onClick = { navController.navigate("Whatsapp") },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(4.dp),
            ) {
                Text(text = "AI對話")
            }
        }

    }
}

// GridView button
@Composable
fun Title() {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                Text(
                    text = "歡迎光臨",
                    color = Color(0xFF999999),
                    modifier = Modifier.padding(16.dp, 0.dp)
                )
                Text(
                    text = "應用程式學習中心",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(16.dp, 0.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            ImageButton(
                onClick = {
                    //TODO
                },
                modifier = Modifier.size(60.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            // to be transparent
                            BorderStroke(0.dp, Color(0xFF999999)),
                            RoundedCornerShape(4.dp)
                        )
                )
            }
        }
    }
}

@Composable
fun GridView() {
    val images = listOf(
        R.drawable.baseline_whatsapp_24,
        R.drawable.baseline_calendar_month_24,
        R.drawable.baseline_access_alarm_24,
        R.drawable.outline_contact_page_24,
        R.drawable.baseline_wifi_24,
        R.drawable.baseline_apps_24,
//        Icons.Default.Phone,
    )

    val strings = listOf("Whatsapp", "日曆", "時鐘鬧鐘", "通訊錄", "WIFI設定", "應用程式")

    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
    ) {
        Column {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(images) { image ->
                    GridItem(image, strings[images.indexOf(image)], onClick = {
                        //TODO
                    })
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
            containerColor = Color(0xFF3D3F41),
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Favorite",
                tint = Color.White,
            )
        }
    }
}

@Composable
fun GridItem(imageRes: Int, text: String, onClick: () -> Unit) {
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
            onClick = {
                onClick()
//                navController.navigate("Whatsapp")
            },
            modifier = Modifier.size(120.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(text = text, modifier = Modifier.padding(0.dp, 8.dp))

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

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Title()
            TabButton(navController)
            GridView()
        }
        FabButton()
    }
}