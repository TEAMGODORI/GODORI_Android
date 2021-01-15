package com.example.godori.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_group_recruiting.*

class GroupRecruitingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_recruiting)

        btnRecruitingBack.setOnClickListener{
            val intent = Intent(this, TabBarActivity::class.java)
            startActivity(intent)
        }
    }
}