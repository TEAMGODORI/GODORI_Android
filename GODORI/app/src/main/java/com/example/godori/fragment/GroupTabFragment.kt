package com.example.godori.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.example.godori.R
import com.example.godori.activity.GroupCreation1Activity
import com.example.godori.activity.GroupRecruitingActivity
import com.example.godori.adapter.GroupMoreAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_group_info.*
import kotlinx.android.synthetic.main.fragment_group_tab.*


class GroupTabFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_group_tab, container, false)

        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // 그룹 생성하기 버튼
        gr_btn_main_creation.setOnClickListener{
            val intent = Intent(getActivity(), GroupCreation1Activity::class.java)
            startActivity(intent)
        }
        // 모집중인 그룹 버튼
        btnMoreGroup.setOnClickListener {
            val intent = Intent(getActivity(), GroupRecruitingActivity::class.java)
            startActivity(intent)
        }

        viewManager = LinearLayoutManager(context, HORIZONTAL, true)
        viewAdapter = GroupMoreAdapter()

//        recyclerView = recyclerview_favoriteExercise.apply {
//            setHasFixedSize(true)
//            // use a linear layout manager
//            layoutManager = viewManager
//            // specify an viewAdapter (see also next example)
//            adapter = viewAdapter
//        }
    }
}