package org.allamericateam.partysig.interfaces

import org.allamericateam.partysig.models.CurrentUserResponse
import org.allamericateam.partysig.pojo.CurrentUserRequest
import retrofit2.Call
import retrofit2.http.*

interface AnvilCurrentUserAPI {


    @Headers( "Content-Type:application/json" )
    @POST("/")
    fun auth(
        @Header("Authorization") authorization: String,
        @Body requestBody : CurrentUserRequest
    ) : Call<CurrentUserResponse>
}