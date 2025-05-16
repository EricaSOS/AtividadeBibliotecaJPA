package ericasos.atividadebibliotecajpa.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Publicacao")
public class Publicacao {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publicacao_id")
    private Long id;

    @Column(name = "codigoPub", unique = true, nullable = false)
    private int codigoPub;


    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "ano") 
    private int ano;

    @Column(name = "autor", length = 100) 
    private String autor; 

    @Column(name = "tipo", length = 50)
    private String tipo; 

    
    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprestimo> emprestimos;

    public Publicacao() {
        
    }

    public Publicacao(int codigoPub, String titulo, int ano, String autor, String tipo) {
        this.codigoPub = codigoPub;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(int codigoPub) {
        this.codigoPub = codigoPub;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    // Métodos helper para gerenciar a lista de empréstimos
     public void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
        emprestimo.setPublicacao(this);
    }

    public void removeEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.remove(emprestimo);
        emprestimo.setPublicacao(null);
    }

    @Override 
    public String toString() {
        return "Publicacao{" +
               "id=" + id +
               ", codigoPub='" + codigoPub + '\'' +
               ", titulo='" + titulo + '\'' +
               ", ano=" + ano +
               ", autor='" + autor + '\'' +
               ", tipo='" + tipo + '\'' +
               '}';
    }
}
