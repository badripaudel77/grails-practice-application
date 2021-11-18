package grails.web.practice

import utils.EmailValidation

class MyController {

    def index() {
         redirect action : 'sayHello'
    }

    def sayHello(String name) {
        render "Hello ${name}!"
    }

    def countPeople() {
        render "No of registered users in this app is ${User.getCount()} as of ${new Date()}"
    }

    def renderMap(String title, String author) {
        [title : title, author : author]
    }

    def isEmailValid(String email) {
        boolean isEmailValid =  EmailValidation.isEmailValid(email)
        // to see on web rendering
//        if(isEmailValid) render "The Email ID ${email} is Valid Email"
//        else render "The Email ID ${email} isn't a valid email"
        return isEmailValid
    }

    def handleUser(User user) {
        if(user.hasErrors()) {
            render "Bad"
        }
//        if(user.password.equals("password")) {
//            render "Bad"
//        }
        else {
            render "Good"
        }
    }

    def testTheTestClass(TestClass testClass) {
        if(testClass.hasErrors()) {
            render "Error"
        }
        else {
            render "Fine"
        }
    }
}
