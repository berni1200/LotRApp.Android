package hu.bme.aut.android.lotrappandroid.network

import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response
import java.io.File
import java.io.FileReader
import java.nio.file.Files

@RunWith(JUnit4::class)
class ApiResponseTest : ApiAbstract<OkHttpClient>(){

    @Test
    fun success(){
        val apiResponse = ApiResponse.Success(1)
        assertThat(apiResponse.data, `is`(1))
    }

    @Test
    fun exception(){
        val exception = Exception("foo")
        val apiResponse = ApiResponse.Error(exception)
        assertThat(apiResponse.exception.message, `is`("foo"))
    }

    @Test
    fun successResponse(){
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(File("LotRCharacterEx.json").inputStream().readBytes().toString(Charsets.UTF_8))
            }
        }

    }

}