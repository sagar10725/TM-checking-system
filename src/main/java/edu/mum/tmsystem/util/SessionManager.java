package edu.mum.tmsystem.util;


import java.util.Iterator;

import org.springframework.security.core.context.SecurityContextHolder;

import edu.mum.tmsystem.enums.RoleType;

public class SessionManager {
    public static AuthenticatedUser getPrincipal() {
        return (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getUserName() {
        return getPrincipal().getUsername();
    }

    public static RoleType getRole() {
        Iterator iterator = getPrincipal().getAuthorities().iterator();
        String role = String.valueOf(iterator.next());
        return RoleType.valueOf(role);
    }

    public static String getFullName() {
        return getPrincipal().getName();
    }

    public static Long getUserID() {
        return getPrincipal().getUserId();
    }

    public static boolean isAnonymousUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser");
    }

}
