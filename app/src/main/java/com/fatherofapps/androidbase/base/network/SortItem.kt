package com.fatherofapps.androidbase.base.network

class SortItem(var fieldName: String, var direction: SortDirection) {
    fun build(prefix: String): Map<String, String> {
        val hashMap = mutableMapOf<String, String>()
        hashMap["$prefix[field]"] = fieldName
        hashMap["$prefix[direction]"] = direction.name
        return hashMap
    }
}

enum class SortDirection(direction: String) {
    ASC("ASC"),
    DESC("DESC")
}