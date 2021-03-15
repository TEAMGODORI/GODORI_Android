package com.example.godori.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.godori.R


class GroupCreation3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_creation3)

        // xml 요소
        val next: Button = findViewById(R.id.gr_btn_creation3_next)
        val back: ImageButton = findViewById(R.id.gr_btn_creation3_back)


        next.setOnClickListener {
            val intent = Intent(this, GroupCreation4Activity::class.java)
            startActivity(intent)
        }
    }
}