package be.athumi.strategies.expiration

import be.athumi.strategies.ExpirationStrategy

class NoExpiration : ExpirationStrategy {
    override fun calculateNewExpiration(expiresInYears: Int): Int {
        return expiresInYears
    }
}