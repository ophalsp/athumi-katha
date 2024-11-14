package be.athumi.strategies.pricing

import be.athumi.strategies.PricingStrategy

class StandardWine : PricingStrategy {
    override fun calculateNewPrice(price: Int, expiresInYears: Int): Int {
        var newPrice = price - 1
        if (expiresInYears < 0) {
            newPrice -= 1
        }

        if (newPrice < 0) {
            newPrice = 0
        }
        return newPrice
    }

}