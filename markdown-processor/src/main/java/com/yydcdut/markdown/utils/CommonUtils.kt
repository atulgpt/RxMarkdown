package com.yydcdut.markdown.utils

object CommonUtils {
//    fun checkRange(start: Int, end: Int, length: Int): Boolean {
//        return if (end < start) {
//            false
//        } else if (start < 0 || start >= length) {
//            false
//        } else !(end < 0 || end >= length)
//    }

    fun checkIndex(index: Int, length: Int): Boolean {
        return !(index < 0 || index > length)
    }
}