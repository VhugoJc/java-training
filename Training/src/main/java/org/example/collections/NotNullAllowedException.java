package org.example.collections;
// Checked exceptions are exceptions that need to be treated explicitly.

public class NotNullAllowedException extends Exception{
    public NotNullAllowedException(String message, Throwable cause) { // best practice
        super(message, cause);
    }

    public NotNullAllowedException(String message) {
        super(message);
    }
}

/*
java.lang.Object
        java.lang.Throwable
            java.lang.Exception
                java.lang.RuntimeException [Unchecked]
                    java.lang.NullPointerException
 */