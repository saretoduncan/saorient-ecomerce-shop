package com.sareto.sarorientstore.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    init {
        getAllProducts()//get all products
    }
    fun getAllProducts()= viewModelScope.launch {
        _productsResponse.postValue(Resource.Loading(null))
       productsRepository.getAllProducts().let {
           if(it.isSuccessful){
               _productsResponse.postValue(Resource.Success(it.body()!!))
           }else _productsResponse.postValue(Resource.Error(it.errorBody().toString(), null))
       }
    }
    fun getProductById(id:String)= viewModelScope.launch {
        _productByIdResponse.postValue(Resource.Loading(null))
        productsRepository.getProductById(id).let {
            if(it.isSuccessful) _productByIdResponse.postValue(Resource.Success(it.body()!!))
            else _productByIdResponse.postValue(Resource.Error(it.errorBody().toString(), null))
        }
    }
}