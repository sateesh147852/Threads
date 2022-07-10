package com.threads

import android.util.Log

class MyThread : Thread() {

    private val TAG : String = MyThread::class.java.simpleName

    override fun run() {
        Log.i(TAG, "run: "+Thread.currentThread().name)
        display()

    }

    public fun display(){
        Log.i(TAG, "display: "+Thread.currentThread().name)
    }
}