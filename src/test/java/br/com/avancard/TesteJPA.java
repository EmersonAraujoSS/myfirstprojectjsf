package br.com.avancard;

import javax.persistence.Persistence;

public class TesteJPA {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("myfirstprojectjsf");
    }
}
