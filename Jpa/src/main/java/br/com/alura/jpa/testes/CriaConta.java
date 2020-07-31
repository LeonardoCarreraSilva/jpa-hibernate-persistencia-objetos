package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
		
		
		Conta conta = new Conta();
		
		conta.setTitular("Leonardo Carrera da Silva");
		conta.setNumero(123456);
		conta.setAgencia(01);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
	}
}
