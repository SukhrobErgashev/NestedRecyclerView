package dev.sukhrob.nested_recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.sukhrob.nested_recyclerview.databinding.ItemInnerBinding
import dev.sukhrob.nested_recyclerview.model.InnerData


class InnerAdapter(val innerDataList: List<InnerData>) :
    RecyclerView.Adapter<InnerAdapter.InnerViewHolder>() {

    inner class InnerViewHolder(private val binding: ItemInnerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.checkboxSection.setOnClickListener {
                // some code
            }
        }

        fun bind() {
            "  Section ${innerDataList[adapterPosition].sectionNumber}".also { binding.textSectionNumber.text = it }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        return InnerViewHolder(
            ItemInnerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = innerDataList.size

}