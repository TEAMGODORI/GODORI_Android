package com.example.godori

import android.content.Context
import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_certif_tab.*
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CertifTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CertifTabFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_certif_tab, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        certi1.setOnClickListener {
            val intent = Intent(getActivity(), CertifTabDetailActivity::class.java)
            startActivity(intent)
        }
        uploadBtn1.setOnClickListener {
            val intent = Intent(getActivity(), CertifTabUpload1Activity::class.java)
            startActivity(intent)
        }
    }

}