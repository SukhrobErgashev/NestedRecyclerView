package dev.sukhrob.nested_recyclerview.dialog

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.sukhrob.nested_recyclerview.CheckListener
import dev.sukhrob.nested_recyclerview.Utils
import dev.sukhrob.nested_recyclerview.adapter.OuterAdapter
import dev.sukhrob.nested_recyclerview.databinding.DialogMyBinding
import dev.sukhrob.nested_recyclerview.model.OuterData

class MyDialog: BaseDialog<DialogMyBinding>(DialogMyBinding::inflate) {
    private lateinit var data: List<OuterData>
    private lateinit var adapter: OuterAdapter
    private lateinit var truthData: List<OuterData>

    // The data will pass to MainActivity when user press 'Ok' btn.
    var selected: ((List<OuterData>) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        truthData = Utils.getFakeData()
        val listener = object : CheckListener {

            override fun chapterItemPressed(chapter: Int, b: Boolean) {
                truthData[chapter].sections.onEach {
                    it.isChecked = b
                }
            }

            override fun sectionItemPressed(chapter: Int, section: Int, b: Boolean) {
                truthData[chapter].sections[section].isChecked = b
            }

        }

        data = Utils.getFakeData()
        adapter = OuterAdapter(data, listener)

        setViewListeners()
        setupRV()
    }

    private fun setViewListeners() {
        binding.btnOk.setOnClickListener {
            selected?.invoke(truthData)
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun setupRV() {
        binding.outerRv.layoutManager = LinearLayoutManager(binding.root.context)
        binding.outerRv.adapter = this.adapter
    }

}