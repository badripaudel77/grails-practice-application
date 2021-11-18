package grails.web.practice

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


class MyControllerSpec extends Specification implements ControllerUnitTest<MyController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test index method"() {
        when :
        controller.index()

        then:
        response.redirectedUrl == '/my/sayHello'
    }

    void "test sayHello"() {
        given :
        def name = "David"

        when :
        controller.sayHello(name)

        then :
        response.text == "Hello David!"
    }

//    void "count no of registered people"(){
//        when :
//        def noOfRegisteredUsers = controller.countPeople()
//        then :
//        noOfRegisteredUsers == 2
//    }

    void "check whether the provided email is valid or not"() {
        given :
        String email = "doe@event.se"

        when :
        boolean isEmailValid = controller.isEmailValid(email)

        then :
         isEmailValid == true
    }

   void "see if email is valid directly using util class"() {
       given :
       String email = "john@john.com"

       when:
       boolean isEmailValid = controller.isEmailValid(email)

       then :
       isEmailValid == true
   }

   void "Test Map Rendering"() {
       given :
       def title = "Hello World"
       def author = "John Doe"

       when :
       def model = controller.renderMap(title, author)

       then:
       model.title == title && model.author == author
   }

    // Test User Domain : VALID test
    void "test valid user object"() {
        given :
        def user = new User(email:  "email@gmail.io", password:  "password")
        user.validate() // this is causing problem

        when :
         controller.handleUser(user)
       then :
       response.text == "Good"
    }

    // Test User Domain : INVALID test
    void "test invalid user object"() {
        given :
        def user = new User(email: "email@gmail.io", password : "")
        user.validate()

        when :
        controller.handleUser(user)

        then :
        response.text == "Good"
    }

    // Test TestClass Domain
    void "test valid TestClass object"() {
        given :
        def testClass = new TestClass(age: 24, name: "John Doe")
        testClass.validate()

        when :
        controller.testTheTestClass(testClass)

        then :
        response.text == "Fine"
    }
}
