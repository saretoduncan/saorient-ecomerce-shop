package com.sareto.sarorientstore.data.network.apiServices

import com.sareto.sarorientstore.data.models.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface IProductsService {
    @Headers("Content-Type:application/json")
    @GET("products")//get all products
    suspend fun getAllProducts():Response<Products>


}