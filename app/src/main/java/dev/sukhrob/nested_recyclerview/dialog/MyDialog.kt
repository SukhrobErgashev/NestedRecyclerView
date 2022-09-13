package dev.sukhrob.nested_recyclerview.dialog

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.sukhrob.nested_recyclerview.Utils
import dev.sukhrob.nested_recyclerview.adapter.OuterAdapter
import dev.sukhrob.nested_recyclerview.databinding.DialogMyBinding
import dev.sukhrob.nested_recyclerview.model.OuterData

class MyDialog: BaseDialog<DialogMyBinding>(DialogMyBinding::inflate) {

    companion object {
        val data: ArrayList<OuterData> = Utils.getChooseWordList()
    }

    var selected: ((List<OuterData>) -> Unit)? = null
    private val adapter: OuterAdapter by lazy { OuterAdapter(data) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewListeners()
        setupRV()
    }

    private fun setViewListeners() {
        binding.btnOk.setOnClickListener {
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            selected?.invoke(data)
            dismiss()
        }
    }

    private fun setupRV() {
        binding.outerRv.layoutManager = LinearLayoutManager(binding.root.context)
        binding.outerRv.adapter = this.adapter
    }

}