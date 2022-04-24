package hu.bme.aut.android.lotrappandroid.network

import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit

@RunWith(JUnit4::class)
abstract class ApiAbstract<T> {

    lateinit var mockWebServer: MockWebServer

    @Before
    fun mockServer(){
    }

    @After
    fun stopServer(){
    }

    fun createService(clazz: Class<T>): T{
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(clazz)
    }
}