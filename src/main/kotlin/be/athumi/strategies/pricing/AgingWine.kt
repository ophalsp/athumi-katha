package be.athumi.strategies.pricing

import be.athumi.strategies.PricingStrategy

class AgingWine : PricingStrategy {
    override fun calculateNewPrice(price: Int, expiresInYears: Int): Int {
        if (price > 100) {
            return price
        }
        return if (expiresInYears < 0) {
            (price + 2).coerceAtMost(100)
        } else {
            (price + 1).coerceAtMost(100)
        }
    }
}