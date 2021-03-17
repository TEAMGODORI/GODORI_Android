package com.example.godori.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.godori.R

class GroupMoreAdapter()
    : RecyclerView.Adapter<GroupMoreAdapter.GroupMoreViewHolder>(){

    class GroupMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //카드레이아웃 안에 요소 불러오기
        val itemCategory: TextView = itemView.findViewById(R.id.GroupMoreCard_category)

        //초기화
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
        return 21
    }
}