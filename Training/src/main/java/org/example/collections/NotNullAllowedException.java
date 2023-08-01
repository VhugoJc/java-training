package org.example.collections;
// Checked exceptions are exceptions that need to be treated explicitly.

public class NotNullAllowedException extends RuntimeException{
    public NotNullAllowedException() {

    }
}

/*
java.lang.Object
        java.lang.Throwable
            java.lang.Exception [Checked]
                java.lang.RuntimeException [Unchecked]
                    java.lang.NullPointerException
 */