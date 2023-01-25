package grails.web.practice

class UserController {

    def userService
    def myCountryService
    static allowedMethods = [save: "POST", create: "GET"]

    def index() {
         redirect action: "home", method: "GET"
       // forward(action : "home") redirects without issuing an HTTP call
    }
    def home() {
        if(session.getAttribute("username") == null) {
           redirect(uri : "/")
        }
    }

    def create() {
        respond new User(params)
    }

    def save(User user) {
        if (user.email == null || user.password == null) {
            flash.userNoteCreated = "Please provide some info"
            redirect action: "create", method: "GET"
        }
          else {
            def isUserCreated = userService.registerUser(user)
            if(!isUserCreated) {
                flash.userNoteCreated = "User ${user.email} already exists."
                redirect action: "create", method: "GET"
            }
            else {
                session.setAttribute("username", user.email)
                session.setAttribute("isLoggedIn", true)
                redirect action: "home", method: "GET"
            }
        }
    }

    def fetchCountries() {
        println("fetching countries from the API ....")
        myCountryService.fetchCountries()
    }
}
