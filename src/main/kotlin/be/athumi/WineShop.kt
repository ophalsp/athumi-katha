package be.athumi

class WineShop(var items: List<Wine>) {
    private val strategyFactory = StrategyFactory()

    fun next() {
        // Wine Shop logic
        for (wine in items) {
            val expirationStrategy = strategyFactory.createExpirationStrategy(wine)
            val pricingStrategy = strategyFactory.createPricingStrategy(wine)

            wine.expiresInYears = expirationStrategy.calculateNewExpiration(wine.expiresInYears)
            wine.price = pricingStrategy.calculateNewPrice(wine.price, wine.expiresInYears)
        }
    }
}