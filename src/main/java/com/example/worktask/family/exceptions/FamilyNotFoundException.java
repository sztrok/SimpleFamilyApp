package com.example.worktask.family.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FamilyNotFoundException extends RuntimeException{
    /**
     * Exception thrown then family with given ID cannot be found
     * @param id ID of family
     */
    public FamilyNotFoundException(Long id) {
        super("Could not find family "+id);
    }
}
