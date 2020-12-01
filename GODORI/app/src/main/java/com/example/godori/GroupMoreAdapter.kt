//package com.example.godori
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.view.menu.ActionMenuItemView
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.group_more_card_layout.view.*
//import org.w3c.dom.Text
//
//class GroupMoreAdapter(private var titles: List<String>
////                       ,private var details: List<String>, private var images:List<Int>
//)
//    : RecyclerView.Adapter<GroupMoreAdapter.ViewHolder>(){
//
//    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        //카드레이아웃 안에 요소 불러오기
//        val itemTitle: TextView = itemView.findViewById(R.id.tvGroupMoreCardCategory)
//
//        //초기화
//        init {
//            itemView.setOnClickListener{
//                v : View ->
//                val position: Int = adapterPosition
//
//                //클릭되었을 때 할 일
//                //임시 토스트(실험용)
//                Toast.makeText(itemView.context, "you clicked on item # ${position+1}", android.widget.Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.group_more_card_layout, parent, false)
//        return ViewHolder(v)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemTitle.text = titles[position]
////        holder.itemDetail.text = details[position]
////        holder.itemPicture.setImageResource(images[position])
//    }
//
//    override fun getItemCount(): Int {
//        return titles.size
//    }
//
//}