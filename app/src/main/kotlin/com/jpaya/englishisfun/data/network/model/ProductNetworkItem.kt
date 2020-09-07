/*
 * Copyright 2020 Jose Maria Payá Castillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpaya.englishisfun.data.network.model

/**
 * Class to map the products' WooCommerce response.
 */
class ProductNetworkItem {
    var id: Long = 0
    var name: String = ""
    var slug: String = ""
    var permalink: String = ""
    var date_created: String = ""
    var date_created_gmt: String = ""
    var date_modified: String = ""
    var date_modified_gmt: String = ""
    var type: String = ""
    var status: String = ""
    var featured: Boolean = false
    var catalog_visibility: String = ""
    var description: String = ""
    var short_description: String = ""
    var sku: String = ""
    var price: String = ""
    var regular_price: String = ""
    var date_on_sale_from: String = ""
    var date_on_sale_from_gmt: String = ""
    var date_on_sale_to: String = ""
    var date_on_sale_to_gmt: String = ""
    var price_html: String = ""
    var on_sale: Boolean = false
    var purchasable: Boolean = false
    var total_sales: Int = 0
    var virtual: Boolean = false
    var downloadable: Boolean = false
    var downloads: List<ProductDownloadNetworkItem> = listOf()
    var download_limit: Int = 0
    var download_expiry: Int = 0
    var external_url: String = ""
    var button_text: String = ""
    var tax_status: String = ""
    var tax_class: String = ""
    var manage_stock: Boolean = false
    var stock_quantity: Int = 0
    var stock_status: String = ""
    var backorders: String = ""
    var backorders_allowed: Boolean = false
    var backordered: Boolean = false
    var sold_individually: Boolean = false
    var weight: String = ""
    var dimensions: ProductDimensionsNetworkItem = ProductDimensionsNetworkItem()
    var shipping_required: Boolean = false
    var shipping_taxable: Boolean = false
    var shipping_class: String = ""
    var shipping_class_id: Int = 0
    var reviews_allowed: Boolean = false
    var average_rating: String = ""
    var rating_count: Int = 0
    var related_ids: IntArray = IntArray(0)
    var upsell_ids: IntArray = IntArray(0)
    var cross_sell_ids: IntArray = IntArray(0)
    var parent_id: Long = 0
    var purchase_note: String = ""
    var categories: List<ProductCategoryNetworkItem> = listOf()
    var tags: List<ProductTagNetworkItem> = listOf()
    var images: List<ProductCategoryImageNetworkItem> = listOf()
    var attributes: List<ProductAttributeNetworkItem> = listOf()
    var default_attributes: List<ProductDefaultAttributeNetworkItem> = listOf()
    var variations: IntArray = IntArray(0)
    var grouped_products: IntArray = IntArray(0)
    var menu_order: Int = 0
    var meta_data: List<ProductMetaDataNetworkItem> = listOf()
}
