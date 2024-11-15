package be.athumi.strategies.pricing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EventWineTest {

    private val strategy = EventWine()

    @Test
    fun `test aging wine strategy with expired wine`() {
        assertThat(strategy.calculateNewPrice(2, -1)).isEqualTo(0)
    }

    @Test
    fun `test aging wine strategy with wine expiring in more than 7 years`() {
        assertThat(strategy.calculateNewPrice(10, 7)).isEqualTo(11)
        assertThat(strategy.calculateNewPrice(10, 8)).isEqualTo(11)
    }
    @Test
    fun `test aging wine strategy with wine expiring in less than 7 years but more than 2 years`() {
        assertThat(strategy.calculateNewPrice(10, 6)).isEqualTo(12)
        assertThat(strategy.calculateNewPrice(10, 5)).isEqualTo(12)
        assertThat(strategy.calculateNewPrice(10, 4)).isEqualTo(12)
        assertThat(strategy.calculateNewPrice(10, 3)).isEqualTo(12)
        assertThat(strategy.calculateNewPrice(10, 2)).isEqualTo(12)
    }
    @Test
    fun `test aging wine strategy with wine expiring in less than 2 years`() {
        assertThat(strategy.calculateNewPrice(10, 1)).isEqualTo(14)
        assertThat(strategy.calculateNewPrice(10, 0)).isEqualTo(14)
    }
}