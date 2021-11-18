package grails.web.practice.interceptors

// import grails.plugin.springsecurity.SpringSecurityService


class LoggingInterceptor {

   // SpringSecurityService springSecurityService

    LoggingInterceptor() {
        matchAll()
    }
    boolean before() {
        // println "Before Interceptor in running ..." + springSecurityService.principal?  springSecurityService.principal.username : "USERNAME"
        println "Before ::: Interceptor is running ..."
        return true
    }

    boolean after() {
        println "After :::  Interceptor is running ..."
        return true
    }

    void afterView() {
        // no-op
    }
}
