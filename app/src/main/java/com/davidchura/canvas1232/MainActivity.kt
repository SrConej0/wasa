package com.davidchura.canvas1232

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import com.davidchura.canvas1232.ui.theme.Canvas1232Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           Canvas(modifier = Modifier.fillMaxSize()){
               drawLine(
                   color = Color.Red,
                   strokeWidth = 50f,
                   start = Offset(0f,0f),
                   end = Offset(size.width,size.height),
               )
               drawLine(
                   color = Color.Green,
                   strokeWidth = 20f,
                   start = Offset(200f,600f),
                   end = Offset(500f,100f),
               )
               drawCircle(
                   color = Color.Blue,
                   radius = 200f,
                   center = Offset(500f,800f),
               )
           }
        }
    }
}
