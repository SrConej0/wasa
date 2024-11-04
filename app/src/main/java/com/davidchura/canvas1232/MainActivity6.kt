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
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed

class MainActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        var labels = listOf("Lima","Santiago","Bogota","Quito")
            var data = listOf(10f,50f,20f,40f,30f,4f,24f)
            DibujarGrafico(labels, data)
        }
    }
}

@Composable
fun DibujarGrafico(labels: List<String>, data: List<Float>) {
    var maxValue = data.max()
    Canvas (modifier = Modifier.fillMaxSize()) {
      var barWidth = size.width / (data.size * 2)

        data.fastForEachIndexed{index,value ->
            var barHeinght = value/ maxValue * size.height
            drawRect(
                color = Color.Yellow,
                topLeft = Offset(barWidth * index *2 + barWidth/2,size.height - barHeinght),
                size = Size(barWidth,barHeinght)
            )

        drawIntoCanvas { canvas ->
            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                textSize = 16.sp.toPx()
                color =android.graphics.Color.BLACK
                textAlign = android.graphics.Paint.Align.CENTER
            }
            canvas.nativeCanvas.drawText(
                labels[index],
                index * barWidth * 2 + barWidth,
                        size.height - 60f,
                        textPaint
                        )
             }
        }
    }
}