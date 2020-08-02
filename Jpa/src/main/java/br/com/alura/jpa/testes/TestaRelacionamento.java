package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Renato Aragao");
		conta.setAgencia(0101);
		conta.setNumero(1231231);
		conta.setSaldo(300.0);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(250.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		Conta contaDoLeonardo = em.find(Conta.class, 1L);
		movimentacao.setConta(contaDoLeonardo);

		em.getTransaction().begin();
		// em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
}
