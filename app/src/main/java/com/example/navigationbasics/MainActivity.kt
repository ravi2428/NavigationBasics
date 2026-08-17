package com.example.navigationbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationbasics.ui.theme.Navigation
import com.example.navigationbasics.ui.theme.NavigationBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationBasicsTheme {
                Surface( modifier = Modifier.fillMaxSize() ) {
                    Navigation()
                }
            }
        }
    }
}


@Composable
fun Greeting(navController: NavController) {
    var name by rememberSaveable {mutableStateOf("")}
    var isError by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = name,
            onValueChange = {name = it},
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1
        )
        if(isError){
            Text(
                text = "Error! Text cannot  be empty",
                modifier = Modifier.padding(vertical = 8.dp)
                    .background(MaterialTheme.colorScheme.error ),
                color = MaterialTheme.colorScheme.onError,

            )
        }
        Spacer(
            modifier = Modifier.padding(vertical = 6.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                enabled = false
            ) {
                Text(
                    text = "Previous",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if(name.isBlank()) {
                        isError = true
                    }
                    else{
                        navController.navigate(Screen.SecondScreen.route + "/${name}")

                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

    }
}

@Composable
fun SecondScreen(
    navController: NavController,
    name : String
){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Hello $name",
                style = MaterialTheme.typography.displayMedium
                )
        }
        Spacer(
            modifier = Modifier.padding(vertical = 6.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),

            ) {
                Text(
                    text = "Previous",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                enabled = false
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationBasicsTheme {

    }
}
