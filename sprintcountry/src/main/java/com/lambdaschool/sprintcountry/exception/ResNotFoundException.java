package com.lambdaschool.sprintcountry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public ResNotFoundException(String message)
    {
        super(message);
    }

    public ResNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}