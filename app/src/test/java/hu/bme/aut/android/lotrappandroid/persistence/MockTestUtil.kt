package hu.bme.aut.android.lotrappandroid.persistence

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import org.mockito.Mockito.mock

object MockTestUtil {
    fun mockCharacterList() = listOf(mock(LotRCharacter::class.java))

    fun testCharacterList() : List<LotRCharacter>{
        val list = mutableListOf<LotRCharacter>()
        list.add(LotRCharacter("1", "h", "r", "g", "b", "s", "d", "r", "h", "n", "w"))
        list.add(LotRCharacter("2", "h", "r", "g", "b", "s", "d", "r", "h", "n", "w"))
        list.add(LotRCharacter("3", "h", "r", "g", "b", "s", "d", "r", "h", "n", "w"))
        list.add(LotRCharacter("4", "h", "r", "g", "b", "s", "d", "r", "h", "n", "w"))
        return list
    }
}