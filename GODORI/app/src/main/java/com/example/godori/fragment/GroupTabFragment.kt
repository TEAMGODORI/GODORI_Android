package com.example.godori.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.example.godori.activity.GroupRecruitingActivity
import com.example.godori.adapter.GroupMoreAdapter
import com.example.godori.R
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