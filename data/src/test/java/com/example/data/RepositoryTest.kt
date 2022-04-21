package com.example.data

import com.example.data.network.apiservice.ApiService
import com.example.data.network.model.Response
import com.example.data.network.model.ResponseItem
import com.example.data.repository.ProjectRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class RepositoryTest {

    private lateinit var repository: ProjectRepository
    @MockK
    lateinit var product: Response
    @MockK
    lateinit var apiService: ApiService
    @MockK
    var productlist= mutableListOf<ResponseItem>()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
       // coEvery { dao.getAllProduct().value } returns productlist
        repository= ProjectRepository(apiService)

    }
    @Test
    fun getProducts(){
        val rep= repository.getProducts()
        assertThat(rep).isNotNull()
    }
}