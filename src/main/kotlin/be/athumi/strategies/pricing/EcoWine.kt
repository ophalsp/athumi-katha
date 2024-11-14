package be.athumi.strategies.pricing

import be.athumi.strategies.PricingStrategy

class EcoWine : PricingStrategy {
    override fun calculateNewPrice(price: Int, expiresInYears: Int): Int {
        var newPrice = price - 2
        if (expiresInYears < 0) {
            newPrice -= 2
        }
        if (newPrice < 0) {
            newPrice = 0
        }
        return newPrice
    }
}