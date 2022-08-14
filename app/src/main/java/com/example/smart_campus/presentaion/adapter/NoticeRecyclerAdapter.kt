package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.databinding.ItemRecyclerNoticeBinding
import com.example.smart_campus.model.Notice
import com.example.smart_campus.model.NoticeItem

class NoticeRecyclerAdapter : RecyclerView.Adapter<NoticeRecyclerAdapter.ViewHolder>() {
    private var items: Notice = Notice(ArrayList())
    lateinit var onItemClick : (Int)->Unit


    // 뷰 홀더 만들어서 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            onItemClick(position)

        }
        holder.setItem(items.response[position])

    }
    // 뷰 홀더 설정
    inner class ViewHolder(private val binding: ItemRecyclerNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(item: NoticeItem){
            binding.tvNoticeTitle.text =  item.title
            binding.tvNoticeDate.text =  item.create_time.subSequence(0,10)
            binding.tvNoticeFile.text =  item.file_count
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: Notice) {
        this.items = newItems
        notifyDataSetChanged()
    }

    // 아이템 갯수
//    override fun getItemCount() = items.data.size
    override fun getItemCount():Int{

        return items.response.size
    }

}