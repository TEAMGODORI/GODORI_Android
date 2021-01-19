package com.example.godori.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.godori.activity.CertifTabDetailActivity
import com.example.godori.activity.CertifTabUpload1Activity
import com.example.godori.R
import com.view.calender.horizontal.umar.horizontalcalendarview.HorizontalCalendarView
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_certif_tab, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // item List 준비
        val personList = ArrayList<PersonForList>()
        for (i in 0 until 7) { // 이후 명수 가져오기
            personList.add(PersonForList("" + i + " 사람"))
        }

        // adapter 생성
        val adapter = certifRecyclerViewAdapter(personList, LayoutInflater.from(this.context))
        certifRecycler.adapter = adapter
        certifRecycler.layoutManager = GridLayoutManager(this.context, 2)

    }

    // 사람별 인증 리스트
    class PersonForList(val name: String) {

    }

    //인증탭 리사이클러뷰 어댑터
    class certifRecyclerViewAdapter(
        val itemList: ArrayList<PersonForList>,
        val inflater: LayoutInflater
    ):RecyclerView.Adapter<certifRecyclerViewAdapter.ViewHolder>() {

        @SuppressLint("RestrictedApi")
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //
            var personName: TextView
            var certifImg: ImageView

            init {
                personName = itemView.findViewById(R.id.personName)
                certifImg = itemView.findViewById(R.id.certifImg)

                // Person 아이템을 눌렀을 때
                itemView.setOnClickListener { view ->
//                    val posintion: Int = adapterPosition
//                    val personName = itemList.get(posintion).name

                    //CertifTabDetailActivity로 이동
                    val intent = Intent(view.context, CertifTabDetailActivity::class.java)
                    view.getContext().startActivity(intent)
                }
            }
        }

        // 아이템 하나가 들어갈 뷰를 만들고 뷰 홀더(*****)에 넣어줌
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.item_certif_tab, parent, false)
            return ViewHolder(view)
        }

        //리스트의 전체 개수
        override fun getItemCount(): Int {
            return itemList.size
        }

        //뷰를 그리는 부분
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.certifImg.setImageResource(R.drawable.certif_un)
            holder.personName.setText(itemList.get(position).name)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        uploadBtn1.setOnClickListener {
            val intent = Intent(getActivity(), CertifTabUpload1Activity::class.java)
            startActivity(intent)
        }
    }

}