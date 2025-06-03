package com.example.launchmodesample.standard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.launchmodesample.R
import com.example.launchmodesample.TAG

class SecondStandardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("$TAG SecondStandardActivity", "onCreate")
        setContentView(R.layout.activity_second_standard)

        findViewById<Button>(R.id.buttonToThird).setOnClickListener {
            startActivity(Intent(this, ThirdStandardActivity::class.java))
        }

        findViewById<Button>(R.id.buttonSelfLaunch).setOnClickListener {
            // launch SecondActivity again, new screen will be added to stack
            startActivity(Intent(this, SecondStandardActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("$TAG  SecondStandardActivity", "onNewIntent")
    }
}
