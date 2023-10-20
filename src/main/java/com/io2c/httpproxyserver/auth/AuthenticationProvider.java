package com.io2c.httpproxyserver.auth;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationProvider {
    private List<IUserAuthentication> authenticationProviders = new ArrayList<>();

    public boolean isValidUser(String username, String token) {
        boolean isValid = true;
        for(IUserAuthentication provider: authenticationProviders) {
            isValid = provider.isValidUser(username, token);

            if(isValid) {
                break;
            }
        }
        return isValid;
    }

    public void addAuthProvider(IUserAuthentication provider) {
        authenticationProviders.add(provider);
    }

    public void addAuthProvider(List<IUserAuthentication> providers) {
        authenticationProviders.addAll(providers);
    }
}
