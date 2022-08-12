package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.databinding.ItemRecylerNoteBinding
import com.example.smart_campus.model.Note
import com.example.smart_campus.model.NoteItem

class NoteRecylerAdapter : RecyclerView.Adapter<NoteRecylerAdapter.ViewHolder>() {
    //    private var items: Group = Group("", listOf(GroupItem("","","")),"")
    private var items: Note = Note(ArrayList())

    // 뷰 홀더 만들어서 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecylerNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items.response[position])
    }
    // 뷰 홀더 설정
    inner class ViewHolder(private val binding: ItemRecylerNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(item: NoteItem){
            binding.tvNoteTitle.text =  item.push_title
            binding.tvNoteContent.text =  item.push_content
            binding.tvNoteDate.text =  item.push_date.subSequence(0,10)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: Note) {
        this.items = newItems
        notifyDataSetChanged()
    }

    // 아이템 갯수
//    override fun getItemCount() = items.data.size
    override fun getItemCount():Int{
        Log.e("fffffffff", "getItemCount:    ${items.response.size}", )
        
        return items.response.size
    }

}