package com.example.path2theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.path2theme.ui.theme.Path2ThemeTheme
import com.example.path2theme.ui.theme.Purple40
import com.example.path2theme.ui.theme.Purple80
import com.example.path2theme.ui.theme.PurpleGrey40
import com.example.path2theme.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Path2ThemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Draw()
                }
            }
        }
    }
}

@Composable
fun Draw(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        rotate(23f) {
            drawRect(
                color = Color.Blue,
                alpha = 0.5f,
//        radius = 80.dp.toPx(),
//        center = Offset(
//            x = 200f,
//            y = 400f
//        )

            )
        }
    }
}

@Composable
fun Graph(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Canvas(
            modifier = modifier
                .aspectRatio(3f / 2f)
                .padding(18.dp)
        ) {
            val barWidthPx = 1.dp.toPx()
            drawRect(color = Color.White, style = Stroke(barWidthPx))

            val verticalLines = 4
            val verticalSize = size.width / (verticalLines + 1)
            repeat(verticalLines) { i ->
                val staX = verticalSize * (i + 1)
                drawLine(
                    Color.White,
                    start = Offset(staX, 0f),
                    end = Offset(staX, size.height),
                    strokeWidth = barWidthPx

                )
            }

            val horizontal

        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Path2ThemeTheme {
        Graph()
    }
}