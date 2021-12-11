package com.example.company.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.company.R
import com.example.company.databinding.ItemHeaderBinding
import com.example.company.databinding.ItemUserBinding

class ConditionalHeaderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var userList = listOf<Any>()
    override fun getItemViewType(position: Int): Int {
        if (userList[position] !is String)
            return R.layout.item_header
        return R.layout.item_user
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == R.layout.item_header)
            return HeaderViewHolder(ItemHeaderBinding.bind(LayoutInflater.from(parent.context).inflate(
                R.layout.item_header, parent, false)))
        return UserViewHolder(ItemUserBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder)
            holder.bindHeaderData()
        else
            (holder as UserViewHolder).bindUserData()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(userList: ArrayList<Any>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(private val mBinding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bindHeaderData() {
            mBinding.tvHeader.text = "${userList[adapterPosition]}-11-2021"
        }
    }
    inner class UserViewHolder(private val mBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bindUserData() {
            mBinding.tvDescription.text = "${userList[adapterPosition]}"
        }
    }
}





