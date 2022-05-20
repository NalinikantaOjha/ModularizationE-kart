package com.example.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.Resource
import com.example.common.ResponseHandler
import com.example.data.network.apiservice.ApiService
import com.example.data.network.model.Response
import com.example.data.network.model.ResponseItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class  ProjectRepository @Inject constructor (private val apiService: ApiService){
    val  responseliveData: LiveData<Resource<List<ResponseItem>>> get()=responseClass
    private val responseClass= MutableLiveData<Resource<List<ResponseItem>>>()
    private val responseHandler: ResponseHandler = ResponseHandler()
    fun getProducts(a:String){
         CoroutineScope(Dispatchers.IO).launch{
           try {
               val response: Response = apiService.getProducts()
               responseClass.postValue(responseHandler.handleSuccess(response))
           }  catch (e:Exception){
               responseClass.postValue(responseHandler.handleException(e))
           }
         }

    }
}