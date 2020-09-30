package br.gov.sp.fatec.projetomaven.model.dao;

import br.gov.sp.fatec.projetomaven.model.entity.Aluno;

public interface AlunoDao {
    
    public Aluno cadastrarAluno(String nomeUsuario, String senha, Long ra);

    public Aluno buscarAlunoPorRa(Long ra);

    public void removerAluno(Long ra);
}