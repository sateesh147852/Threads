package com.threads

import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicLong

class DataSingleton {

    private val counter  = AtomicLong(5)
    private var executor : ExecutorService? = null

    companion object{
        private var dataSingleton : DataSingleton? =null
        fun getInstance() : DataSingleton{
            if (dataSingleton==null)
                dataSingleton = DataSingleton()
            return dataSingleton!!
        }

    }

    fun getCounter() : Long = counter.addAndGet(5)

    fun getExecutor() : ExecutorService{
        if (executor == null){
            executor = Executors.newFixedThreadPool(5)
        }
        return executor!!
    }
}