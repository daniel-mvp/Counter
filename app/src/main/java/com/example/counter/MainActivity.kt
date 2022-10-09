package com.example.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counter.databinding.ActivityMainBinding
import com.example.counter09.view.UpdateCount

class MainActivity : AppCompatActivity(), UpdateCount {

    private lateinit var binding : ActivityMainBinding
    private val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter.attachView(this)
        setContentView(binding.root)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnIncrement.setOnClickListener {
                presenter.increment(applicationContext)
                if (presenter.changeCounterColor()) {
                    tvCounter.setTextColor(Color.parseColor("#FF16FF00"))
                }
            }
            btnDecrement.setOnClickListener {
                presenter.decrement(applicationContext)
            }
        }
    }

    override fun updateCount(count: String) {
        binding.tvCounter.text = count
    }
}