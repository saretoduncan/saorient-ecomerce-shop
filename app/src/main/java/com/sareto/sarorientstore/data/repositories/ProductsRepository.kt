package com.sareto.sarorientstore.data.repositories

import com.sareto.sarorientstore.data.network.apiHelpers.impl.ProductsHelperImpl
import javax.inject.Inject

class ProductsRepository
@Inject constructor(private val productsHelperImpl: ProductsHelperImpl){
    suspend fun getAllProducts()=productsHelperImpl.getAllProducts()
    suspend fun getProductById(id:String)= productsHelperImpl.getProductById(id)
    suspend fun getAllCategories()= productsHelperImpl.getAllCategories()
    suspend fun getProductsByCategory(categoryName:String)= productsHelperImpl.getProductsByCategory(categoryName)
}