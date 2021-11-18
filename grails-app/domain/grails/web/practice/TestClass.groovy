package grails.web.practice

class TestClass {

    String name
    Integer age

    static constraints = {
        age blank: false, nullable: false
        name blank: false, nullable: false
    }
}
