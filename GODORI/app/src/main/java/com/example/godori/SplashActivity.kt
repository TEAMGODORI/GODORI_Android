package com.example.godori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            Thread.sleep(3000)
            val intent = Intent(this, TabBarActivity::class.java)
            startActivity(intent)
            finish()
        }
        catch (e: Exception){
            return;
        }
    }
}