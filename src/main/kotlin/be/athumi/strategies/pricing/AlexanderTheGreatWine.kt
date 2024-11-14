package be.athumi.strategies.pricing

import be.athumi.strategies.PricingStrategy

class AlexanderTheGreatWine : PricingStrategy {
    override fun calculateNewPrice(price: Int, expiresInYears: Int): Int {
        if (price < 0) {
            return 0
        }
        return price
    }
}