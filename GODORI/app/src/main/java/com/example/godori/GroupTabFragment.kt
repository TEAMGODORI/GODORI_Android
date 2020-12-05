package com.example.godori

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_group_tab.*


class GroupTabFragment : Fragment() {

    //reycle관련
//    private var titleList = mutableListOf<String>()
//    private var descList = mutableListOf<String>()
//    private var imagesList = mutableListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_group_tab, container, false)


        return view

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnMoreGroup.setOnClickListener {
            val intent = Intent(getActivity(), GroupRecruitingActivity::class.java)
            startActivity(intent)
        }
    }

}
