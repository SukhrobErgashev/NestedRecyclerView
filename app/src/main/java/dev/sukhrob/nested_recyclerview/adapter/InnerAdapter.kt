package dev.sukhrob.nested_recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.sukhrob.nested_recyclerview.CheckListener
import dev.sukhrob.nested_recyclerview.databinding.ItemInnerBinding
import dev.sukhrob.nested_recyclerview.model.InnerData


class InnerAdapter(
    private val innerDataList: List<InnerData>,
    private val chapter: Int,
    private val listener: CheckListener
) : RecyclerView.Adapter<InnerAdapter.InnerViewHolder>() {

    inner class InnerViewHolder(private val binding: ItemInnerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            "  Section ${innerDataList[adapterPosition].sectionNumber}".also {
                binding.textSectionNumber.text = it
            }
            binding.checkboxSection.isChecked = innerDataList[adapterPosition].isChecked

            setListeners()
        }

        private fun setListeners() {
            binding.checkboxSection.setOnClickListener {
                innerDataList[adapterPosition].isChecked = !innerDataList[adapterPosition].isChecked
                notifyItemChanged(adapterPosition)

                notifyDialog()
            }
        }

        private fun notifyDialog() {
            listener.sectionItemPressed(
                chapter,
                innerDataList[adapterPosition].sectionNumber,
                binding.checkboxSection.isChecked
            )
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

    fun changeInnerDataList(b: Boolean) {
        innerDataList.onEach {
            it.isChecked = b
        }
        notifyDataSetChanged()
    }

}