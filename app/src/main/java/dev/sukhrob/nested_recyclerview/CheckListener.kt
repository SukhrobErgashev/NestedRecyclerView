package dev.sukhrob.nested_recyclerview

interface CheckListener {

    fun chapterItemPressed(chapter: Int, b: Boolean)
    fun sectionItemPressed(chapter: Int, section: Int, b: Boolean)

}