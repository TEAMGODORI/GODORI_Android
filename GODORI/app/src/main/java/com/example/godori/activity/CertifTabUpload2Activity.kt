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
        backBtn1.setOnClickListener {
            onBackPressed()
        }

        //라디오 버튼 글자 색상
        strengthRbtn.setOnCheckedChangeListener { group, checkedId ->
                if (group.id == R.id.strengthRbtn) {
                    when (checkedId) {
                        R.id.rBtn1 -> {
                            rBtn1.setTextColor(Color.WHITE)
                            rBtn2.setTextColor(Color.BLACK)
                            rBtn3.setTextColor(Color.BLACK)
                            rBtn4.setTextColor(Color.BLACK)
                            rBtn5.setTextColor(Color.BLACK)
                        }
                        R.id.rBtn2 -> {
                            rBtn1.setTextColor(Color.BLACK)
                            rBtn2.setTextColor(Color.WHITE)
                            rBtn3.setTextColor(Color.BLACK)
                            rBtn4.setTextColor(Color.BLACK)
                            rBtn5.setTextColor(Color.BLACK)
                        }
                        R.id.rBtn3 -> {
                            rBtn1.setTextColor(Color.BLACK)
                            rBtn2.setTextColor(Color.BLACK)
                            rBtn3.setTextColor(Color.WHITE)
                            rBtn4.setTextColor(Color.BLACK)
                            rBtn5.setTextColor(Color.BLACK)
                        }
                        R.id.rBtn4 -> {
                            rBtn1.setTextColor(Color.BLACK)
                            rBtn2.setTextColor(Color.BLACK)
                            rBtn3.setTextColor(Color.BLACK)
                            rBtn4.setTextColor(Color.WHITE)
                            rBtn5.setTextColor(Color.BLACK)
                        }
                        R.id.rBtn5 -> {
                            rBtn1.setTextColor(Color.BLACK)
                            rBtn2.setTextColor(Color.BLACK)
                            rBtn3.setTextColor(Color.BLACK)
                            rBtn4.setTextColor(Color.BLACK)
                            rBtn5.setTextColor(Color.WHITE)
                        }
                    }
                }
            }
        next2Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload3Activity::class.java)
            startActivity(intent)
        }

        imgHealth.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                imgHealth.setImageResource(R.drawable.img_health_blue)
                imgHealthText.setTextColor(Color.parseColor("#677BF0"))
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                imgHealth.setImageResource(R.drawable.img_health_blue)
                imgHealthText.setTextColor(Color.parseColor("#677BF0"))
            }
            false
        }
        imgYoga.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                imgYoga.setImageResource(R.drawable.img_yoga_blue)
                imgYogaText.setTextColor(Color.parseColor("#677BF0"))
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                imgYoga.setImageResource(R.drawable.img_yoga_blue)
//                imgYoga.setBackgroundResource(R.drawable.button_circle)
                imgYogaText.setTextColor(Color.parseColor("#677BF0"))
            }
            false
        }

    }

    fun onClickExercise(view: View){

    }
}