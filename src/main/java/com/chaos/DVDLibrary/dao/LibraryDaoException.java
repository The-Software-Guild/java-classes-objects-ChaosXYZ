package com.chaos.DVDLibrary.dao;

public class LibraryDaoException extends Exception{
    
    public LibraryDaoException(String message) {
        super(message);
    }
    
    public LibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
