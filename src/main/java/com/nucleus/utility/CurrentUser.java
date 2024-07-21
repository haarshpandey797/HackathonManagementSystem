package com.nucleus.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    public String getCurrentUser() {
        // Get authentication object from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get username of currently authenticated user
        String username = authentication.getName();

        return  username;
    }
}
