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
 * Class to map the categories' WooCommerce response.
 */
class ProductCategoryNetworkItem {
    var id: Long = 0
    var name: String = ""
    var slug: String = ""
    var parent: Long = 0
    val description: String = ""
    val display: String = ""
    val image: ProductCategoryImageNetworkItem = ProductCategoryImageNetworkItem()
    val menu_order: Int = 0
    val count: Int = 0
}
