package com.example.hexagonal.application.core.domain;

public class Customer {
 private String id;
 private String nome;

 private Adress adress;
 private String cpf;
 private Boolean isValidCpf;

    public Customer(){
        this.isValidCpf = false;

    }
    public Customer(String id, String nome, Adress adress, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.nome = nome;
        this.adress = adress;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }

    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }
}

