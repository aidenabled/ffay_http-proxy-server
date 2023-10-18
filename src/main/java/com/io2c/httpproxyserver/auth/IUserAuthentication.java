package com.io2c.httpproxyserver.auth;

public interface IUserAuthentication {
    boolean isValidUser(String username, String token);
}
