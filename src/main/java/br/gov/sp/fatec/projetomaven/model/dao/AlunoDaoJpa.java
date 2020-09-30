package br.gov.sp.fatec.projetomaven.model.dao;

import javax.persistence.EntityManager;

import br.gov.sp.fatec.projetomaven.model.PersistenceManager;
import br.gov.sp.fatec.projetomaven.model.entity.Aluno;

public class AlunoDaoJpa implements AlunoDao {

    private EntityManager em;

    public AlunoDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public AlunoDaoJpa(EntityManager em){
        this.em = em;
    }

    @Override
    public Aluno cadastrarAluno(String nomeUsuario, String senha, Long ra) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aluno buscarAlunoPorRa(Long ra) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removerAluno(Long ra) {
        // TODO Auto-generated method stub

    }
    
}