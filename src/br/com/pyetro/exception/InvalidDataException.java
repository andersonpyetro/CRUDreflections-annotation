package br.com.pyetro.exception;

public class InvalidDataException extends Exception {
    public InvalidDataException(String msg){
        this(msg, null);
    }
    public InvalidDataException(String msg, Throwable e){
        super(msg,e);
    }
}
