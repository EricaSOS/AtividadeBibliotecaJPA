/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ericasos.atividadebibliotecajpa.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity 
@Table(name = "Emprestimo") 
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_id")
    private Long id; 

    @Column(name = "dataEmprestimo", nullable = false)
    @Temporal(TemporalType.DATE) 
    private Date dataEmprestimo;

    @Column(name = "dataDevolucao") 
    @Temporal(TemporalType.DATE) 
    private Date dataDevolucao; 

    
    @ManyToOne 
    @JoinColumn(name = "aluno_id", nullable = false) 
    private Aluno aluno; 

    @ManyToOne
    @JoinColumn(name = "publicacao_id", nullable = false)
    private Publicacao publicacao;

    
    public Emprestimo() {
    
    }

    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, Aluno aluno, Publicacao publicacao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.aluno = aluno;
        this.publicacao = publicacao;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

     @Override
    public String toString() {
        return "Emprestimo{" +
               "id=" + id +
               ", dataEmprestimo=" + dataEmprestimo +
               ", dataDevolucao=" + dataDevolucao +
               ", aluno=" + (aluno != null ? aluno.getNome() : "null") + 
               ", publicacao=" + (publicacao != null ? publicacao.getTitulo() : "null") + 
               '}';
    }
}
