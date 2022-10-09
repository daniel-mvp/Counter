package com.example.counter09.presenter

import android.content.Context
import com.example.counter.Injector
import com.example.counter09.view.UpdateCount

class Presenter {
    private val model = Injector.getCounterModel()
    lateinit var view: UpdateCount

    fun increment(context: Context) {
        model.increment()
        view.updateCount(model.getCount().toString())
        model.countToast(context)
    }

    fun decrement(context: Context) {
        model.decrement()
        view.updateCount(model.getCount().toString())
        model.countToast(context)
    }

    fun changeCounterColor(): Boolean {
        return model.changeCountText()
    }

    fun attachView(view: UpdateCount) {
        this.view = view
    }
}