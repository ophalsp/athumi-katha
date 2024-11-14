package be.athumi.strategies

interface PricingStrategy {
    fun calculateNewPrice(price: Int, expiresInYears: Int): Int
}