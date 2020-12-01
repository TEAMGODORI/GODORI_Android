package com.example.godori

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



//        //recyclerview 가로로 배치
//        recyclerview_main.layoutManager = LinearLayoutManager(
//            activity,
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )
//
//
//        //어댑터의 데이터와 연결한 리스트 뷰에 연결
//        postToList()
//
//        //어댑터 설정
//        recyclerview_main.adapter = GroupMoreAdapter(titleList)

        return view

    }

//    private fun addToList(title: String){
//        //게시할 리스트에있는 항목을(titleList) 데이터(title)과 바인
//        titleList.add(title)
//    }
//
//    private fun postToList(){
//        for (i in 1..5){
//            //리스트시 게시
//            addToList("Title $i")
//        }
//
//    }

}