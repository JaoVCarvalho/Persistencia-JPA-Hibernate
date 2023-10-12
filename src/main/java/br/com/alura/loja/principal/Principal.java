package br.com.alura.loja.principal;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {

        // Testando inserção no BD usando JPA

        Produto celular =
                new Produto("Motorola Moto Z3", "Smartphone da motorola", new BigDecimal("1500.00"), Categoria.CELULARES);

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        new ProdutoDAO(em).salvar(celular);
        em.getTransaction().commit();
        em.clear();
    }
}