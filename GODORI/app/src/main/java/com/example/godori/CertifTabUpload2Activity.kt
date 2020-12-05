package com.example.godori

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*


class CertifTabUpload2Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload2)

        next2Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload3Activity::class.java)
            startActivity(intent)
        }

        Btn3.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                Btn3.setBackgroundResource(R.drawable.button_circle2)
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                Btn3.setBackgroundResource(R.drawable.button_circle2)
            }
            false
        }

        ImgRun.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                ImgRun.setImageResource(R.drawable.img_running_m_blue)
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                ImgRun.setImageResource(R.drawable.img_running_m_blue)
            }
            false
        }
        imgHealth.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                imgHealth.setImageResource(R.drawable.img_health_blue)
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                imgHealth.setImageResource(R.drawable.img_health_blue)
            }
            false
        }

    }
}