package com.io2c.httpproxyserver.auth;

import com.io2c.httpproxyserver.HttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class BasicUserAuthentication implements IUserAuthentication {

    private final Properties configuration;
    private final Logger LOG = LoggerFactory.getLogger(BasicUserAuthentication.class);

    public BasicUserAuthentication(Properties configuration){
        this.configuration = configuration;
    }

    @Override
    public boolean isValidUser(String username, String token) {
        String password = configuration.getProperty("auth." + username);
        if (password == null || !password.equals(token)) {
            LOG.error("invalid user credentials provided");
            return false;
        }
        return true;
    }
}
