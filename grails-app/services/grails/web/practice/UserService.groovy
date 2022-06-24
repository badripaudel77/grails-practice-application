package grails.web.practice

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def serviceMethod() {
    }

    def registerUser(User user) {
        try {
            def existingUser = getUser(user.email)
            if(existingUser == null) {
                user.save()
                println "user created ..."
                return true
            }
            else  {
                println "user ${user.email} already exists."
                return false
            }
        }
        catch (Exception e) {
            e.printStackTrace()
            return false
        }
        return false
    }

    def getUser(String email) {
        User.findByEmail(email)
    }
}
