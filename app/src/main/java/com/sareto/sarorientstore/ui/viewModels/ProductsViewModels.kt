package com.sareto.sarorientstore.ui.viewModels

import androidx.lifecycle.ViewModel
import com.sareto.sarorientstore.data.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModels
@Inject constructor(private val productsRepository:ProductsRepository):ViewModel(){
}