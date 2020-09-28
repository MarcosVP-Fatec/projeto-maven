/**
 * Uasr a expressão abaixo para executar pelo maven
 * mvn exec:java -Dexec.mainClass="br.gov.sp.fatec.projetomaven.App"
 */
package br.gov.sp.fatec.projetomaven;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.gov.sp.fatec.projetomaven.model.entity.Aluno;
import br.gov.sp.fatec.projetomaven.model.entity.Professor;
import br.gov.sp.fatec.projetomaven.model.entity.Trabalho;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("############################# INÍCIO #############################");

        // Criação da fábrica
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("avaliacao"); //Colocar o nome da persistence-unit
        EntityManager em = factory.createEntityManager();

        Aluno aluno;
        // ALUNOS
        try {
            em.getTransaction().begin();

            System.out.println("#################################### ALUNOS #########################################");
            System.out.println("### MARCOS ##########################################################################");
            aluno = new Aluno("Marcos Vinicio Pereira","pwmvp",1L);            em.persist( aluno );
            System.out.println("### RAYAN ###########################################################################");
            aluno = new Aluno("Raian Silva Damaceno"  ,"pwrsd",2L);            em.persist( aluno );

            em.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        // PROFESSORES
        Professor professor;
        try {
            em.getTransaction().begin();

            System.out.println("#################################### PROFESSORES #########################################");
            System.out.println("### MINEDA ##########################################################################");
            professor = new Professor("Emanuel Mineda","pwem","Mestre");        em.persist( professor );
            System.out.println("### Eduardo Sakaue ##################################################################");
            professor = new Professor("Eduardo Sakaue","pwes");                 em.persist( professor );

            em.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        // TRABALHOS
        Trabalho trabalho;
        //em.clear();
        try {
            em.getTransaction().begin();

            System.out.println("#################################### TRABALHOS ######################################");
            System.out.println("### Trabalho JPA ####################################################################");
            
            professor = em.find(Professor.class, 1L);
            System.out.println("Professor " + professor.getId() + " - " + professor.getNomeUsuario());

            aluno = em.find(Aluno.class, 1L);
            System.out.println("Alunor " + aluno.getId() + " - " + aluno.getNomeUsuario());

            trabalho = new Trabalho("Trabalho 2 LAV IV - JPA", new Date(), "trabalhos");
            trabalho.setProfessorAvaliador(professor); //Não funcionou usando o construtor de trabalho que insere o professor direto
            System.out.println("TRABALHO/AVALIADOR = " + trabalho.getProfessorAvaliador().getNomeUsuario());

            trabalho.setAlunos(new HashSet<Aluno>());
            trabalho.getAlunos().add( em.find(Aluno.class, 1L) );
            trabalho.getAlunos().add( em.find(Aluno.class, 2L) );

            em.persist(trabalho);
            em.getTransaction().commit();


        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        // Fecha a fábrica
        em.close();
        factory.close();


        System.out.println("#############################   FIM  #############################");

    }
}
