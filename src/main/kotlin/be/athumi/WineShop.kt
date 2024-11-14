package be.athumi

class WineShop(var items: List<Wine>) {
    fun next() {
        // Wine Shop logic
        for (wine in items) {
            if (wine.name == "Wine brewed by Alexander the Great") {
                //do nothing
            } else {
                wine.expiresInYears -= 1
                if (wine.name.contains("Conservato")) {
                    incrementPriceForAgingWine(wine)
                } else if (wine.name.startsWith("Event")) {
                    incrementPriceForEventWine(wine)
                } else if (wine.name.contains("Eco")) {
                    decrementPriceForEcoWine(wine)
                } else {
                    decrementPriceForStandardWine(wine)
                }
            }
            if (wine.price < 0) {
                wine.price = 0
            }
        }
    }

    private fun decrementPriceForStandardWine(wine: Wine) {
        wine.price -= 1
        if (wine.expiresInYears < 0) {
            wine.price -= 1
        }
    }

    private fun decrementPriceForEcoWine(wine: Wine) {
        wine.price -= 2
        if (wine.expiresInYears < 0) {
            wine.price -= 2
        }
    }

    private fun incrementPriceForAgingWine(wine: Wine) {
        if (wine.expiresInYears < 0) {
            wine.price = incrementPriceForAgingWine(wine, 2)
        } else {
            wine.price = incrementPriceForAgingWine(wine, 1)
        }
    }

    private fun incrementPriceForEventWine(wine: Wine) {
        wine.price = incrementPriceForAgingWine(wine, 1)
        if (wine.expiresInYears < 7) {
            wine.price = incrementPriceForAgingWine(wine, 1)
        }
        if (wine.expiresInYears < 2) {
            wine.price = incrementPriceForAgingWine(wine, 2)
        }
        if (wine.expiresInYears < 0) {
            wine.price = 0
        }
    }

    private fun incrementPriceForAgingWine(wine: Wine, increment: Int): Int {
        //TODO: check what to do if the price is already bigger than 100 to start with
        if (wine.price > 100) {
            return wine.price
        }
        return (wine.price + increment).coerceAtMost(100)
    }
}