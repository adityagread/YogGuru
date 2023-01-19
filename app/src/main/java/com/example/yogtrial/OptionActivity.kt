package com.example.yogtrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.yogtrial.live.PoseDetectionActivity
import com.example.yogtrial.live.StillImageActivity

class OptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        findViewById<Button>(R.id.button_live).setOnClickListener {
            var intent = Intent(this, PoseDetectionActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button_upload).setOnClickListener {
            var intent = Intent(this, StillImageActivity::class.java)
            startActivity(intent)
        }
    }
}