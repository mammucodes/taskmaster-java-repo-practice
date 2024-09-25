package com.todo.taskmaster.conntroller;

import com.todo.taskmaster.exceptions.InvalidEmailPassed;
import com.todo.taskmaster.exceptions.InvalidPasswordException;
import com.todo.taskmaster.exceptions.NameInvalidException;
import com.todo.taskmaster.exceptions.NullEmailPassed;
import com.todo.taskmaster.userrequests.userCreateRequest;

import javax.naming.InvalidNameException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidations {

    private static final String GMAIL_REGEX ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$"; ;

    public void validateCreateUserRequest(userCreateRequest request) throws
             InvalidEmailPassed, NameInvalidException, InvalidPasswordException, NullEmailPassed {

        String name = request.getFullname();
        if (name == null||name.length() <6)
            throw new NameInvalidException("you passed null name it is invalid. please enter correct name and length should be grater than 6");
        if (request.getPassword() == null||request.getPassword().length()<5)
            throw new InvalidPasswordException("you passed  empty  password or  password length is less than 5 charcters;");

        String email = request.getEmail();
        if(email==null){
            throw new NullEmailPassed("you cannot pass email  null  ");
        }
        if (isValidGmail(request.getEmail())) {

            //  if(email.endsWith("gmail.com"))
            // System.out.println(email + " is a valid Gmail address.");
        } else
            throw new InvalidEmailPassed("entered invalid email .please enter correct email ending with @gmail.com");

    }

    public static boolean isValidGmail(String email) {
        Pattern pattern = Pattern.compile(GMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
