package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

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

    // O método "find()" serve para consultar uma única entidade pelo seu ID (chave primária)
    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }

    // Importante salientar que o comando "createQuery()" apenas cria a query. Quem vai disparar a query no BD vai ser o comendo "getResultList()"
    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    // Em p.nome, "nome" é o nome do atributo
    // O ":" permite indicar para o JPA que temos um valor dinâmico na query
    public List<Produto> buscarPorNome(String nome){

        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";

        //String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1 ?2 ?3"; -> Aqui temos outra abordagem para valores dinâmicos numa query

        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                //.setParameter(1, nome)
                .getResultList();
    }

    // Fazendo uma consulta por meio da chave estrangeira (Join)
    public List<Produto> buscarPorCategoria(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";

        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    // Em uma situação na qual queremos apenas um atributo da entidade, como exemplo, preço do produto, não é necessário carregar toda a entidade
    // podemos carregar apenas o atributo em especial
    public BigDecimal buscarPreco(String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";

        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
