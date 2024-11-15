package be.athumi.strategies.pricing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StandardWineTest {

    private val strategy = StandardWine()

    @Test
    fun `test standard wine strategy with expired wine`() {
        assertThat(strategy.calculateNewPrice(3, -1)).isEqualTo(1)
        assertThat(strategy.calculateNewPrice(1, -1)).isEqualTo(0)
    }

    @Test
    fun `test standard wine strategy with non expired wine`() {
        assertThat(strategy.calculateNewPrice(2, 0)).isEqualTo(1)
        assertThat(strategy.calculateNewPrice(0, 0)).isEqualTo(0)
    }

    @Test
    fun `test standard wine strategy with negative priced wine`() {
        assertThat(strategy.calculateNewPrice(-2, 0)).isEqualTo(0)
        assertThat(strategy.calculateNewPrice(-2, -1)).isEqualTo(0)
    }
}