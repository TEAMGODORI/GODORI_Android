package com.example.godori.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*
import java.text.SimpleDateFormat
import java.util.*


class CertifTabUpload1Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")

    // 여러 개의 버튼을 배열로 처리하기 위해 버튼에 대해 배열 선언을 함
    private var  time_Btn: Array<Button?>? = arrayOfNulls(6)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload1)

        //백버튼 눌렀을 때
        backBtn1.setOnClickListener {
            onBackPressed()
        }

        //다음 화면으로 넘어가기
        next1Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload2Activity::class.java)
            startActivity(intent)
        }

        //현재 시간 가져오기
        val now: Long = System.currentTimeMillis()

        //Date 형식으로 고치기
        val mDate = Date(now)

        //가져오고 싶은 형태로 가져오기 "2018-07-06 01:42:00"
        val simpleDate = SimpleDateFormat("yyyy/MM/dd\n hh:mm")
        val getTime: String = simpleDate.format(mDate)

        //5개 버튼
        time_Btn1.setText(getTime)
        time_Btn2.setText(getTime)
        time_Btn3.setText(getTime)
        time_Btn4.setText(getTime)
        time_Btn5.setText(getTime)

//        time_Btn1.setOnClickListener {
//            time_Btn1.setTextColor(Color.WHITE)
//        }

        time_RBtn1.setOnCheckedChangeListener(listener1)
        time_RBtn2.setOnCheckedChangeListener(listener2)

    }

    //라디오 버튼 멀티라인
    private var listener1: RadioGroup.OnCheckedChangeListener? =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                time_RBtn2.setOnCheckedChangeListener(null)
                time_RBtn2.clearCheck()
                time_RBtn2.setOnCheckedChangeListener(listener2)
            }
        }

    //라디오 버튼 멀티라인
    private val listener2: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                time_RBtn1.setOnCheckedChangeListener(null)
                time_RBtn1.clearCheck()
                time_RBtn1.setOnCheckedChangeListener(listener1)
            }
        }

//    @SuppressLint("ResourceType")
//    fun onClick(v: View) {
//        // TODO Auto-generated method stub
//        when (v.getId()) {
//            R.id.btn_id_confirm -> {
//                if (time_RBtn1.getCheckedRadioButtonId() > 0) {
//                    val radioButton: View =
//                        time_RBtn1.findViewById(time_RBtn1.checkedRadioButtonId)
//                    val radioId: Int = time_RBtn1.indexOfChild(radioButton)
//                    val btn = time_RBtn1.getChildAt(radioId) as RadioButton
//                } else if (time_RBtn2.getCheckedRadioButtonId() > 0) {
//                    val radioButton: View =
//                        time_RBtn2.findViewById(time_RBtn2.getCheckedRadioButtonId())
//                    val radioId: Int = time_RBtn2.indexOfChild(radioButton)
//                    val btn = time_RBtn2.getChildAt(radioId) as RadioButton
//                }
//            }
//        }
//    }
}

//fun time_Btn(view: View){
//    when(view?.id)
//    {
//        R.id
//    }
//}
