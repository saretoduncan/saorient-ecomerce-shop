package com.sareto.sarorientstore.data.network.apiHelpers

import com.sareto.sarorientstore.data.models.Categories
import com.sareto.sarorientstore.data.models.Products
import com.sareto.sarorientstore.data.models.ProductsItem
import retrofit2.Response

interface IProductsServiceHelper {
    suspend fun getAllProducts():Response<Products>// get all products
    suspend fun getProductById(id:String):Response<ProductsItem>// get products by product id
    suspend fun getAllCategories():Response<Categories> // get all categories
    suspend fun getProductsByCategory(categoryName:String):Response<Products> // get products by category

}