package ericasos.atividadebibliotecajpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Long id;

    @Column(name = "matriculaAluno", unique = true, nullable = false)
    private Integer matriculaAluno;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    public Aluno() {
    }

    public Aluno(Integer matriculaAluno, String nome) {
        this.matriculaAluno = matriculaAluno;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Integer matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(matriculaAluno, aluno.matriculaAluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matriculaAluno);
    }

    @Override
    public String toString() {
        return "Aluno{" +
               "id=" + id +
               ", matriculaAluno=" + matriculaAluno +
               ", nome='" + nome + '\'' +
               '}';
    }
}