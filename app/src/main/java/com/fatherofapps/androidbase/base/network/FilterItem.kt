package com.fatherofapps.androidbase.base.network

class FilterItem(var fieldName: String, var searchValue: String, var conditionType: ConditionType) {
    companion object {
        const val KEY_PAGE_SIZE = "searchCriteria[pageSize]"
        const val KEY_CURRENT_PAGE = "searchCriteria[currentPage]"
        const val KEY_FIELDS = "fields"
    }
}


enum class ConditionType(type: String) {
    EQ("eq"), // Equals
    FINSET("finset"), // A value within a set of values
    FROM("from"), // The beginning of a range. Must be used with to
    TO("to"), // The end of a range. Must be used with from
    GT("gt"), // Greater than
    GTEQ("gteq"), // // Greater than or equal
    IN("in"), // In. The value can contain a comma-separated list of values.
    LIKE("like"), // Like. The value can contain the SQL wildcard characters when like is specified.
    LT("lt"), // Less than
    LTEQ("lteq"), // Less than or equal
    MOREQ("moreq"), // More or equal
    NEQ("neq"), // Not equal
    NIN("nin"), // Not in. The value can contain a comma-separated list of values.
    NOTNUL("notnull"),  // Not null
    NULL("null") // null
}