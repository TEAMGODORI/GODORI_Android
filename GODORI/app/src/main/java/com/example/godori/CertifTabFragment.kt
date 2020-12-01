package com.example.godori

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_certif_tab.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CertifTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CertifTabFragment : Fragment() {
    var tabBarActivity: TabBarActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context!!)
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        tabBarActivity = activity as TabBarActivity?
    }

    override fun onDetach() {
        super.onDetach()
        //이제 더이상 엑티비티 참초가안됨
        tabBarActivity = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_certif_tab, container, false)

//        certi1.setOnClickListener(View.OnClickListener { tabBarActivity?.onChangeFragment(3) })
        return view
    }

}