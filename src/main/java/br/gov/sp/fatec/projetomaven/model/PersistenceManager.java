package br.gov.sp.fatec.projetomaven.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    // Instanciamos a classe dentro dela mesma
    private static PersistenceManager instance;

    /**
     * O construtor é privado, portanto esta classe não pode ser instanciada
     */
    private PersistenceManager () {    }

    protected EntityManagerFactory emf;
    
    /**
     * O método getInstance() é a essência do singleton
     * Quando este método é executado verifica se a instância é nula. Se for nula ele é instanciado
     * e coloca na variável instance.
     * @return instance
     */
    public static PersistenceManager getInstance() {
        if (instance == null) instance = new PersistenceManager();
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) Persistence.createEntityManagerFactory("avaliacao"); 
        return emf;
    }

    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
 
}