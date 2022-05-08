package hu.bme.aut.android.lotrappandroid.network

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiResponseTest {

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

}