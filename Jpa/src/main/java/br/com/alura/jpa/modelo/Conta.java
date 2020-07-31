package br.com.alura.jpa.modelo;

import javax.persistence.Entity;

@Entity
public class Conta {
	private Long id;
	private Integer agencia;
    private Integer numero;
    private String titular;

}
