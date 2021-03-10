package com.example.godori.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*
import java.text.SimpleDateFormat
import java.util.*

class CertifTabUpload1Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")

    // 여러 개의 버튼을 배열로 처리하기 위해 버튼에 대해 배열 선언을 함
    private var timeBtn: Array<Button?>? = arrayOfNulls(6)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload1)
        next1Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload2Activity::class.java)
            startActivity(intent)
        }

        //현재 시간 가져오기
        val now: Long = System.currentTimeMillis()

        //Date 형식으로 고치기
        val mDate = Date(now)

        //가져오고 싶은 형태로 가져오기 "2018-07-06 01:42:00"
        val simpleDate = SimpleDateFormat("yyyy/MM/dd\n aa hh:mm")
        val getTime: String = simpleDate.format(mDate)

        //5개 버튼
        time_Btn1.setText(getTime)
        time_Btn2.setText(getTime)
        time_Btn3.setText(getTime)
        time_Btn4.setText(getTime)
        time_Btn5.setText(getTime)

        time_Btn1.setOnClickListener {
            time_Btn1.setBackgroundResource(R.drawable.button_round_blue)
            time_Btn1.setTextColor(Color.WHITE)
            time_Btn1.setText(getTime)
//            Img_Upload.setImageResource(R.drawable.certif)
        }
    }
}

//fun time_Btn(view: View){
//    when(view?.id)
//    {
//        R.id
//    }
//}