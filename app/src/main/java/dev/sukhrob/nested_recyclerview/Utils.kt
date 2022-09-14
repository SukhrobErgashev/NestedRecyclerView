package dev.sukhrob.nested_recyclerview

import dev.sukhrob.nested_recyclerview.model.InnerData
import dev.sukhrob.nested_recyclerview.model.OuterData

object Utils {

    fun getFakeData(): ArrayList<OuterData> {

        val outerData = ArrayList<OuterData>()

        outerData.add(OuterData(1, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))
        outerData.add(OuterData(2, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))
        outerData.add(OuterData(3, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))
        outerData.add(OuterData(4, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))
        outerData.add(OuterData(5, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))
        outerData.add(OuterData(6, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))
        outerData.add(OuterData(7, listOf(InnerData(1, false), InnerData(2, false)), isChecked = false, isExpanded = false))


        return outerData
    }

}