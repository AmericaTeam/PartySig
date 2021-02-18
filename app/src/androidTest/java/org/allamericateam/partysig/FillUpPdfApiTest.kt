package org.allamericateam.partysig

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.allamericateam.partysig.interfaces.AnvilFillPdfAPI
import org.allamericateam.partysig.pojo.FillUpFormRequest
import org.allamericateam.partysig.utills.Authenticate
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.CountDownLatch
import kotlin.coroutines.suspendCoroutine

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class FillUpPdfApiTest {

    lateinit var baseUrl : String


    @Test
    fun fillUpPdfTest(){

        val syncObj : Any?

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val originalKey = appContext.getString(R.string.anvil_api_key) + ":"

        val encodedToken = Base64.getEncoder().encode(originalKey.toByteArray())
        val decodedToken = Base64.getDecoder().decode(encodedToken).decodeToString()

        baseUrl = appContext.getString(R.string.pdf_gen_base_url) + "/api/v1/fill/"
        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var fillUpPdfApi : AnvilFillPdfAPI = retrofit.create(AnvilFillPdfAPI::class.java)
        val fileName = "E8xUEB2g3kRCkyFQOdre.pdf"
        var data = "{\n" +
                "    \"Location\": \"San Jose\",\n" +
                "    \"firstchoice\": \"Sat. 4:00 p.m.\",\n" +
                "    \"secondchoice\": \"2nd_choice\",\n" +
                "    \"teamName\": \"team_name\",\n" +
                "    \"captainName\": {\n" +
                "      \"firstName\": \"Robin\",\n" +
                "      \"mi\": \"W\",\n" +
                "      \"lastName\": \"Smith\"\n" +
                "    },\n" +
                "    \"captainRaiting\": 12345,\n" +
                "    \"captainCardNumber\": \"CardNumber\",\n" +
                "    \"captainPhoneNumber\": {\n" +
                "      \"num\": \"5554443333\",\n" +
                "      \"region\": \"US\",\n" +
                "      \"baseRegion\": \"US\"\n" +
                "    },\n" +
                "    \"captainEmail\": \"testy@example.com\",\n" +
                "    \"teammateName\": {\n" +
                "      \"firstName\": \"Robin\",\n" +
                "      \"mi\": \"W\",\n" +
                "      \"lastName\": \"Smith\"\n" +
                "    },\n" +
                "    \"teammateRaiting\": 12345,\n" +
                "    \"teammateCardNumber\": \"CardNumber\",\n" +
                "    \"teammatePhoneNumber\": {\n" +
                "      \"num\": \"5554443333\",\n" +
                "      \"region\": \"US\",\n" +
                "      \"baseRegion\": \"US\"\n" +
                "    },\n" +
                "    \"teammateEmail\": \"testy@example.com\"\n" +
                "  }"
        var signal = CountDownLatch(1)



        var call : Call<ResponseBody> = fillUpPdfApi.fillUpPdf(Authenticate(originalKey).encodedToken,
        fileName, FillUpFormRequest(data, 10, "#a824e8", "ADL SPRING 2020 ENTRY FORM"))





        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                print(response);
                Assert.assertNotNull(response)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                t.printStackTrace()
                Assert.assertNotNull(t)
            }
        })

        try {
            signal.await();
        }catch (e : InterruptedException){
            e.printStackTrace()
        }

        Assert.assertEquals(originalKey, decodedToken)
    }

}