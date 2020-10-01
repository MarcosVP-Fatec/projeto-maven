package br.gov.sp.fatec.projetomaven.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.gov.sp.fatec.projetomaven.model.PersistenceManager;
import br.gov.sp.fatec.projetomaven.model.entity.Trabalho;

public class TrabalhoDaoJpa implements TrabalhoDao {

    private EntityManager em;

    public TrabalhoDaoJpa() {
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public TrabalhoDaoJpa(EntityManager em) {
        this.em = em;
    }

     /**
     * @apiNote salvarTrabalho( Trabalho trabalho )
     * Faz um update na entidade Trabalho
     * @return Trabalho
     */
   @Override
    public Trabalho salvarTrabalho(Trabalho trabalho) {
        try {
            em.getTransaction().begin();
            if (trabalho.getId()==null){
                em.persist(trabalho);
            } else {
                em.merge(trabalho);
            }
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o trabalho" + (trabalho.getId()==null?"!":" " + trabalho.getTitulo() + "!"), e);
        }
        return trabalho;
    }

    /**
     * @apiNote buscarTrabalhoPorId( Long id )
     * Faz uma pesquisa do trabalho por id
     * @return Trabalho
     */
    @Override
    public Trabalho buscarTrabalhoPorId(Long id) {
        return em.find(Trabalho.class, id);
    }

    /**
     * @apiNote removerTrabalhoPorId(Long id)
     * Remove um trabalho a partir do seu id
     * @return void
     */
    @Override
    public void removerTrabalhoPorId(Long id) {
        Trabalho trabalho = buscarTrabalhoPorId(id);
        if (trabalho.getId() == null) throw new RuntimeException("Trabalho não cadastrado => " + id + "!");
        em.getTransaction().begin();
        em.remove(trabalho);
        em.getTransaction().commit();
    }

}