package com.example.godori

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.Btn3
import kotlinx.android.synthetic.main.activity_certif_tab_upload3.*

class CertifTabUpload3Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload3)

        Lay1.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                Ibn1.setBackgroundResource(R.drawable.button_check)
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                Ibn1.setBackgroundResource(R.drawable.button_check)
            }
            false
        }
    }
}