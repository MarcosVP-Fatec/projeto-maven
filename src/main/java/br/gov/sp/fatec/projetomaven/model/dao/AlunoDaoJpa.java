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
        return salvarAluno( new Aluno(nomeUsuario, senha, ra) );
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
            salvarAlunoSemCommit(aluno);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o aluno" + (aluno.getId()==null?"!":" " + aluno.getNomeUsuario() + "!"), e);
        }
        return aluno;
    }

    @Override
    public Aluno salvarAlunoSemCommit(Aluno aluno) {
        if (aluno.getId()==null){
            em.persist(aluno);
        } else {
            em.merge(aluno);
        }
        return aluno;
    }
    /**
     * @apiNote buscarAlunoPorRa(Long ra)
     * Faz uma pesquisa do aluno por ra.
     * @return Aluno
     */
    @Override
    public Aluno buscarAlunoPorRa(Long ra) {
        String jpql = "select a from Aluno a where a.ra = :ra";
        TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
        query.setParameter("ra", ra);
        return query.getSingleResult();
    }

    /**
     * @apiNote buscarAlunoPorRa(Long ra)
     * Remove um aluno a partir do seu ra
     * @return void
     */
    @Override
    public void removerAlunoPorRa(Long ra) {
        Aluno aluno = buscarAlunoPorRa(ra);
        if (aluno.getId() == null) throw new RuntimeException("Aluno não cadastrado => RA " + ra + "!");
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
    }

}