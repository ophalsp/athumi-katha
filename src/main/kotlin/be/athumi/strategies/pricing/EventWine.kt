package be.athumi.strategies.pricing

import be.athumi.strategies.PricingStrategy

class EventWine : PricingStrategy {
    override fun calculateNewPrice(price: Int, expiresInYears: Int): Int {
        if (expiresInYears < 0) {
            return 0
        }
        var newPrice = incrementPrice(price, 1)
        if (expiresInYears < 7) {
            newPrice = incrementPrice(newPrice, 1)
        }
        if (expiresInYears < 2) {
            newPrice = incrementPrice(newPrice, 2)
        }
        return newPrice
    }

    private fun incrementPrice(price: Int, increment: Int): Int {
        return (price + increment).coerceAtMost(100)
    }
}