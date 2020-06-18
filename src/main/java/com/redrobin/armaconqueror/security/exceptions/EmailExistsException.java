package com.redrobin.armaconqueror.security.exceptions;

public class EmailExistsException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -4072047721454465349L;

    public EmailExistsException(String message) {
        super(message);
    }

}

