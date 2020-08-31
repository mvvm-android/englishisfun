package com.jpaya.base.adapter

interface GenericAdapterComparator<T> {

    fun isSameItemAs(item: T): Boolean

    fun hasSameContentsAs(item: T): Boolean
}
