package com.fatherofapps.androidbase.data.entities

import com.squareup.moshi.Json
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


data class ProductItemsJson(
    val items: List<ProductJson> = emptyList(),
    @Json(name = "total_count") val totalCount: Int = 0
)

data class ProductJson(
    @Json(name = "id") val id: Int = -1,
    @Json(name = "sku") val sku: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "price") val price: Float = -1f,
    val weight: Float = 0f,
    @Json(name = "type_id") val typeProduct: String?,
    @Json(name = "options") val customizableOptions: List<CustomizableOption> = emptyList(),
    @Json(name = "extension_attributes") val productExtensionAttribute: ProductExtensionAttribute? = null,
    @Json(name = "media_gallery_entries") val listImages: List<ProductImage> = emptyList(),
    @Json(name = "custom_attributes") val listCustomAttributes: List<CustomAttribute> = emptyList()
)

@Parcelize
class ProductImage(
    @Json(name = "media_type") val mediaType: String?,
    @Json(name = "position") val position: Int = 0,
    @Json(name = "disabled") val isDisabled: Boolean = false,
    @Json(name = "file") val imagePath: String?
) : Parcelable

@Parcelize
class ProductExtensionAttribute(
    @Json(name = "stock_item") val stockItem: ProductStockItem? = null,
    @Json(name = "configurable_product_options") val configurableOptions: List<ConfigurableOptionJson> = emptyList()
) : Parcelable

@Parcelize
class CustomizableOption(
    @Json(name = "product_sku") val productSku: String?,
    @Json(name = "option_id") val optionId: Int,
    val title: String,
    val type: String,
    @Json(name = "sortOrder") val sortOrder: Int = 0,
    @Json(name = "is_required") val isRequired: Boolean = false,
    @Json(name = "max_characters") val maxCharacters: Int = 0,
    @Json(name = "price_type") val priceType: String? = null,
    @Json(name = "price") val price: Float = 0f,
    var displayPrice: Float = 0f,
    var values: List<CustomizableOptionValue> = listOf(),
    var selectedValue: String? = null
) : Parcelable

@Parcelize
class CustomizableOptionValue(
    val title: String,
    @Json(name = "sort_order") val sortOrder: Int,
    val price: Float,
    @Json(name = "price_type") val priceType: String,
    @Json(name = "option_type_id") val optionTypeId: Int,
    var disPlayPrice: Float = 0f,
    var isSelected: Boolean = false
) : Parcelable

@Parcelize
class ConfigurableOptionJson(
    val id: Int,
    @Json(name = "attribute_id") val attributeId: String,
    val label: String,
    val position: Int,
    val values: List<ValueIndexJson>?
) : Parcelable

@Parcelize
class ValueIndexJson(
    @Json(name = "value_index") val valueIndex: Int
) : Parcelable

@Parcelize
class ConfigurableOption(
    val id: Int,
    val attributeId: String,
    var attributeCode: String = "",
    var label: String,
    val position: Int,
    var values: List<ConfigurableOptionValue>
) : Parcelable {
    fun updateWithProductAttribute(attribute: ProductAttribute) {
        attributeCode = attribute.attributeCode ?: ""
        values?.forEach { configurableOptionValue ->

            val productAttributeOption =
                attribute.options.find { it.getValueInt() == configurableOptionValue.value }
            configurableOptionValue.label = productAttributeOption?.label ?: ""
        }
    }
}

@Parcelize
class ConfigurableOptionValue(
    val value: Int = -1,
    var label: String = "",
    var selected: Boolean = false,
    var listDependencies: List<String> = emptyList()
) : Parcelable

@Parcelize
class CustomAttribute(
    @Json(name = "attribute_code") val attributeCode: String,
    @Json(name = "value") val value: @RawValue Any? = null
) : Parcelable

@Parcelize
class ProductStockItem(
    val qty: Int? = 0,
    @Json(name = "is_in_stock") val isInStock: Boolean = true,
    @Json(name = "is_qty_decimal") val isQtyDecimal: Boolean = false,
    @Json(name = "use_config_min_qty") val isUseConfigMinQty: Boolean = true,
    @Json(name = "min_qty") val minQty: Float = 0f,
    @Json(name = "use_config_min_sale_qty") val isUseConfigMinSaleQty: Int = 1,
    @Json(name = "min_sale_qty") val minSaleQty: Float = 0f,
    @Json(name = "use_config_max_sale_qty") val isUseConfigMaxSaleQty: Boolean = true,
    @Json(name = "max_sale_qty") val maxSaleQty: Float = 0f,
    @Json(name = "low_stock_date") val lowStockDate: String? = null
): Parcelable

data class ProductAttributeListJson(
    @Json(name = "items") val listAttributes: List<ProductAttribute> = emptyList(),
    @Json(name = "total_count") val totalCount: Int = 0
)

data class ProductAttribute(
    @Json(name = "attribute_id")
    val attributeId: String?,
    @Json(name = "attribute_code")
    val attributeCode: String?,
    val options: List<ProductAttributeOption> = emptyList(),
    @Json(name = "frontend_labels") val labels: List<AttributeLabel> = emptyList()
)

class ProductAttributeOption(
    val label: String?,
    val value: String,
    @Json(name = "sort_order") val sortOrder: Int = 0,
    @Json(name = "is_default") val isDefault: Boolean = false,
    @Json(name = "store_labels") val storeLabels: List<AttributeLabel> = emptyList()
) {
    fun getValueInt(): Int {
        if (value.isNotEmpty()) {
            try {
                return value.toInt()
            } catch (e: Exception) {

            }
        }
        return -1
    }
}

data class AttributeLabel(
    @Json(name = "store_id") val storeId: String?,
    @Json(name = "label") val label: String?
)

@Parcelize
class Product(
    val id: Int,
    val sku: String?,
    val name: String?,
    val price: Float = -1f,
    val weight: Float = 0f,
    val typeProduct: String?,
    var customizableOptions: List<CustomizableOption> = emptyList(),
    var configurableOptions: List<ConfigurableOption> = emptyList(),
    val productExtensionAttribute: ProductExtensionAttribute? = null,
    val listImages: List<ProductImage> = emptyList(),
    val customAttributes: @RawValue Map<String, Any?> = emptyMap()
) : Parcelable {
    fun getFinalPrice(): Float {

        val specialPrice = getSpecialPrice()
        return if (specialPrice > -1f) specialPrice else price
    }

    fun getSpecialPrice(): Float {
        val special_price = customAttributes["special_price"]
        if (special_price != null && special_price is String) {
            try {
                return special_price.toFloat()
            } catch (e: Exception) {

            }
        }
        return -1f
    }

}