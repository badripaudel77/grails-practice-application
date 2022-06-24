package utils

class Country {

    String name
    String region
    String area
    String population
    Boolean isLandlocked
    Country(name, region, area, population, isLandlocked) {
        this.name = name
        this.region = region
        this.area = area
        this.population = population
        this.isLandlocked = isLandlocked
    }
}
