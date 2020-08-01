package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaSaldo {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();

		conta.setTitular("Reinaldo Reis");
		conta.setNumero(558);
		conta.setAgencia(03);
		conta.setSaldo(100.0);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();
		
		
		System.out.println("Id da conta do Reinaldo : " + conta.getId());
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		conta.setSaldo(500.0);
//		Faz uma conta no estado Detached de volta ao estade de Managed
		em2.merge(conta);
		em2.getTransaction().commit();
		
	}
}