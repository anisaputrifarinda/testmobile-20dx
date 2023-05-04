package com.uti.pjetpack20dx

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uti.pjetpack20dx.ui.theme.PJetpack20DXTheme

class IOActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PJetpack20DXTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    buat variabel untuk object
                    var txt_nilai1 by remember {
                        mutableStateOf("")
                    }
                    var txt_nilai2 by remember {
                        mutableStateOf("")
                    }

//                    buat variabel untuk batas input karatter
                    val limit =5

//                    buat column
                    Column(modifier = Modifier.padding(10.dp)) {
//                    buat input 1
                        OutlinedTextField(label = {
                            Text(text = "Isi Nilai 1")
                        },value = txt_nilai1, onValueChange = {

//                            jika batas karakter <=5
                            if(it.length<=limit)
                            {
                                txt_nilai1 = it
                            }

                        }, modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            ,colors = TextFieldDefaults.textFieldColors
                                (focusedIndicatorColor = Color.Red,
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color.Blue,
                                cursorColor = colorResource(id = R.color.color_label)))

                        Spacer(modifier = Modifier.padding(10.dp))

                        OutlinedTextField(label = {
                            Text(text = "Isi Nilai 2")
                        },value = txt_nilai2, onValueChange = {

//                            jika batas karakter <=5
                            if(it.length<=limit)
                            {
                                txt_nilai2 = it
                            }

                        }, modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            ,colors = TextFieldDefaults.textFieldColors
                                (focusedIndicatorColor = Color.Red,
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color.Blue,
                                cursorColor = colorResource(id = R.color.color_label)))

                        Spacer(modifier = Modifier.padding(10.dp))

                        val context = LocalContext.current
                        val operator =
                            arrayOf(
                                "Pilih Operasi",
                                "Tambah (+)",
                                "Kurang (-)",
                                "Kali (x)",
                                "Bagi (/)"
                            )
                        var expanded by remember { mutableStateOf(false) }
                        var selectedText by remember { mutableStateOf(operator[0]) }


                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {
                            OutlinedTextField(
                                value = selectedText,
                                onValueChange = {},
                                readOnly = true,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(
                                        expanded = expanded
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Black,
                                    focusedIndicatorColor = Color.Red,
                                    unfocusedIndicatorColor = Color.Black
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                operator.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            selectedText = item
                                            expanded = false

                                            if(selectedText == operator[0]) {
                                                Toast.makeText(
                                                    context,
                                                    "Jenis Operasi Belum Dipilih !",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    )

                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(5.dp))


                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PJetpack20DXTheme {
//        Greeting2("Android")
    }
}