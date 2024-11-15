package be.athumi.strategies.pricing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AgingWineTest {

    private val strategy = AgingWine()

    @Test
    fun `test aging wine strategy with expired wine`() {
        assertThat(strategy.calculateNewPrice(2, -1)).isEqualTo(4)
    }

    @Test
    fun `test aging wine strategy with non expired wine`() {
        assertThat(strategy.calculateNewPrice(2, 0)).isEqualTo(3)
        assertThat(strategy.calculateNewPrice(2, 1)).isEqualTo(3)
    }
}