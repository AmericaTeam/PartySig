package org.allamericateam.partysig.interfaces

import org.allamericateam.partysig.models.CurrentUserResponse
import org.allamericateam.partysig.pojo.EtchEsignRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface EtchEsignApi {

    @Headers( "Content-Type:application/json" )
    @POST("/")
    fun auth(
            @Header("Authorization") authorization: String,
            @Body requestBody : EtchEsignRequest
    ) : Call<CurrentUserResponse>
}