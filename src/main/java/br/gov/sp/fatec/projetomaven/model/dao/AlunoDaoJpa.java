package br.gov.sp.fatec.projetomaven.model.dao;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
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

    /**
     * @apiNote cadastrarAluno(String nomeUsuario, String senha, Long ra)
     * @return Aluno
     * 
     */
    @Override
    public Aluno cadastrarAluno(String nomeUsuario, String senha, Long ra) {
        Aluno aluno = new Aluno(nomeUsuario, senha, ra);
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            return aluno;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @apiNote buscarAlunoPorRa(Long ra)
     * Faz uma pesquisa do aluno por ra.
     * @return Aluno
     */
    @Override
    public Aluno buscarAlunoPorRa(Long ra) {
        String jpql = "select a from aluno a where a.ra = :ra";
        TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
        query.setParameter("ra", ra);
        return query.getSingleResult();
    }

    @Override
    public void removerAluno(Long ra) {
        // TODO Auto-generated method stub

    }

    /**
     * @apiNote salvarAluno( Aluno aluno )
     * Faz um update na entidade Aluno
     * @return Aluno
     */
    @Override
    public Aluno salvarAluno(Aluno aluno) {
        try {

            em.getTransaction().begin();
            
            
        } catch (PersisteException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return aluno;
    }
    
}