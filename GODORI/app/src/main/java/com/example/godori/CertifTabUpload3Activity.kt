package com.example.godori

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*
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
//        next3Btn.setOnClickListener(View.OnClickListener {
//            val mainFragment: MainFragment = fragmentManager.findFragmentById(android.R.id.certifTabFrag) as MainFragment
//        })
    }
//    fun replaceFragment() {
//        val certifTabFragment = CertifTabFragment()
//        val fragmentManager: android.app.FragmentManager? = fragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(android.R.id.certifTabFrag, certifTabFragment)
//        fragmentTransaction.commit()
//    }
}

