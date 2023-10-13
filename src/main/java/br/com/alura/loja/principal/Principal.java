package br.com.alura.loja.principal;

import br.com.alura.loja.dao.CategoriaDAO;
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

        Categoria categoria = new Categoria("CELULARES");

        Produto celular =
                new Produto("Motorola Moto Z3", "Smartphone da motorola", new BigDecimal("1500.00"), categoria);

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        new CategoriaDAO(em).salvar(categoria);
        new ProdutoDAO(em).salvar(celular);

        em.getTransaction().commit();
        em.close();

        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        //Para realizar o Update de uma entidade, basta alterar seus atributos, porém para alterar no BD essa entidade precisa estar no estado Managed
        //Para garantir que estamos no estado Managed, utilizamos o merge()
        celular.setPreco(new BigDecimal("1300.00"));
        new ProdutoDAO(em).atualizar(celular);

        em.getTransaction().commit();
        em.close();

        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        new ProdutoDAO(em).remover(celular);

        em.getTransaction().commit();
        em.close();
    }
}