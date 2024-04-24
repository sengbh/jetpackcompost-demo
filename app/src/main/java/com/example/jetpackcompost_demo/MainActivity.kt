package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun CounterApp(){
    var count by remember { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().background(Color.LightGray)
    ) {
        Text("The current count is $count")
        Row(modifier = Modifier.padding(8.dp)){
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

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().background(Color.Gray)) {
        TextField(
            value = textField,
            onValueChange = {textField = it},
            label = { Text("Enter something here") },
            placeholder = { Text("Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
//                    LocalFocusManager.current.moveFocus(FocusDirection.Down)
//                    LocalSoftwareKeyboardController.current?.hide()
                }
            )
        )

        Button(onClick = {}){
            Text("Click Me")
        }
        Text(
            "Welcome To Jetpack Compose!",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainLayout(){
    val navigationController = rememberNavController()
    val selectTab by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {TopBarLayout()},
        bottomBar = {BottomBarLayout()},
//        content = {
//           Box(
//               modifier = Modifier.fillMaxSize().padding(16.dp),
//               contentAlignment = Alignment.Center
//           ){
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CounterApp()
//                UILayout()
//            }
//           }
//        }
    ){
        NavHost(
            navigationController,
            "home",
            modifier = Modifier.padding(it)
        ){
            composable(route = "home"){
                when (selectTab) {
                    0 -> Tab1()
                    1 -> Tab2()
                    else -> {}
                }
            }
        }
    }
}

@Composable
fun Tab1(){
Column {
    Text("TEST 1")
}
}

@Composable
fun Tab2(){
Column {
    Text("TEST 2")
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLayout(){
    TopAppBar(
        title = { Text("Top App Bar") },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Person, null)
            }
        },
        actions = {
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.Menu, null)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BottomBarLayout(){
    BottomAppBar(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
    ){
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ){
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterStart)) {
                Icon(imageVector = Icons.Default.Home, null)
            }
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.Center)) {
                Icon(imageVector = Icons.Default.Add, null)
            }
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(imageVector = Icons.Default.Call, null)
            }
        }
    }
}