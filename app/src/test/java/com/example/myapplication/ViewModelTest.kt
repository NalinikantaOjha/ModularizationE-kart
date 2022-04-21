package com.example.myapplication

import com.example.common.Resource
import com.example.common.ResponseHandler
import com.example.common.Status
import com.example.data.network.apiservice.ApiService
import com.example.data.repository.ProjectRepository
import com.example.myapplication.viewmodel.ProjectViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.net.SocketException
import com.example.data.network.model.Response
import com.example.data.network.model.ResponseItem
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals

class ViewModelTest {
    @MockK
    lateinit var repository: ProjectRepository
    private lateinit var viewModel:ProjectViewModel
    @MockK
    lateinit var  product: Response
    @MockK
    lateinit var  productList:MutableList<ResponseItem>


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel= ProjectViewModel(repository)
      }



    @Test
    fun getProducts_verifyingFunctionCall(){
        coEvery {
            repository.getProducts()
        } returns Unit
        viewModel.getProducts()
        coVerify { repository.getProducts() }
    }



}





























//      //  viewModel = spyk(ProjectViewModel(repository))