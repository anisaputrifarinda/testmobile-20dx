package com.uti.pjetpack20dx

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uti.pjetpack20dx.ui.theme.PJetpack20DXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PJetpack20DXTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                //    Greeting("Android")

                //    Text(text = "Saya Belajar Jetpack Compose")

                //    Button(onClick = { /*TODO*/ }) {
                //        Text(text = "Tambah")
                 //   }
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                        .padding(all = 10.dp)) {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray)
                            .padding(all = 10.dp)) {
                            Greeting("Android")
                        }
                        Spacer(modifier = Modifier.padding(10.dp))

                       Column(modifier = Modifier
                           .fillMaxWidth()
                           .background(Color.Magenta)
                           .padding(all = 10.dp)) {
                           Text(text = "Saya Belajar Jetpack Compose")
                       }
                        Spacer(modifier = Modifier.padding(10.dp))

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)
                            .padding(all = 10.dp)) {
                            Text(text = "Saya Belajar Jetpack Compose Lagi")
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(10.dp)){

                            //buat variable
                            // var untuk data yang bersifat muttable
                            // val untuk data imutable (konstan)
                            var x = "10"
                            var y = "3"
                            var z = x.toFloat() / y.toInt()

                            //buat variabel context
                            val context = LocalContext.current

                            Button(modifier = Modifier
                                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray, contentColor = Color.Red),onClick = {

                                Toast.makeText(context,"Hasil Penjumlahan = "+z.toString(),Toast.LENGTH_LONG).show()
                            })
                            {


                                Text(text = "Proses")
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PJetpack20DXTheme {
        Greeting("Android")
    }
}