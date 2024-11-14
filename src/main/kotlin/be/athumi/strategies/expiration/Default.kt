package be.athumi.strategies.expiration

import be.athumi.strategies.ExpirationStrategy

class Default : ExpirationStrategy {
    override fun calculateNewExpiration(expiresInYears: Int): Int {
        return expiresInYears - 1
    }
}