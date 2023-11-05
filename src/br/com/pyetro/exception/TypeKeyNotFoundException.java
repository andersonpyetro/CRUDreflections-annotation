package br.com.pyetro.exception;

public class TypeKeyNotFoundException extends Exception{
    public TypeKeyNotFoundException(String msg){
        this(msg, null);
    }

    public TypeKeyNotFoundException(String msg, Throwable e){
        super(msg,e);
    }
}
