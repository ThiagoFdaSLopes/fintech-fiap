package br.com.devthiagolopes.exception;

public class EntityNotFound extends Exception{
    public EntityNotFound() {
    }
    public EntityNotFound(String message) {
        super(message);
    }
}

