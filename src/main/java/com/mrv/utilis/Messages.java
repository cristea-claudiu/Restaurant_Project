package com.mrv.utilis;

public class Messages {


    //SECURITY MESSAGES
    public static final String USERNAME_NOT_FOUND="User with user name ' %s ' not found!";
    public static final String JWT_TOKEN_EXPIRED="JWT token is expired :{}";
    public static final String JWT_TOKEN_UNSUPPORTED="JWT token is unsupported :{}";
    public static final String JWT_TOKEN_INVALID="JWT token is invalid :{}";
    public static final String JWT_SIGNATURE_INVALID="JWT Signature  is invalid :{}";
    public static final String JWT_EMPTY="JWT  is empty :{}";
    public static final String CANNOT_SET_USER="Cannot set user authentication";
    public static final String UNAUTHORIZED_ERROR="Unauthorized error : {}";

    //UserRole MESSAGES
    public static final String ROLE_NOT_FOUND="Role Not Found";
    public static final String ROLE_ALREADY_EXIST="Role already exists";
    //BASE USER REQUEST
          //USERNAME
    public static final String BASE_USER_ENTER_USERNAME="please enter your username";
    public static final String USERNAME_ALREADY_REGISTERED="User already registered";
    public static final String BASE_USER_SIZE_USERNAME="Your username should be at least 4 characters";
    public static final String BASE_USER_PATTERN_USERNAME="Your username must consist of the characters .";
          //PASSWORD
    public static final String BASE_USER_ENTER_PASSWORD="please enter your password";
    public static final String BASE_USER_SIZE_MIN_PASSWORD="Your password should be at least 8 characters";
    public static final String BASE_USER_SIZE_MAX_PASSWORD="Your password should be max 60 characters";
    public static final String BASE_USER_PATTERN_PASSWORD="Your password must consist of the characters .";
         //EMAIL
    public static final String BASE_USER_ENTER_EMAIL="please enter your email";
    public static final String BASE_USER_SIZE_EMAIL="Your email should be at least 5 characters";
    public static final String BASE_USER_VALIDATION_EMAIL="Your email must consist of the characters .";


}
