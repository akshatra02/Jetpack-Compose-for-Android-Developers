package com.example.path1compose.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier, wellnessViewModel: WellnessViewModel = viewModel() ) {
    Column {
        WaterCounter(modifier)

        WellnessTaskList(
            modifier = modifier,
            list = wellnessViewModel.task,
            onCloseTask = {task -> wellnessViewModel.remove(task) },
            onCheckChange = {task,checked ->
                wellnessViewModel.checkChange(task,checked)
            })
    }
}


@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    if (count > 0) {
        Text(
            text = "You have added $count glasses.",
            modifier = modifier.padding(16.dp)
        )
        Button(onClick = onIncrement, enabled = count < 10) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun StatefullCounter(modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(0)
    }
    StatelessCounter(count = count, onIncrement = { count++ })
}

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {
    var count by remember {
        mutableStateOf(0)
    }
    var showTask by remember {
        mutableStateOf(true)
    }
    if (showTask) {
//        WellnessTaskItem(
//            taskName = "Have you taken your 15 minute walk today?",
////            onClose = { showTask = false }
//        )
    }


    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text(
                text = "You have added $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }
        Row(Modifier.padding(top = 20.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = "Add one")
            }
            Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
                Text(text = "Clear water count")
            }

        }
    }
}