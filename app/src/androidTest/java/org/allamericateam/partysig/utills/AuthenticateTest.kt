package org.allamericateam.partysig.utills

import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase
import org.allamericateam.partysig.R

class AuthenticateTest : TestCase() {

    fun testGetEncodedToken() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val originalKey = appContext.getString(R.string.anvil_api_key) + ":"
        val encoded = Authenticate(originalKey).encodedToken
        print(encoded)
    }
}