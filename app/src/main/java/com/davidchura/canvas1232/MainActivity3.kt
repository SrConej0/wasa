package com.davidchura.canvas1232

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.davidchura.canvas1232.ui.theme.Canvas1232Theme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DibujarCanvasTap2()
        }
    }
}

@Composable
fun DibujarCanvasTap2() {
    var circleCenters by remember { mutableStateOf (listOf<Offset>()) }
    Canvas(modifier = Modifier.fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures {
                circleCenters = circleCenters + it
            }
        }
    ) {

        for (circleCenter in circleCenters) {
            drawCircle(
                color = Color.Blue,
                radius = 100f,
                center = circleCenter)
        }
    }
}