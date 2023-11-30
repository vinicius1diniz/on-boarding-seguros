package com.example.hexagonal.adapters.in.controller.response;

import com.example.hexagonal.application.core.domain.Adress;

public class CustomerResponse {
    private String nome;

    private AddressResponse adress;
    private String cpf;
    private Boolean isValidCpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AddressResponse getAdress() {
        return adress;
    }

    public void setAdress(AddressResponse adress) {
        this.adress = adress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
