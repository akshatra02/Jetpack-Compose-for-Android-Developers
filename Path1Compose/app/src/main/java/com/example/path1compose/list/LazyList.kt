package com.example.path1.list

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.path1compose.ui.theme.Path1ComposeTheme


@Composable
fun ItemsApp(modifier: Modifier = Modifier) {
    var onContinue by rememberSaveable {
        mutableStateOf(true)
    }
    Surface(
        modifier = modifier
    ) {
        if (onContinue) {
            OnBoardingScreen(onContinueClicked = { onContinue = false })
        } else {
            Greetings()
        }
    }
}

@Composable
fun Greetings(name: List<String> = List(100){"$it"}, modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = name){item ->
            Greeting(item,modifier)
        }
    }
}

@Composable
fun Greeting(name : String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 20.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier.padding(16.dp),
        ) {

            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                    .weight(1f)
            ) {
                Text(
                    text = "Hello!",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = " $name!",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded){
                    Text(text = "Composem ipsum".repeat(9))
                }
            }
            IconButton(onClick = {expanded = !expanded }) {
                Icon(imageVector =if (expanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown, contentDescription = "")

            }
        }
    }
}

@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Welcome")
        Button(
            modifier = Modifier.padding(vertical = 23.dp),
            onClick = onContinueClicked
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Path1ComposeTheme {
        Greetings()
    }
}