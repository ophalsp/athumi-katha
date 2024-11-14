package be.athumi

class WineShop(var items: List<Wine>) {
    fun next() {
        // Wine Shop logic
        for (wine in items) {
            if (wine.name == "Wine brewed by Alexander the Great") {
                if (wine.price < 0) {
                    wine.price = 0
                }
            } else {
                if (wine.name != "Bourdeaux Conservato" &&
                    wine.name != "Bourgogne Conservato" &&
                    !wine.name.startsWith("Event")
                ) {
                    if (wine.price > 0) {
                        wine.price -= 1
                    }
                } else {
                    if (wine.price < 100) {
                        wine.price = wine.price + 1

                        if (wine.name.startsWith("Event")) {
                            if (wine.expiresInYears < 8) {
                                if (wine.price < 100) {
                                    wine.price += 1
                                }
                            }

                            if (wine.expiresInYears < 3) {
                                if (wine.price < 100) {
                                    wine.price += 2
                                }
                            }
                        }
                    }
                }

                wine.expiresInYears -= 1


                if (wine.expiresInYears < 0) {
                    if (!wine.name.contains("Conservato")) {
                        if (!wine.name.contains("Event")) {
                            if (wine.price > 0) {
                                wine.price -= 1
                            }
                        } else {
                            wine.price = 0
                        }
                    } else {
                        if (wine.price < 100) {
                            wine.price += 1
                        }
                    }
                }

                if (wine.price < 0) {
                    wine.price = 0
                }
            }
        }
    }
}