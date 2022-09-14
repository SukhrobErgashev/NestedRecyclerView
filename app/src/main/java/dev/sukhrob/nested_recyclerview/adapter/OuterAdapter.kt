package dev.sukhrob.nested_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.sukhrob.nested_recyclerview.CheckListener
import dev.sukhrob.nested_recyclerview.databinding.ItemOuterBinding
import dev.sukhrob.nested_recyclerview.model.OuterData


class OuterAdapter(
    private val outerDataList: List<OuterData>,
    private val listener: CheckListener
) : RecyclerView.Adapter<OuterAdapter.OuterViewHolder>() {

    inner class OuterViewHolder(private val binding: ItemOuterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var adapter: InnerAdapter

        fun bind() {

            adapter = InnerAdapter(
                outerDataList[adapterPosition].sections,
                outerDataList[adapterPosition].chapterNumber,
                listener
            )

            with(binding) {
                textChapterNumber.text = outerDataList[adapterPosition].chapterNumber.toString()
                checkboxChapter.isChecked = outerDataList[adapterPosition].isChecked
                expandableLayout.visibility =
                    if (outerDataList[adapterPosition].isExpanded) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
            }

            setupRV()
            setClickListeners()
        }

        private fun setClickListeners() {
            // expand recyclerview item's inner recyclerview
            binding.relativeLayout.setOnClickListener {
                outerDataList[adapterPosition].isExpanded =
                    !outerDataList[adapterPosition].isExpanded
                notifyItemChanged(adapterPosition)
            }

            // Chapter's checkbox is pressed
            binding.checkboxChapter.setOnClickListener {
                // change isChecked field of outer data object at index
                outerDataList[adapterPosition].isChecked = !outerDataList[adapterPosition].isChecked
                notifyItemChanged(adapterPosition)

                // pass data to MyDialog
                listener.chapterItemPressed(
                    outerDataList[adapterPosition].chapterNumber,
                    binding.checkboxChapter.isChecked
                )

                // set true or false all items of its all chapters
                adapter.changeInnerDataList(outerDataList[adapterPosition].isChecked)
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