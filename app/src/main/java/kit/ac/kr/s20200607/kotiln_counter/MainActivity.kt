package kit.ac.kr.s20200607.kotiln_counter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kit.ac.kr.s20200607.kotiln_counter.ui.theme.Kotiln_counterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Counter()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Kotiln_counterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var text by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            //.fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text.toString(),
            fontSize = 70.sp,
        )
        Row() {
            Button( modifier = Modifier.weight(1f),
                onClick = {
                    text++
                }) {
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.weight(0.5f))
            Button( modifier = Modifier.weight(1f),
                onClick = {
                    if (text > 0) text--
                }) {
                Text(text = "감소")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Kotiln_counterTheme {
        Counter()
    }
}