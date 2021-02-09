package com.example.godori.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatRadioButton
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*
import kotlinx.android.synthetic.main.fragment_tutorial_height.*
import kotlinx.android.synthetic.main.fragment_tutorial_height.backBtn1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TutorialWeightFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TutorialWeightFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial_weight, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TutorialWeightFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TutorialWeightFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //라디오 버튼 글자 색상
    fun onRadioButtonClicked(view: View) {
        val isSelected = (view as AppCompatRadioButton).isChecked
        when (view.id) {
            R.id.openRbtn -> if (isSelected) {
                openRbtn.setTextColor(Color.WHITE)
                unopenRbtn.setTextColor(Color.parseColor("#677BF0"))
            }
            R.id.unopenRbtn -> if (isSelected) {
                unopenRbtn.setTextColor(Color.WHITE)
                openRbtn.setTextColor(Color.parseColor("#677BF0"))
            }
        }
    }
}