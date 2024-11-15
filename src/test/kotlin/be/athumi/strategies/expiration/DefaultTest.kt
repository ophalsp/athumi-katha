package be.athumi.strategies.expiration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefaultTest {

    private val strategy = Default()

    @Test
    fun `test default strategy with positive expiration as a start`() {
        assertThat(strategy.calculateNewExpiration(2)).isEqualTo(1)
    }


    @Test
    fun `test default strategy with zero as a start`() {
        assertThat(strategy.calculateNewExpiration(0)).isEqualTo(-1)
    }

    @Test
    fun `test default strategy with negative expiration as a start`() {
        assertThat(strategy.calculateNewExpiration(-2)).isEqualTo(-3)
    }
}