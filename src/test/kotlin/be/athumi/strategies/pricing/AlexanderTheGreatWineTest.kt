package be.athumi.strategies.pricing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AlexanderTheGreatWineTest {

    private val strategy = AlexanderTheGreatWine()

    @Test
    fun `test alexander the great wine strategy with positive wine price`() {
        assertThat(strategy.calculateNewPrice(-1, -1)).isEqualTo(0)
        assertThat(strategy.calculateNewPrice(-1, 0)).isEqualTo(0)
        assertThat(strategy.calculateNewPrice(-1, 1)).isEqualTo(0)
    }

    @Test
    fun `test alexander the great wine strategy with negative wine price`() {
        assertThat(strategy.calculateNewPrice(3, -1)).isEqualTo(3)
        assertThat(strategy.calculateNewPrice(3, 0)).isEqualTo(3)
        assertThat(strategy.calculateNewPrice(3, 1)).isEqualTo(3)
    }
}