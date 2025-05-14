package ericasos.atividadebibliotecajpa;

import DAO.EmprestimoDAO;
import ericasos.atividadebibliotecajpa.entidades.Aluno;
import ericasos.atividadebibliotecajpa.entidades.Emprestimo;
import ericasos.atividadebibliotecajpa.entidades.Publicacao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AtividadeBibliotecaJPA {
    public static void main(String[] args) {
        // Cria entidades fictícias
        Aluno aluno = new Aluno();
        aluno.setNome("Érica Santos");
        
        Publicacao publicacao = new Publicacao();
        publicacao.setTitulo("Inteligência Artificial na Amazônia");
        
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setAluno(aluno);
        emprestimo.setPublicacao(publicacao);

        Date dataEmprestimo = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataDevolucao = Date.from(LocalDate.now().plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant());

        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataDevolucao(dataDevolucao);
        
        System.out.println("Empréstimo salvo com sucesso!");
    }
}

