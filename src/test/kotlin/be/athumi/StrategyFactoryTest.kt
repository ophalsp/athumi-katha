package be.athumi

import be.athumi.strategies.expiration.Default
import be.athumi.strategies.expiration.NoExpiration
import be.athumi.strategies.pricing.AgingWine
import be.athumi.strategies.pricing.AlexanderTheGreatWine
import be.athumi.strategies.pricing.EcoWine
import be.athumi.strategies.pricing.EventWine
import be.athumi.strategies.pricing.StandardWine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StrategyFactoryTest {

    private val factory = StrategyFactory()

    @Test
    fun `test expiry factory creation`() {
        assertThat(factory.createExpirationStrategy(Wine("Standard", 1, 1))).isExactlyInstanceOf(Default::class.java)
        assertThat(factory.createExpirationStrategy(Wine("Eco", 1, 1))).isExactlyInstanceOf(Default::class.java)
        assertThat(factory.createExpirationStrategy(Wine("Something irrelevant", 1, 1))).isExactlyInstanceOf(Default::class.java)
        assertThat(factory.createExpirationStrategy(Wine("Wine brewed by Alexander the Great", 1, 1))).isExactlyInstanceOf(NoExpiration::class.java)
    }

    @Test
    fun `test pricing factory creation`() {
        assertThat(factory.createPricingStrategy(Wine("Standard", 1, 1))).isExactlyInstanceOf(StandardWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Eco Brilliant Wine", 1, 1))).isExactlyInstanceOf(EcoWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Another Eco Wine", 1, 1))).isExactlyInstanceOf(EcoWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Wine brewed by Alexander the Great", 1, 1))).isExactlyInstanceOf(AlexanderTheGreatWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Bourgogne Conservato", 1, 1))).isExactlyInstanceOf(AgingWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Bourdeaux Conservato", 1, 1))).isExactlyInstanceOf(AgingWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Conservato ECO", 1, 1))).isExactlyInstanceOf(AgingWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Event Wine", 1, 1))).isExactlyInstanceOf(EventWine::class.java)
        assertThat(factory.createPricingStrategy(Wine("Another Event Wine", 1, 1))).isExactlyInstanceOf(StandardWine::class.java)
    }
}