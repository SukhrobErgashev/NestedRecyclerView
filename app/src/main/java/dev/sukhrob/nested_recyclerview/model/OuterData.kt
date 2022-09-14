package dev.sukhrob.nested_recyclerview.model

data class OuterData(
    val chapterNumber: Int,
    val sections: List<InnerData>,
    var isChecked: Boolean,
    var isExpanded: Boolean = false
)