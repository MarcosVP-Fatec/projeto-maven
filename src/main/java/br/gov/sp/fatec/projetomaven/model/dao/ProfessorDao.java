package br.gov.sp.fatec.projetomaven.model.dao;

import br.gov.sp.fatec.projetomaven.model.entity.Professor;

public interface ProfessorDao {

    public Professor cadastrarProfessor(String nomeUsuario, String senha, String titulo);

    public Professor cadastrarProfessor(String nomeUsuario, String senha);

    public Professor salvarProfessor(Professor professor);

    public Professor buscarProfessorPorNomeUsuario(String nomeUsuario);

    public void removerProfessorPorNomeUsuario(String nomeUsuario);
    
}