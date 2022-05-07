package hu.bme.aut.android.lotrappandroid.persistence

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import hu.bme.aut.android.lotrappandroid.persistence.MockTestUtil.mockCharacterList
import hu.bme.aut.android.lotrappandroid.persistence.MockTestUtil.testCharacterList
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
    fun characterListTest() = runBlocking{

        //insert list into db
        val mockDataList = testCharacterList()
        characterDao.insertCharacterList(mockDataList)

        //test leading inserted list from db
        val loadFromDB = characterDao.getCharacterList()
        assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        //test if db contains right data
        val mockData = LotRCharacter("1", "h", "r", "g", "b", "s", "d", "r", "h", "n", "w")
        assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))

        //test getting character by id from db
        val characterFromDB = characterDao.getCharacter("1")
        assertThat(characterFromDB.toString(), `is`(mockData.toString()))

        //test updating character
        val mockData2 = LotRCharacter("1", "mh", "mr", "mg", "mb", "ms", "md", "mr", "mh", "mn", "mw")
        characterDao.updateCharacterList(mockData2)
        val characterFromDB2 = characterDao.getCharacter("1")
        assertThat(characterFromDB2.toString(), `is`(mockData2.toString()))

    }

}