package com.example.godori.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*


class CertifTabUpload2Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload2)

        //백버튼 눌렀을 때
        backBtn2.setOnClickListener {
            onBackPressed()
        }

        next2Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload3Activity::class.java)
            startActivity(intent)
        }

        var data = listOf("시간 선택", "30분", "1시간", "1시간 30분", "2시간")


    }
}