package br.gov.sp.fatec.projetomaven.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.projetomaven.model.PersistenceManager;
import br.gov.sp.fatec.projetomaven.model.entity.Professor;

public class ProfessorDaoJpa implements ProfessorDao {
    
    private EntityManager em;

    public ProfessorDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public ProfessorDaoJpa(EntityManager em){
        this.em = em;
    }

    /**
     * @apiNote cadastrarProfessor(String nomeUsuario, String senha, [String titulo])
     * @return Professor
     * 
     */
    @Override
    public Professor cadastrarProfessor(String nomeUsuario, String senha, String titulo) {
        return salvarProfessor( new Professor(nomeUsuario, senha, titulo) );
    }

    public Professor cadastrarProfessor(String nomeUsuario, String senha) {
        return salvarProfessor( new Professor(nomeUsuario, senha) );
    }

    /**
     * @apiNote salvarProfessor( Professor professor )
     * Faz um update na entidade Professor
     * @return Professor
     */
    @Override
    public Professor salvarProfessor(Professor professor) {
        try {
            em.getTransaction().begin();
            if (professor.getId()==null){
                em.persist(professor);
            } else {
                em.merge(professor);
            }
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o professor" + (professor.getId()==null?"!":" " + professor.getNomeUsuario() + "!"), e);
        }
        return professor;
    }

    /**
     * @apiNote buscarProfessorPorNomeUsuario(String nomeUsuario )
     * Faz uma pesquisa do professor por nome de usuário
     * @return Professor
     */
    @Override
    public Professor buscarProfessorPorNomeUsuario(String nomeUsuario) {
        String jpql = "select p from professor p where p.nomeUsuario = :nomeUsuario";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("nomeUsuario", nomeUsuario);
        return query.getSingleResult();
    }

    /**
     * @apiNote buscarProfessorPorNomeUsuario(String nomeUsuario)
     * Remove um professor a partir do seu nome de usuário
     * @return void
     */
    @Override
    public void removerProfessorPorNomeUsuario(String nomeUsuario) {
        Professor professor = buscarProfessorPorNomeUsuario(nomeUsuario);
        if (professor.getId() == null) throw new RuntimeException("Professor não cadastrado => " + nomeUsuario + "!");
        em.getTransaction().begin();
        em.remove(professor);
        em.getTransaction().commit();
    }

    
}