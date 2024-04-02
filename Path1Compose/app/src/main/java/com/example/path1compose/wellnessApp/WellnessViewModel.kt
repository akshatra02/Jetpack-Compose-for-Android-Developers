package com.example.path1compose.wellnessApp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class WellnessViewModel : ViewModel() {
    private val _task = getWellnessTask().toMutableStateList()

    val task :List<WellnessTask>
        get() = _task
    fun remove(item: WellnessTask){
        _task.remove(item)
    }

    fun checkChange(item: WellnessTask, checked: Boolean){
        _task.find { it.id == item.id } ?. let {
            item.checkedStatus = checked
        }
    }

}

fun getWellnessTask() = List(30) { i -> WellnessTask(i, "Task $i") }
