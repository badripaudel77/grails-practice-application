package grails.web.practice

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestClassSpec extends Specification implements DomainUnitTest<TestClass> {

    def setup() {
    }

    def cleanup() {
    }

    void "test that name shouldn't be blank" () {
        given :
        def name = ""
        def age = 0

        when : 'name is blank'
        def testClass = new TestClass(name : name, age : age)

        then : 'test should fail'
        !testClass.validate()
    }

}
