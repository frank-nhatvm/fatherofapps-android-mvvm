package com.fatherofapps.androidbase.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fatherofapps.androidbase.data.models.Customer
import com.fatherofapps.androidbase.databinding.AdapterHomeBinding

class HomeAdapter constructor(private val itemListener: HomeAdapterItemListener) :
    ListAdapter<Customer, HomeAdapter.HomeViewHolder>(CustomerDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val customer = getItem(position)
        holder.bind(customer, itemListener)
    }

    class HomeViewHolder private constructor(private val dataBinding: AdapterHomeBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        companion object {
            fun from(parent: ViewGroup): HomeViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = AdapterHomeBinding.inflate(inflater, parent, false)
                return HomeViewHolder(binding)
            }
        }

        fun bind(customer: Customer, itemListener: HomeAdapterItemListener) {
            dataBinding.customer = customer
            dataBinding.itemListener = itemListener
            dataBinding.executePendingBindings()
        }
    }

    interface HomeAdapterItemListener {
        fun onClickItem(customer: Customer)
    }

    class CustomerDiffUtil : DiffUtil.ItemCallback<Customer>() {
        override fun areItemsTheSame(oldItem: Customer, newItem: Customer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean {
            return oldItem.id == newItem.id
        }
    }
}