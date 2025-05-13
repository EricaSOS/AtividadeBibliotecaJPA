/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ericasos.atividadebibliotecajpa.entidades;

import javax.persistence.*;
import java.util.List;

@Entity 
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Long id; 

    @Column(name = "matriculaAluno", unique = true, nullable = false, length = 20)
    private String matriculaAluno;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprestimo> emprestimos;

    public Aluno() {
    }

    public Aluno(String matriculaAluno, String nome) {
        this.matriculaAluno = matriculaAluno;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
        emprestimo.setAluno(this);
    }

    public void removeEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.remove(emprestimo);
        emprestimo.setAluno(null);
    }

    @Override
    public String toString() {
        return "Aluno{" +
               "id=" + id +
               ", matriculaAluno='" + matriculaAluno + '\'' +
               ", nome='" + nome + '\'' +
               '}';
    }
}
