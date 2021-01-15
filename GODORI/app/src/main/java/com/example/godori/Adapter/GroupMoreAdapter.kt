<<<<<<< HEAD:GODORI/app/src/main/java/com/example/godori/Adapter/GroupMoreAdapter.kt
package com.example.godori.Adapter//package com.example.godori
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
=======
package com.example.godori

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.group_more_card_layout.view.*
import org.w3c.dom.Text

class GroupMoreAdapter()
    : RecyclerView.Adapter<GroupMoreAdapter.GroupMoreViewHolder>(){

    class GroupMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //카드레이아웃 안에 요소 불러오기
        val itemCategory: TextView = itemView.findViewById(R.id.GroupMoreCard_category)

        //초기화
>>>>>>> e98b50b1c4338a35d045555711101dcc0745d7d8:GODORI/app/src/main/java/com/example/godori/GroupMoreAdapter.kt
//        init {
//            itemView.setOnClickListener{
//                v : View ->
//                val position: Int = adapterPosition
//
//                //클릭되었을 때 할 일
//                //임시 토스트(실험용)
//                Toast.makeText(itemView.context, "you clicked on item # ${position+1}", android.widget.Toast.LENGTH_SHORT).show()
//            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupMoreViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.group_more_card_layout, parent, false)

        return GroupMoreViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: GroupMoreViewHolder, position: Int) {
        holder.itemCategory.setText("헬스")
    }

    override fun getItemCount(): Int {
        return 5
    }
}