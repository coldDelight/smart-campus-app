package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.databinding.ItemRecyclerGroupAllBinding
import com.example.smart_campus.databinding.ItemRecyclerGroupBinding
import com.example.smart_campus.model.Group
import com.example.smart_campus.model.GroupItem


class GroupAllRecyclerAdapter : RecyclerView.Adapter<GroupAllRecyclerAdapter.ViewHolder>() {
    private var items: Group = Group(ArrayList())
    lateinit var onAddClick : (String)->Unit

    // 뷰 홀더 만들어서 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerGroupAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.addBtn.setOnClickListener{
            onAddClick(items.response[position].group_id)
        }
        holder.setItem(items.response[position])
    }
    // 뷰 홀더 설정
    inner class ViewHolder(private val binding: ItemRecyclerGroupAllBinding) : RecyclerView.ViewHolder(binding.root) {
        val addBtn = binding.btnGroupAdd
        fun setItem(item: GroupItem){
            binding.tvTitle.text =  item.group_name
            binding.tvInfo.text =  item.intro
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