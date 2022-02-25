package org.example.web.exception;

public class ReaderException extends Exception {
    String message="Сообщение об ошибке отсутствует";

    public ReaderException() {
    }

    public ReaderException(String message) {
        this.message = message;
    }

    public ReaderException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public ReaderException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
