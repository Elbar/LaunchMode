package com.example.launchmodesample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.launchmodesample.standard.SecondStandardActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("$TAG  MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_start_standard).setOnClickListener {
            val intent = Intent(this, SecondStandardActivity::class.java)
            startActivity(intent)
        }
    }
}
