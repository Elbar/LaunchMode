package com.example.launchmodesample.standard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.launchmodesample.R
import com.example.launchmodesample.TAG

class ThirdStandardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("$TAG ThirdStandardActivity", "onCreate")
        setContentView(R.layout.activity_third_standard)
    }
}



