package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id //Anotação para indicar a chave primária

    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação para indicar para a JPA que o BD será responsável por determinar a chave primária
    //Strategy permite determinar a estratégia de determinação de chave primária
    private long id;
    private String nome;
    //@column(name = "Desc") -> Anotação para mudar o nome da coluna
    private String descricao;
    private BigDecimal preco;
    private LocalDate data = LocalDate.now();
    @ManyToOne // Anotação para definir a cardinalidade do relacionamento
    private  Categoria categoria;

    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto() {

    }
}
