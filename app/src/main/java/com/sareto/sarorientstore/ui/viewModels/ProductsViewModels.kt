package com.sareto.sarorientstore.ui.viewModels

import android.content.res.loader.ResourcesLoader
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sareto.sarorientstore.data.models.Categories
import com.sareto.sarorientstore.data.models.Products
import com.sareto.sarorientstore.data.models.ProductsItem
import com.sareto.sarorientstore.data.repositories.ProductsRepository
import com.sareto.sarorientstore.data.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductsViewModels
@Inject constructor(private val productsRepository:ProductsRepository):ViewModel(){
    private val _productsResponse = MutableLiveData<Resource<Products>>()// get all products response
    val productsResponse:LiveData<Resource<Products>>
    get()= _productsResponse// products response live data
    private val _productByIdResponse = MutableLiveData<Resource<ProductsItem>>()//get product by id response
    val productByIdResponse:LiveData<Resource<ProductsItem>>
    get()=_productByIdResponse//get product by livedata
    private val _categoryResponse =MutableLiveData<Resource<Categories>>()// get all categories
    val categoriesResponse:LiveData<Resource<Categories>>
    get() = _categoryResponse//get all categories
    private val _productsByCategory = MutableLiveData<Resource<Products>>()
    val productsByCategory:LiveData<Resource<Products>>
    get()= _productsByCategory
    init {
        getAllProducts()//get all products
    }
    //getAllProducts
    fun getAllProducts()= viewModelScope.launch {
        _productsResponse.postValue(Resource.Loading(null))
       productsRepository.getAllProducts().let {
           if(it.isSuccessful){
               _productsResponse.postValue(Resource.Success(it.body()!!))
           }else _productsResponse.postValue(Resource.Error(it.errorBody().toString(), null))
       }
    }
    //get products by id
    fun getProductById(id:String)= viewModelScope.launch {
        _productByIdResponse.postValue(Resource.Loading(null))
        productsRepository.getProductById(id).let {
            if(it.isSuccessful) _productByIdResponse.postValue(Resource.Success(it.body()!!))
            else _productByIdResponse.postValue(Resource.Error(it.errorBody().toString(), null))
        }
    }
    //get all categories
    fun getCategories() = viewModelScope.launch {
        _categoryResponse.postValue(Resource.Loading(null))
        productsRepository.getAllCategories().let {
            if(it.isSuccessful)_categoryResponse.postValue(Resource.Success(it.body()!!))
            else _categoryResponse.postValue(Resource.Error(it.errorBody().toString(), null))
        }
    }
    //get products by category
    fun getProductsByCategory(categoryName:String)=viewModelScope.launch {
        _productsResponse.postValue(Resource.Loading(null))
        productsRepository.getProductsByCategory(categoryName).let {
            if(it.isSuccessful) _productsByCategory.postValue(Resource.Success(it.body()!!))
            else _productsResponse.postValue(Resource.Error(it.errorBody().toString(), null))
        }
    }

}