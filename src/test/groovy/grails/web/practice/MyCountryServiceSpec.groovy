package grails.web.practice

import grails.testing.services.ServiceUnitTest
import grails.web.practice.MyCountryService
import spock.lang.Specification

class MyCountryServiceSpec extends Specification implements ServiceUnitTest<MyCountryService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
