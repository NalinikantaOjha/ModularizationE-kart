package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.common.Resource
import com.example.data.network.model.ResponseItem
import com.example.data.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProjectViewModel @Inject constructor (val repository: ProjectRepository):ViewModel(){
    val  responseliveData: LiveData<Resource<List<ResponseItem>>> get()=repository.responseliveData
     fun getProducts(){
         repository.getProducts()

     }
}