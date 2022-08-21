package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.databinding.ItemRecyclerGroupBinding
import com.example.smart_campus.model.Group
import com.example.smart_campus.model.GroupItem

class GroupRecyclerAdapter() : RecyclerView.Adapter<GroupRecyclerAdapter.ViewHolder>() {
private var items: Group = Group(ArrayList())
    lateinit var onItemClick : (Int)->Unit
    lateinit var onDelClick : (String)->Unit

    var isDelSate = false

    // 뷰 홀더 만들어서 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            onItemClick(position)
        }
        if(isDelSate){
            holder.checkBox.visibility = View.VISIBLE
        }else{
            holder.checkBox.visibility = View.GONE
        }
        holder.setItem(items.response[position])
    }
    // 뷰 홀더 설정
    inner class ViewHolder(private val binding: ItemRecyclerGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        val checkBox = binding.checkBox
        val swipeView = binding.layoutGroupItem
        fun setItem(item: GroupItem){
            binding.tvTitle.text =  item.group_name
//            binding.tvContents.text =  item.intro
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: Group ) {
        this.items = newItems
        notifyDataSetChanged()
    }
    // 아이템 갯수
    override fun getItemCount() = items.response.size
}