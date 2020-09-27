/**
 * Uasr a expressão abaixo para executar pelo maven
 *
 */
package br.gov.sp.fatec.projetomaven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gov.sp.fatec.projetomaven.model.entity.Aluno;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("############################# INÍCIO #############################");

        // Criação da fábrica
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("avaliacao"); //Colocar o nome da persistence-unit
        EntityManager em = factory.createEntityManager();

        Aluno aluno;
        // Aluno
        try {
            em.getTransaction().begin();
            
            aluno = new Aluno("Marcos Vinicio Pereira","pwmvp",1L);
            em.persist( aluno );
            em.getTransaction().commit();
            System.out.println("Inseriu o aluno " + aluno.getId() );
        } catch (Exception e) {
            em.getTransaction().rollback();
        }



        // Fecha a fábrica
        em.close();
        factory.close();


        System.out.println("#############################   FIM  #############################");

    }
}
