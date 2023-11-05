package br.com.pyetro;

import br.com.pyetro.register.domain.Persistent;

public class Product implements Persistent {

    private String name;
    private Long code;
    private String description;
    private Double price;

    public Long getCode(){
        return code;
    }

    public void setCode(Long code){
        this.code = code;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
