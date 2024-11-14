package be.athumi.strategies

interface ExpirationStrategy {
    fun calculateNewExpiration(expiresInYears: Int): Int
}