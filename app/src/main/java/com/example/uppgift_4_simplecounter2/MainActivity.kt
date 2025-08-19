package com.example.uppgift_4_simplecounter2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uppgift_4_simplecounter2.ui.theme.Uppgift4SimpleCounter2Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

val Green1 = Color(0xFF64C465)
val Red1 = Color(0xFFE94E3D)
val Blue1 = Color(0xFF58C4F5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Uppgift4SimpleCounter2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleCounter(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun SimpleCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue1),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(Blue1)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Green1)
                .padding(vertical = 16.dp)
        ){
            Text("UPPGIFT 1",
                fontSize = 50.sp,
                color= Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
       Spacer(modifier = Modifier.height(100.dp))

        Box(Modifier.height(60.dp)) {
            if (count < 10) {
                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Red1),
                    shape = RectangleShape,
                    modifier = Modifier
                        .width(150.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "PLUS", fontSize = 30.sp, color = Color.Black)
                }
            }
        }
            Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "$count",
            fontSize = 100.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Box(Modifier.height(60.dp)){
            if(count > 0) {
                Button(
                    onClick = { count-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Red1),
                    shape = RectangleShape,
                    modifier = Modifier
                        .width(150.dp)
                        .padding(vertical = 8.dp)
            ) {
                    Text("MINUS", fontSize = 30.sp, color = Color.Black)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SimpleCounterPreview() {
    Uppgift4SimpleCounter2Theme {
        SimpleCounter()
    }
}