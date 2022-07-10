package com.threads

import android.util.Log

class MyRunnable : Runnable {

    private val TAG : String = MyRunnable::class.java.simpleName

    override fun run() {
        Log.i(TAG, "run: "+Thread.currentThread().name)
        display()
    }

    private fun display() {
        Log.i(TAG, "display: "+Thread.currentThread().name)
    }


}