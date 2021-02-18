package org.allamericateam.partysig

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class APITest {

    @Test
    fun apiBase64EncodeTest(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val originalKey = appContext.getString(R.string.anvil_api_key) + ":"

        val encodedToken = Base64.getEncoder().encode(originalKey.toByteArray())
        val decodedToken = Base64.getDecoder().decode(encodedToken).decodeToString()
        Assert.assertEquals(originalKey, decodedToken)
    }

}