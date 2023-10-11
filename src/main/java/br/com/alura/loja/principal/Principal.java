package br.com.alura.loja.principal;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {

        // Testando inserção no BD usando JPA

        Produto celular = new Produto();
        celular.setNome("Motorola Moto Z3");
        celular.setDescricao("Smartphone da motorola");
        celular.setPreco(new BigDecimal(1500));

        // O EntityManagerFactory recebe como parâmetro o nome atribuido ao persistence-unit, para que ele identifique qual BD será utilizado

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.clear();
    }
}