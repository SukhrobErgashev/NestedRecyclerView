package dev.sukhrob.nested_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.sukhrob.nested_recyclerview.databinding.ItemOuterBinding
import dev.sukhrob.nested_recyclerview.model.OuterData


class OuterAdapter(val outerDataList: ArrayList<OuterData>) :
    RecyclerView.Adapter<OuterAdapter.OuterViewHolder>() {

    inner class OuterViewHolder(private val binding: ItemOuterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter: InnerAdapter by lazy {
            InnerAdapter(outerDataList[adapterPosition].sections)
        }

        fun bind() {
            with(binding) {
                textChapterNumber.text = outerDataList[adapterPosition].chapterNumber.toString()
            }

            binding.expandableLayout.visibility =
                if (outerDataList[adapterPosition].isExpanded) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

            setupRV()

            binding.relativeLayout.setOnClickListener {
                outerDataList[adapterPosition].isExpanded = !outerDataList[adapterPosition].isExpanded
                notifyItemChanged(adapterPosition)
            }
        }

        private fun setupRV() {
            with(binding.innerRv) {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = this@OuterViewHolder.adapter
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder {
        return OuterViewHolder(
            ItemOuterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = outerDataList.size

}