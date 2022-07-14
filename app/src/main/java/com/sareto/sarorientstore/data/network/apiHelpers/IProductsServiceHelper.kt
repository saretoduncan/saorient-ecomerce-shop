package com.sareto.sarorientstore.data.network.apiHelpers

import com.sareto.sarorientstore.data.models.Categories
import com.sareto.sarorientstore.data.models.Products
import com.sareto.sarorientstore.data.models.ProductsItem
import retrofit2.Response

interface IProductsServiceHelper {
    suspend fun getAllProducts():Response<Products>
    suspend fun getProductById(id:String):Response<ProductsItem>
    suspend fun getAllCategories():Response<Categories>
    suspend fun getProductsByCategory(categoryName:String):Response<Products>

}