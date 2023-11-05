package br.com.pyetro.register.domain;

import br.com.pyetro.register.domain.annotation.TypeKey;

public class Product implements Persistent {

    @TypeKey("getCode")
    private Long code;
    private String name;

    public Long getCode(){
        return code;
    }
    public void setCode(Long code){
        this.code = code;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
