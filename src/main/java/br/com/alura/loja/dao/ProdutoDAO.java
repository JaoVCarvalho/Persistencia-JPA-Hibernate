package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em){
        this.em = em;
    }

    public void salvar(Produto produto){
        this.em.persist(produto);
    }

    // Merge() -> Garantir que a entidade vai estar em um estado "Managed"
    public void atualizar(Produto produto) {this.em.merge(produto);}

    // Para uma entidade ser removida ela precisa estar no estado Managed, por isso na primeira linha fazemos um merge()
    // Lembrando que, o merge retorna uma referência da entidade no estado Managed, sendo necessário a atribuição
    public void remover(Produto produto){
        produto = em.merge(produto);
        this.em.remove(produto);
    }
}
