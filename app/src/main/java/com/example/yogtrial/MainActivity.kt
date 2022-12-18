package com.example.yogtrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.yogtrial.live.PoseDetectionActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_start).setOnClickListener {
            var intent = Intent(this@MainActivity, PoseDetectionActivity::class.java)
            startActivity(intent)
        }
    }
}