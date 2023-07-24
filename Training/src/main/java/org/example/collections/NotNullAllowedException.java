package org.example.collections;
// Checked exceptions are exceptions that need to be treated explicitly.

public class NotNullAllowedException extends Exception{

    public NotNullAllowedException(String message) {
        super(message);
    }
}
