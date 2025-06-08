package com.example.launchmodesample.singleInstance

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.launchmodesample.R
import com.example.launchmodesample.TAG

class ThirdSingleInstanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("$TAG ThirdSingleInstanceActivity", "onCreate")
        setContentView(R.layout.activity_third_single_instance)
    }
}



