package com.example.godori

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_group_tab.*

//reycle관련
private var mLayoutManager: RecyclerView.LayoutManager? = null
private var mAdapter: RecyclerView.Adapter<*>? = null
private val mRecyclerView: RecyclerView? = null

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GroupTabBeforeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GroupTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_group_tab, container, false)



//        //어댑터에서 만든 뷰 프래그먼트에 붙이는 과정
//        var recyclerView = recyclerview_main // recyclerview id
//
//        var layoutManager = LinearLayoutManager(getActivity())
//        recyclerView.layoutManager = layoutManager
//        var adapter = GroupMoreAdapter()
//        recyclerView.adapter = adapter



        return view
    }

}