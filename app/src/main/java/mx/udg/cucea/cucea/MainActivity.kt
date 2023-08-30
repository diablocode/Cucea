package mx.udg.cucea.cucea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.udg.cucea.cucea.ui.theme.CuceaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Jetpack compose
            CuceaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var numero1 by remember {mutableStateOf("")}
    var numero2 by remember { mutableStateOf("")}
    var resultado by remember { mutableStateOf(0.0) }
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = numero1,
            onValueChange = {numero1 = it},
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        BasicTextField(
            value = numero2,
            onValueChange ={numero2 = it},
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = {
                resultado = numero1.toDouble() + numero2.toDouble()
            }
        ) {
            Text("Sumar")
        }
        Text(
            text = "Resultado: $resultado",
            modifier = modifier
        )
    }
}

@Preview()
@Composable
fun GreetingPreview() {
    CuceaTheme {
        Greeting("Android")
    }
}