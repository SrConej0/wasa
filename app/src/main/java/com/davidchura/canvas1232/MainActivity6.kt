package com.davidchura.canvas1232

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.util.fastForEachIndexed

class MainActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        var labels = listOf("Lima","Santiago","Bogota","Quito")
            var data = listOf(10f,60f,20f,40f,80f)
            DibujarGrafico(labels, data)
        }
    }
}

@Composable
fun DibujarGrafico(labels: List<String>, data: List<Float>) {
    Canvas (modifier = Modifier.fillMaxSize()) {
        var barWidth = size.width / (data.size * 2)
        data.fastForEachIndexed{index,value ->
            drawRect(
                color = Color.Yellow,
                topLeft = Offset(barWidth * index *2,100f),
                size = Size(barWidth,value*100)
            )

         }
    }
}