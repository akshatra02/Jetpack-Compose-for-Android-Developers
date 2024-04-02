package com.example.path1compose.wellnessApp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    onCheckChange: (Boolean) -> Unit
){
    var check by rememberSaveable {
        mutableStateOf(false)
    }
    WellnessTaskItems(
        taskName=taskName,
        checked = check,
        onCheckChange = onCheckChange,
        onClose = onClose,
        modifier
    )
}

@Composable
fun WellnessTaskItems(
    taskName: String,
    checked: Boolean,
    onCheckChange:(Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(checked = checked, onCheckedChange=  onCheckChange )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask:(WellnessTask) -> Unit,
    onCheckChange: (WellnessTask,Boolean) -> Unit
){
    LazyColumn(modifier=modifier) {
        items(items = list, key = {task -> task.id}){item ->
            WellnessTaskItem(taskName = item.label, onClose = {onCloseTask(item)},
                onCheckChange = {checked -> onCheckChange(item,checked)})
        }
    }

}

class WellnessTask(
    val id: Int,
    val label:String,
    initialCheck: Boolean=false)
{
    var checkedStatus by mutableStateOf(initialCheck)
}

