package com.sareto.sarorientstore.data.network.apiHelpers.impl

import com.sareto.sarorientstore.data.models.Categories
import com.sareto.sarorientstore.data.models.Products
import com.sareto.sarorientstore.data.models.ProductsItem
import com.sareto.sarorientstore.data.network.apiHelpers.interfaces.IProductsServiceHelper
import com.sareto.sarorientstore.data.network.apiServices.IProductsService
import retrofit2.Response
import javax.inject.Inject

class ProductsHelperImpl
@Inject
constructor(private val productsService: IProductsService):IProductsServiceHelper{
    override suspend fun getAllProducts()= productsService.getAllProducts()

    override suspend fun getProductById(id: String)=productsService.getProductById(id)
    override suspend fun getAllCategories()=productsService.getAllCategories()

    override suspend fun getProductsByCategory(categoryName: String)=productsService.getProductsByCategory(categoryName)
}