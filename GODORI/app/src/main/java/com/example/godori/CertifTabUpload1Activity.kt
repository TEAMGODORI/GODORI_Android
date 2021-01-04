package com.example.godori

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*

class CertifTabUpload1Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload1)
        next1Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload2Activity::class.java)
            startActivity(intent)
        }

        time_Btn1.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                time_Btn1.setBackgroundResource(R.drawable.button_round_blue)
                time_Btn1.setTextColor(Color.WHITE)
                Img_Upload.setImageResource(R.drawable.certif)
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                time_Btn1.setBackgroundResource(R.drawable.button_round_blue)
                time_Btn1.setTextColor(Color.WHITE)
                Img_Upload.setImageResource(R.drawable.certif)
            }
            false
        }
    }
}