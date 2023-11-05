package br.com.pyetro.register.domain;

import br.com.pyetro.register.domain.annotation.TypeKey;

import java.util.Objects;


public class Client implements Persistent {

    private String name;
    @TypeKey("getCPF")
    private Long cpf;
    private Long cel;
    private String address;
    private Integer num;
    private String city;
    private String state;

    public Client(String name, String cpf, String cel,String address,String num, String city, String state){
        this.name = name;
        this.cpf = Long.valueOf(cpf.trim());
        this.cel = Long.valueOf(cel.trim());
        this.address = address;
        this.num = Integer.valueOf(num.trim());
        this.city = city;
        this.state = state;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getCpf(){
        return cpf;
    }

    public void setCpf(Long cpf){
        this.cpf = cpf;
    }

    public Long getCel(){
        return cel;
    }

    public void setCel(Long cel){
        this.cel = cel;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Integer getNum(){
        return num;
    }
    public void setNum(Integer num){
        this.num = num;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", cel=" + cel +
                ", address='" + address + '\'' +
                ", num=" + num +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(name, client.name) && Objects.equals(cpf, client.cpf) && Objects.equals(cel, client.cel) && Objects.equals(address, client.address) && Objects.equals(num, client.num) && Objects.equals(city, client.city) && Objects.equals(state, client.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf, cel, address, num, city, state);
    }
}
