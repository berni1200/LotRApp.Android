package hu.bme.aut.android.lotrappandroid.persistence

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import hu.bme.aut.android.lotrappandroid.persistence.MockTestUtil.mockCharacterList
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [26])
class CharacterDaoTest : LocalDatabase() {

    private lateinit var characterDao: CharacterDao

    @Before
    fun init(){
        characterDao = dataBase.characterDao()
    }

    @Test
    fun loadCharacterListTest() = runBlocking{
        val mockDataList = mockCharacterList()
        characterDao.insertCharacterList(mockDataList)

        val loadFromDB = characterDao.getCharacterList()
        assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = mock(LotRCharacter::class.java)
        assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }

}