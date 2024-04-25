package com.example.jetpackcompost_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.jetpackcompost_demo.ui.theme.JetpackcompostdemoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcompostdemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().background(Color.LightGray)
    ) {
        Text("The current count is $count")
        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = { count++ }) {
                Text("Add")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { count-- }) {
                Text("Subtract")
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UILayout() {
    var textField by remember { mutableStateOf("") }
    var saveText by remember { mutableStateOf<String?>(null) }
    val focusManager = LocalFocusManager.current
    val localKeyBoard = LocalSoftwareKeyboardController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().background(Color.Gray)
    ) {
        TextField(
            value = textField,
            onValueChange = { textField = it },
            label = { Text("Enter something here") },
            placeholder = { Text("Write something") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                    localKeyBoard?.hide()
                }
            )
        )

        Button(onClick = {saveText = textField}) {
            Text("Click Me")
        }
        saveText?.let {
            Text("Save text: $it")
        }
        Text(
            "Welcome To Jetpack Compose!",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun Tab1(navController: Unit) {
    Column {
        Text("TEST 1")
    }
}

@Composable
fun Tab2() {
    Column {
        Text("TEST 2")
    }
}


