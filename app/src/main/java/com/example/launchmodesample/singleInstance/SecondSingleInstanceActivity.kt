package com.example.launchmodesample.singleInstance

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.launchmodesample.R
import com.example.launchmodesample.TAG

class SecondSingleInstanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("$TAG SecondSingleInstanceActivity", "onCreate")
        setContentView(R.layout.activity_second_single_instance)

        findViewById<Button>(R.id.button_second_activity_single_instance).setOnClickListener {
            startActivity(Intent(this, ThirdSingleInstanceActivity::class.java))
        }

        findViewById<Button>(R.id.button_self_launch).setOnClickListener {
            // launch SecondActivity again, new screen will be added to stack
            startActivity(Intent(this, SecondSingleInstanceActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("$TAG  SecondSingleInstanceActivity", "onNewIntent")
    }
}
