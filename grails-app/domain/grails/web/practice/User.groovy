package grails.web.practice

class User {
    String email
    String password

    static constraints = {
        email blank: false, unique: true, email: true
        password blank: false
    }

    static mapping = {
        table '`users`'
        password column: '`password`'
        email column: '`username`'
    }

}
