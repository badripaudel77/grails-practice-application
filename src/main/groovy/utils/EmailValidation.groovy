package utils

import java.util.regex.Matcher
import java.util.regex.Pattern

class EmailValidation {
    static boolean isEmailValid(String email) {
        String regex = '^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$'
        Pattern pattern = Pattern.compile(regex)
        Matcher matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
