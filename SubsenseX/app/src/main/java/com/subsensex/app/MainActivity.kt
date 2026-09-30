package com.subsensex.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SubsenseXApp() }
    }
}

@Composable
private fun SubsenseXApp() {
    var danger by remember { mutableStateOf(false) }
    var tick by remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) { delay(1000); tick++ }
    }
    val displacement = if (danger) 12.4 + abs(Random.nextDouble(-2.0, 3.0)) else 0.6 + abs(Random.nextDouble(-0.3, 0.3))
    val risk = if (danger) 82 else 8

    MaterialTheme {
        Column(
            Modifier.fillMaxSize().background(Color(0xFFF4F5F7))
                .verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text("SUBSENSE-X", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Text("Offline Smart Mining Safety App", color = Color.DarkGray)
                }
                Text("🔴 OFFLINE", fontWeight = FontWeight.Bold)
            }
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("GROUND RISK", fontWeight = FontWeight.Bold)
                    Text(if (danger) "HIGH" else "STABLE", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                        color = if (danger) Color(0xFFD32F2F) else Color(0xFF2E7D32))
                    Text("Risk score: $risk / 100")
                    Text("All processing is local — no Internet required.")
                }
            }
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Text("Sensor Grid", fontWeight = FontWeight.Bold)
                    repeat(5) { row ->
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                            repeat(5) { col ->
                                val active = danger && (row == 1 || row == 2) && (col in 1..3)
                                Box(Modifier.weight(1f).aspectRatio(1f)
                                    .background(if (active) Color(0xFFD32F2F) else Color(0xFF43A047)))
                            }
                        }
                    }
                    Text("25 local nodes • Tick $tick • displacement %.1f mm".format(displacement), fontSize = 12.sp)
                }
            }
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Demo Scenarios", fontWeight = FontWeight.Bold)
                    Button(onClick = { danger = false }, Modifier.fillMaxWidth()) { Text("NORMAL / SAFE") }
                    Button(onClick = { danger = true }, Modifier.fillMaxWidth()) { Text("SIMULATE DANGER") }
                }
            }
            if (danger) {
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE5E5)), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("⚠ LOCAL SAFETY ALERT", color = Color(0xFFD32F2F), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("Correlated deformation detected across multiple nodes.")
                        Text("Action: field verification and mine safety protocol.")
                    }
                }
            }
            Text("Prototype only. Simulated data; thresholds require field calibration. Not certified safety equipment.",
                fontSize = 11.sp, color = Color.DarkGray)
        }
    }
}
