package com.example.counter09.models

import android.content.Context
import android.widget.Toast

class CounterModel {
    private var count = 0

    fun increment() {
        ++count
    }

    fun decrement() {
        --count
    }

    fun getCount() : Int {
        return count
    }

    fun countToast(context: Context) {
        if (count == 10) {
            Toast.makeText(context, "Поздравляем", Toast.LENGTH_SHORT).show()
        }
    }

    fun changeCountText() : Boolean {
        return count == 15
    }
}