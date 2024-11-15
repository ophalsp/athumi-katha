package be.athumi.strategies.expiration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NoExpirationTest {

    private val strategy = NoExpiration()

    @Test
    fun `test no expiration strategy with positive expiration as a start`() {
        assertThat(strategy.calculateNewExpiration(2)).isEqualTo(2)
    }


    @Test
    fun `test no expiration strategy with zero as a start`() {
        assertThat(strategy.calculateNewExpiration(0)).isEqualTo(0)
    }

    @Test
    fun `test no expiration strategy with negative expiration as a start`() {
        assertThat(strategy.calculateNewExpiration(-2)).isEqualTo(-2)
    }
}