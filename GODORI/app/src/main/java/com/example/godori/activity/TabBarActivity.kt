package com.example.godori.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.godori.R
import com.example.godori.adapter.TabBarViewPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.fragment_certif_tab.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates


class TabBarActivity : AppCompatActivity() {
    private lateinit var viewpagerAdapter: TabBarViewPagerAdapter
//    private lateinit var certifAdapter: CertifTabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_bar)

        // 뷰 페이저 세팅
        viewpagerAdapter = TabBarViewPagerAdapter(supportFragmentManager)
        tabbar_viewpager.adapter = viewpagerAdapter

//        certifAdapter = CertifTabAdapter(supportFragmentManager)
//        tabbar_viewpager.adapter = certifAdapter

        tabbar_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                tabbar.menu.getItem(position).isChecked = true
            }
        })

        // 바텀 네비게이션 세팅
        tabbar.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when (it.itemId) {
                R.id.menu_group -> index = 0
                R.id.menu_certi -> index = 1
                R.id.menu_myinfo -> index = 2
            }
            tabbar_viewpager.currentItem = index
            true
        }

    }

}
