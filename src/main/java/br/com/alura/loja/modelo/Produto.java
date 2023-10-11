package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {
    //Anotação para indicar a chave primária
    @Id
    //Anotação para indicar para a JPA que o BD será responsável por determinar a chave primária
    //Strategy permite determinar a estratégia de determinação de chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    //@column(name = "Desc") -> Anotação para mudar o nome da coluna
    private String descricao;
    private BigDecimal preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
