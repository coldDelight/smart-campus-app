package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.databinding.ItemRecyclerSurveyDetailBinding
import com.example.smart_campus.model.SurveyDetail
import com.example.smart_campus.model.SurveyDetailItem

class SurveyDetailAdapter  : RecyclerView.Adapter<SurveyDetailAdapter.ViewHolder>(){
    private var items: SurveyDetail = SurveyDetail(ArrayList())

    inner class ViewHolder(private val binding: ItemRecyclerSurveyDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(item: SurveyDetailItem){
            binding.textView6.text = item.question
        }
    }

    override fun getItemCount():Int{
        return items.response.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerSurveyDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items.response[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: SurveyDetail) {
        this.items = newItems
        notifyDataSetChanged()
    }


}