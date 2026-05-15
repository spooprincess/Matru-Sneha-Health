package com.matrusneh.ui.kick

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matrusneh.databinding.ItemKicksPerHourBinding

class KicksPerHourAdapter : ListAdapter<KicksPerHourRow, KicksPerHourAdapter.VH>(Diff) {

    object Diff : DiffUtil.ItemCallback<KicksPerHourRow>() {
        override fun areItemsTheSame(oldItem: KicksPerHourRow, newItem: KicksPerHourRow): Boolean {
            return oldItem.dayIso == newItem.dayIso && oldItem.hourLabel == newItem.hourLabel
        }

        override fun areContentsTheSame(oldItem: KicksPerHourRow, newItem: KicksPerHourRow): Boolean {
            return oldItem == newItem
        }
    }

    class VH(val binding: ItemKicksPerHourBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemKicksPerHourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val row = getItem(position)
        holder.binding.textDay.text = row.dayIso
        holder.binding.textHour.text = row.hourLabel
        holder.binding.textCount.text = row.count.toString()
    }
}

