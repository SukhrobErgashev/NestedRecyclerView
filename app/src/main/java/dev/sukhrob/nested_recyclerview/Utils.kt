package dev.sukhrob.nested_recyclerview

import dev.sukhrob.nested_recyclerview.model.InnerData
import dev.sukhrob.nested_recyclerview.model.OuterData

object Utils {

    fun getChooseWordList(): ArrayList<OuterData> {
        val innerData = ArrayList<InnerData>()
        for (i in 1..10) {
            innerData.add(InnerData(i, false))
        }

        val outerData = ArrayList<OuterData>()
        for (i in 1..7) {
            outerData.add(OuterData(i, innerData, isChecked = false, isExpanded = false))
        }

        return outerData
    }

}