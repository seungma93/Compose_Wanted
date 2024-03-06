package com.seungma.wtdcomposehandson

import android.icu.text.CaseMap
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seungma.wtdcomposehandson.ui.theme.WtdComposeHandsOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WtdScreen()
        }
    }

    @Composable
    fun WtdScreen() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Title()
            Behavior()
            List()
        }
    }

    @Composable
    fun Title() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xff997EE8))
                .padding(top = 13.dp, bottom = 12.dp, start = 67.dp, end = 67.dp)

        ) {
            Text(text = "Wanted Challenge", fontSize = 28.sp, textAlign = TextAlign.End)
        }
    }

    @Composable
    fun Behavior() {
        Row {
            BehaviorItem(text = "추가", backgroundColor = Color(0xFFD9D9D9))
            BehaviorItem(text = "삭제", backgroundColor = Color(0xFF944B4B))
            BehaviorItem(text = "초기화", backgroundColor = Color(0xFF84D59F))
        }
    }

    @Composable
    fun BehaviorItem(text: String, backgroundColor: Color) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .background(backgroundColor)
        ) {
            Text(text = text, fontSize = 28.sp)
        }
    }

    @Composable
    fun List() {
        val count by remember { mutableStateOf(10) }
            val itemList = (1..count).toList()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(itemList) { ListItem(it) }
            }
    }

    @Composable
    fun ListItem(no: Int) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Item #$no", fontSize = 28.sp)
        }
    }

    @Preview
    @Composable
    fun MyAppPreview() {
        WtdComposeHandsOnTheme {
            WtdScreen()
        }
    }

}

