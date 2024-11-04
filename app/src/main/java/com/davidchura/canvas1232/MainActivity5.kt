package com.davidchura.canvas1232

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import kotlin.math.sqrt

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DibujarCanvas2(this)
        }
    }
}
@Composable
fun DibujarCanvas2(context: Context) {
    var circleCenters by remember { mutableStateOf (listOf<Offset>()) }

    var sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    var mSensor = remember { sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) }
    var shakeMax = 30f
    val shakeListener = remember {
        object : SensorEventListener{
            override fun onSensorChanged(event: SensorEvent) {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                val magitude = sqrt(x*x+y*y+z*z)
                if(magitude > shakeMax){
                        circleCenters = listOf()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

        }
    }
    DisposableEffect(Unit) {
    sensorManager.registerListener(shakeListener,mSensor,SensorManager.SENSOR_DELAY_GAME)
        onDispose {
            sensorManager.unregisterListener(shakeListener)
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()
        .pointerInput(Unit) {
            detectDragGestures (
                onDragStart = {
                },
                onDrag = {
                        change, _ ->
                    circleCenters = circleCenters + change.position
                },
                onDragEnd = {
                }
            )
        }){
        for (circleCenter in circleCenters) {
            drawCircle(
                color = Color.Blue,
                radius = 10f,
                center = circleCenter)
        }
    }
}

