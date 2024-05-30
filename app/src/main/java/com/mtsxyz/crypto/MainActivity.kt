package com.mtsxyz.crypto

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_aes_enc).setOnClickListener {

        }
        findViewById<Button>(R.id.bt_aes_dec).setOnClickListener {

        }
    }
}
