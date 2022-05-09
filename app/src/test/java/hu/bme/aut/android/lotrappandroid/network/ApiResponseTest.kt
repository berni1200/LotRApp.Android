package hu.bme.aut.android.lotrappandroid.network

import com.nhaarman.mockitokotlin2.isNotNull
import hu.bme.aut.android.lotrappandroid.network.dto.mapToCharacterList
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.File

@RunWith(JUnit4::class)
class ApiResponseTest : ApiAbstract<LotRService>(){

    @Test
    fun success(){
        val apiResponse = ApiResponse.Success("foo")
        assertThat(apiResponse.data, `is`("foo"))
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

    @Test
    fun fetchCharacterListTest(){
        runBlocking {
            enqueueResponse("LotRCharacterEx.json")
            val responseBody = service.fetchCharacterList()
            assertThat(responseBody, `is`(notNullValue()))
            val request = mockWebServer.takeRequest()
            assertThat(request.path, `is`("/character"))
        }
    }

    @Test
    fun fetchCharacterTest(){
        runBlocking {
            enqueueResponse("LotRCharacterEx.json")
            val responseBody = service.fetchCharacterById("5cd99d4bde30eff6ebccfbc2")
            assertThat(responseBody, `is`(notNullValue()))
            val request = mockWebServer.takeRequest()
            assertThat(request.path, `is`("/character/5cd99d4bde30eff6ebccfbc2"))
        }
    }



}