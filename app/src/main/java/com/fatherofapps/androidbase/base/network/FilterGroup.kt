package com.fatherofapps.androidbase.base.network

class FilterGroup(var listFilterItems: MutableList<FilterItem> = mutableListOf()) {

    fun addFilterItem(filterItem: FilterItem) {
        listFilterItems.add(filterItem)
    }

    fun addFilterItem(fieldName: String, searchValue: String, conditionType: ConditionType) {
        val filterItem = FilterItem(fieldName, searchValue, conditionType)
        addFilterItem(filterItem)
    }

    fun build(prefix: String): Map<String, String> {

        val hashMap = mutableMapOf<String, String>()

        listFilterItems.forEachIndexed { index, filterItem ->

            hashMap["$prefix[$index][field]"] = filterItem.fieldName
            hashMap["$prefix[$index][value]"] = filterItem.searchValue
            hashMap["$prefix[$index][condition_type]"] = filterItem.conditionType.name.toLowerCase()
        }

        return hashMap
    }
}