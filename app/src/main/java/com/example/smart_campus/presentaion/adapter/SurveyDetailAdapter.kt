package com.example.smart_campus.presentaion.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_campus.databinding.ItemMultiCheckboxBinding
import com.example.smart_campus.databinding.ItemMultiLongBinding
import com.example.smart_campus.databinding.ItemMultiRadioBinding
import com.example.smart_campus.databinding.ItemMultiShortBinding
import com.example.smart_campus.model.SurveyDetail
import com.example.smart_campus.model.SurveyDetailItem
import java.lang.IllegalArgumentException

class SurveyDetailAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//    private var items: SurveyDetail = SurveyDetail(ArrayList())

    private var items: SurveyDetail = SurveyDetail(ArrayList())
    var answer = mutableMapOf<Int,String>()




    class CheckViewHolder(val checkBinding: ItemMultiCheckboxBinding):RecyclerView.ViewHolder(checkBinding.root){
        fun bind(item : SurveyDetailItem){
            checkBinding.tvRvAge.text = item.type_name
        }
    }
    class LongViewHolder(val longBinding: ItemMultiLongBinding):RecyclerView.ViewHolder(longBinding.root){
        val etLong = longBinding.etLong
        fun bind(item : SurveyDetailItem){
            longBinding.tvLongQ.text = item.question
        }
    }
    class RadioViewHolder(val radioBinding: ItemMultiRadioBinding):RecyclerView.ViewHolder(radioBinding.root){
        fun bind(item : SurveyDetailItem){
            radioBinding.tvRvAge.text = item.type_name
        }
    }
    class ShortViewHolder(val shortBinding: ItemMultiShortBinding):RecyclerView.ViewHolder(shortBinding.root){
        val etShort = shortBinding.etShort

        fun bind(item : SurveyDetailItem){
            shortBinding.tvShotQ.text = item.question
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            DataType.TYPE_CHECK-> CheckViewHolder(ItemMultiCheckboxBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            DataType.TYPE_SHORT-> ShortViewHolder(ItemMultiShortBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            DataType.TYPE_LONG-> LongViewHolder(ItemMultiLongBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            DataType.TYPE_RADIO-> RadioViewHolder(ItemMultiRadioBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> throw IllegalArgumentException("err")
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is CheckViewHolder->holder.bind(items.response[position])
            is ShortViewHolder->{
                holder.bind(items.response[position])
                holder.etShort.doAfterTextChanged {
                    val id = items.response[position].id
                    answer[id] = it.toString()
                }
            }
            is RadioViewHolder->holder.bind(items.response[position])
            is LongViewHolder->{
                holder.bind(items.response[position])
                holder.etLong.doAfterTextChanged {
                    val id = items.response[position].id
                    answer[id] = it.toString()

                }
            }
        }
//        holder.setItem(items.response[position])
    }

    override fun getItemCount():Int{
        return items.response.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(items.response[position].type_name=="서술형"){
            DataType.TYPE_LONG
        }else if(items.response[position].type_name=="단답형"){
            DataType.TYPE_SHORT
        }else if(items.response[position].type_name=="체크박스"){
            DataType.TYPE_CHECK
        }else if(items.response[position].type_name=="라디오"){
            DataType.TYPE_RADIO
        }else{
            DataType.TYPE_CHECK
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: SurveyDetail) {
        this.items = newItems
        notifyDataSetChanged()
    }

}
object DataType {
    const val TYPE_SHORT =0
    const val TYPE_LONG =1
    const val TYPE_CHECK =2
    const val TYPE_RADIO =3
}