package com.example.godori.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.godori.fragment.CertifTabFragment
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload3.*

class CertifTabUpload3Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload3)

        backBtn2.setOnClickListener {
            //백버튼 눌렀을 때
            onBackPressed()
        }

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
        Lay2.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                //터치했을 때
                Ibn2.setBackgroundResource(R.drawable.button_check)
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                //터치 해제했을 때
                Ibn2.setBackgroundResource(R.drawable.button_check)
            }
            false
        }

        val certifTabFragment = CertifTabFragment()

        next3Btn.setOnClickListener(View.OnClickListener {
            replaceFragment(certifTabFragment)
        })

    }

    // Fragment로 이동
    fun replaceFragment(fragment: Fragment?) {
        val certifTabFragment = CertifTabFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.certifTabFrag, certifTabFragment)
        fragmentTransaction.commit()
    }
}

