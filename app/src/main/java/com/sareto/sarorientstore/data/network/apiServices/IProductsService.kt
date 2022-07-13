package com.sareto.sarorientstore.data.network.apiServices

import com.sareto.sarorientstore.data.models.Categories
import com.sareto.sarorientstore.data.models.Products
import com.sareto.sarorientstore.data.models.ProductsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface IProductsService {
    @Headers("Content-Type:application/json")
    @GET("products")//get all products
    suspend fun getAllProducts():Response<Products>
    @GET("products/{productId}")//get product by id
    suspend fun getProductById(@Path("productId") productId:String):Response<ProductsItem>
    @GET("products/categories")//get categories
    suspend fun getAllCategories():Response<Categories>



}