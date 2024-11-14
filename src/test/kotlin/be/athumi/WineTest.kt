package be.athumi

import org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WineTest {
    @Test
    fun `tasting or testing wine`() {
        assertThat(Wine("name", 0, 0)).isNotNull
    }

    @Test
    fun `a shop without wine is no shop, is it`() {
        val shop = WineShop(listOf(Wine("name", 0, 0)))
        assertThat(shop).isNotNull
        shop.next()
        assertThat(shop).isNotNull
    }

    @Test
    fun testLegacyCode() {
        val wines = arrayOf(
            "Standard Wine", "Bourdeaux Conservato", "Bourgogne Conservato", "Another Standard Wine",
            "Wine brewed by Alexander the Great", "Event Wine", "Eco Brilliant Wine"
        )
        val winePrices = arrayOf(-1, 0, 7, 20, 99, 100)
        val wineExpiresInYears = arrayOf(-1, 0, 1, 2, 3, 5, 10, 15)
        verifyAllCombinations(
            { wineName, winePrice, wineExpiresIn ->
                val wine = Wine(wineName, winePrice, wineExpiresIn)
                val shop = WineShop(listOf(wine))
                shop.next()
                wine
            },
            wines,
            winePrices,
            wineExpiresInYears
        )
    }

}