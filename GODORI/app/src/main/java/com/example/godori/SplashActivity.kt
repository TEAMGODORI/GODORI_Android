package com.example.godori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            Thread.sleep(2000)
            val intent = Intent(this, TabBarActivity::class.java)
            startActivity(intent)
            finish()
        }
        catch (e : Exception){
            return;
        }
    }


}