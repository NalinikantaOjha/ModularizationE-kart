package com.example.common

import android.util.Log
import com.google.common.truth.Truth.assertThat
import org.junit.Test
class ResponseHandlerTest {
    private val responseHandler: ResponseHandler = ResponseHandler()

    @Test
    fun getErrorMessageNotFound(){
        val message= responseHandler.getErrorMessage(404)
        assertThat(message).isEqualTo("Not found")
    }
    @Test
    fun getErrorMessageUnauthorised(){
        val message= responseHandler.getErrorMessage(401)
        assertThat(message).isEqualTo("Unauthorised")

    }
    @Test
    fun getErrorMessageServerError(){
        val message= responseHandler.getErrorMessage(500)
        assertThat(message).isEqualTo("Server Error")

    }
    @Test
    fun getErrorMessageConflictsFound(){
        val message= responseHandler.getErrorMessage(409)
        assertThat(message).isEqualTo("Conflicts found")

    }
    @Test
    fun getErrorMessageSomethingWentWrong(){
        val message= responseHandler.getErrorMessage(40)
        assertThat(message).isEqualTo("Something went wrong")

    }

}