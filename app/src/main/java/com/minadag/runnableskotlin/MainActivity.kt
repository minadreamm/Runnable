package com.minadag.runnableskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.minadag.runnableskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var number = 0
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun start (view : View) {
        number = 0

        runnable = object : Runnable {
            override fun run() {
                number = number +1
                binding.textView.text = "TIME: ${number}"

                handler.postDelayed(this,1000) // this -> runnable
            }

        }

        handler.post(runnable)
        binding.button.isEnabled = false // don't again stop

    }

    fun stop (view: View) {

        binding.button.isEnabled = true // again stop
        number = 0
        binding.textView.text = "TIME : 0"
        handler.removeCallbacks(runnable)


    }
}