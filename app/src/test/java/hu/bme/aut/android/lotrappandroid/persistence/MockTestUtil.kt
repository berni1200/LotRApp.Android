package hu.bme.aut.android.lotrappandroid.persistence

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import org.mockito.Mockito.mock

object MockTestUtil {
    fun mockCharacterList() = listOf(mock(LotRCharacter::class.java))
}