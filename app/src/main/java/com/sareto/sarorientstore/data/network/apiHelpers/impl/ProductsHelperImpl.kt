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
    override suspend fun getAllProducts()= productsService.getAllProducts()//get all products

    override suspend fun getProductById(id: String)=productsService.getProductById(id) //get products by id
    override suspend fun getAllCategories()=productsService.getAllCategories()//get all product categories

    override suspend fun getProductsByCategory(categoryName: String)=productsService.getProductsByCategory(categoryName)//get products by category
}