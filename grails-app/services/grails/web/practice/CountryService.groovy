package grails.web.practice

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import utils.Country

// REF : https://github.com/grails-plugins/grails-rest-client-builder

@Transactional
class CountryService {
    def serviceMethod() {

    }

    def fetchCountries() {
        //calling the API
        Country country
        def restBuilder = new RestBuilder()
        def response = restBuilder.get("https://restcountries.com/v3.1/all")
        def countriesDataAsJsonElement = response.json
        List<Country> countryList = []
        for (def countryJsonObject : countriesDataAsJsonElement) {
            country = new Country(countryJsonObject.name.common, countryJsonObject.region, countryJsonObject.area, countryJsonObject.population, countryJsonObject.landlocked)
            countryList.add(country)
        }
        println("data is found.... ")
        [countries : countryList, total : countryList.size()]
    }
}
