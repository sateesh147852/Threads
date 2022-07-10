package com.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var thread: MyThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startThread()
        startRunnable()
        initUiComponents()
        startHandler()
    }

    private fun startHandler() {
        Handler(Looper.myLooper()!!).postDelayed(object : Runnable{

            override fun run() {
                Log.i("MainActivity", "Hanndler "+Thread.currentThread().name)
            }

        },3000)
    }

    private fun initUiComponents() {
        findViewById<TextView>(R.id.tvGet).setOnClickListener {
            Toast.makeText(this,DataSingleton.getInstance().getCounter().toString(),Toast.LENGTH_SHORT).show()
        }
    }

    private fun startRunnable() {
        /*val thread = Thread(MyRunnable())
        thread.start()*/

        DataSingleton.getInstance().getExecutor().execute(MyRunnable())
    }

    private fun startThread() {
        thread = MyThread()
        thread.start()
        thread.display()
    }
}