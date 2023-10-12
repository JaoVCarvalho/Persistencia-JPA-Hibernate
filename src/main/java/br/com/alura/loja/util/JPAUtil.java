package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Stack;

public class JPAUtil {

    // O EntityManagerFactory recebe como parâmetro o nome atribuido ao persistence-unit, para que ele identifique qual BD será utilizado
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
