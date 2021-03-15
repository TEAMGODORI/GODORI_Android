package com.example.godori.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.godori.R

class GroupCreation4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_creation4)

        // xml 요소
        val next: Button = findViewById(R.id.gr_btn_creation4_next)
        val back: ImageButton = findViewById(R.id.gr_btn_creation4_back)


    }
}