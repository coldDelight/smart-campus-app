package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.R
import com.example.smart_campus.databinding.ItemRecyclerChatbotBinding
import com.example.smart_campus.model.ChatbotMessage

class ChatbotRecyclerAdapter : RecyclerView.Adapter<ChatbotRecyclerAdapter.ViewHolder>() {
    private var items: ArrayList<ChatbotMessage> = ArrayList()
    private var lastIndex :Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerChatbotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    //보낸건지 받은 건지 세팅하기
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.e("ddddd", "onBindViewHolder: $position  ${items.size}", )
        if (items[position].isUserSend){
            holder.cv.setBackgroundResource(R.color.grey)
            holder.layout_main.gravity = Gravity.END
            holder.chatbotIcon.visibility = View.GONE
        }else {
            holder.cv.setBackgroundResource(R.color.white)
            holder.layout_main.gravity = Gravity.START
            if(position+1 ==items.size){
                holder.chatbotIcon.visibility = View.VISIBLE
            }else{
                holder.chatbotIcon.visibility = View.GONE
            }
        }
        holder.setItem(items[position].mes)
    }
    inner class ViewHolder(private val binding: ItemRecyclerChatbotBinding) : RecyclerView.ViewHolder(binding.root) {
        val cv = binding.cvChatbot
        val layout_main = binding.layoutCard
        val chatbotIcon = binding.cahtbotIcon
        fun setItem(item: String){
            binding.tvChatbot.text = item
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: ChatbotMessage) {
        this.items.add(newItems)
        notifyDataSetChanged()
    }

    // 아이템 갯수
    override fun getItemCount():Int{
        return items.size
    }

}