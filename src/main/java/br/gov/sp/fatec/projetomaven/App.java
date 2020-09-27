/**
 * Uasr a expressão abaixo para executar pelo maven
 * mvn exec:java -Dexec.mainClass="br.gov.sp.fatec.projetomaven.App"
 */
package br.gov.sp.fatec.projetomaven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.gov.sp.fatec.projetomaven.model.entity.Aluno;
import br.gov.sp.fatec.projetomaven.model.entity.Professor;

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

            System.out.println("#################################### ALUNOS #########################################");
            System.out.println("### MARCOS ##########################################################################");
            aluno = new Aluno("Marcos Vinicio Pereira","pwmvp",1L);            em.persist( aluno );
            System.out.println("### RAYAN ###########################################################################");
            aluno = new Aluno("Raian Silva Damaceno"  ,"pwrsd",2L);            em.persist( aluno );

            em.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();;
            em.getTransaction().rollback();
        }

        Professor professor;
        // Aluno
        try {
            em.getTransaction().begin();

            System.out.println("#################################### PROFESSORES #########################################");
            System.out.println("### MINEDA ##########################################################################");
            professor = new Professor("Emanuel Mineda","pwem","Mestre");        em.persist( professor );
            System.out.println("### Eduardo Sakaue ##################################################################");
            professor = new Professor("Eduardo Sakaue","pwes");                 em.persist( professor );

            em.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();;
            em.getTransaction().rollback();
        }

        // Fecha a fábrica
        em.close();
        factory.close();


        System.out.println("#############################   FIM  #############################");

    }
}
