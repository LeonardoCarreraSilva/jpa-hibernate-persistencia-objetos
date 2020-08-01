package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Valmiro");
		conta.setAgencia(202);
		conta.setNumero(24);
		conta.setSaldo(-50.0);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
//		Transient -> managed
		em.persist(conta);
		
//		managed -> removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}

}
