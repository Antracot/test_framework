package com.softserveinc.edu.ita.dao;

/**
 * Class that represents exceptions which DAO models throw.
 */
public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(final String message) {
        super(message);
    }

    public DAOException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DAOException(final Throwable cause) {
        super(cause);
    }

    public DAOException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}