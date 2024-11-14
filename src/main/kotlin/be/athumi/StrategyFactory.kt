package be.athumi

import be.athumi.strategies.ExpirationStrategy
import be.athumi.strategies.PricingStrategy
import be.athumi.strategies.expiration.Default
import be.athumi.strategies.expiration.NoExpiration
import be.athumi.strategies.pricing.AgingWine
import be.athumi.strategies.pricing.AlexanderTheGreatWine
import be.athumi.strategies.pricing.EcoWine
import be.athumi.strategies.pricing.EventWine
import be.athumi.strategies.pricing.StandardWine

class StrategyFactory {

    fun createPricingStrategy(wine: Wine): PricingStrategy {
        return if (wine.name == "Wine brewed by Alexander the Great") {
            AlexanderTheGreatWine()
        } else if (wine.name.contains("Conservato")) {
            AgingWine()
        } else if (wine.name.startsWith("Event")) {
            EventWine()
        } else {
            StandardWine()
        }
    }

    fun createExpirationStrategy(wine: Wine): ExpirationStrategy {
        return if (wine.name == "Wine brewed by Alexander the Great") {
            NoExpiration()
        } else {
            Default()
        }
    }

}