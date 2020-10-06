/**
 * Uasr a expressão abaixo para executar pelo maven
 * mvn exec:java -Dexec.mainClass="br.gov.sp.fatec.projetomaven.App"
 */
package br.gov.sp.fatec.projetomaven;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.projetomaven.model.PersistenceManager;
import br.gov.sp.fatec.projetomaven.model.dao.AlunoDao;
import br.gov.sp.fatec.projetomaven.model.dao.AlunoDaoJpa;
import br.gov.sp.fatec.projetomaven.model.dao.TrabalhoDao;
import br.gov.sp.fatec.projetomaven.model.dao.TrabalhoDaoJpa;
import br.gov.sp.fatec.projetomaven.model.entity.Aluno;
import br.gov.sp.fatec.projetomaven.model.entity.Professor;
import br.gov.sp.fatec.projetomaven.model.entity.Trabalho;

public class App {
    public static void main(final String[] args) throws ParseException {

        System.out.println("############################# INÍCIO #############################");

        // Criação da fábrica
        /*
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("avaliacao"); // Colocar o nome da
                                                                                                  // persistence-unit
        final EntityManager em = factory.createEntityManager();
        */
        
        EntityManager em = PersistenceManager.getInstance().getEntityManager();
        
        Aluno aluno;
        // ALUNOS
        try {
            em.getTransaction().begin();

            System.out.println("#################################### ALUNOS #########################################");

            System.out.println("### MARCOS ##########################################################################");
            aluno = new Aluno("Marcos Vinicio Pereira", "pwmvp", 1111L);
            em.persist(aluno);

            System.out.println("### RAYAN ###########################################################################");
            aluno = new Aluno("Raian Silva Damaceno", "pwrsd", 2222L);
            em.persist(aluno);

            System.out.println("### SUPER DÍNAMO ####################################################################");
            aluno = new Aluno("Dínamo Número Um", "pwsdnu", 3333L);
            em.persist(aluno);

            em.getTransaction().commit();

        } catch (final PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        // PROFESSORES
        Professor professor;
        try {
            em.getTransaction().begin();

            System.out.println(
                    "#################################### PROFESSORES #########################################");

            System.out.println("### MINEDA ##########################################################################");
            professor = new Professor("Emanuel Mineda", "pwem", "Mestre");
            em.persist(professor);
            System.out.println(">>> ID do Primeiro professor cadastrado => " + professor.getId());

            System.out.println("### SAKAUE ##########################################################################");
            professor = new Professor("Eduardo Sakaue", "pwes");
            em.persist(professor);

            em.getTransaction().commit();

        } catch (final PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        // TRABALHOS
        Trabalho trabalho;
        try {
            System.out.println("#################################### TRABALHOS ######################################");
            System.out.println("### Trabalho JPA ####################################################################");

            em.clear();
            em.getTransaction().begin();
            professor = em.find(Professor.class, 4L);
            System.out.println(">>> Professor => " + professor.getId() + " - " + professor.getNomeUsuario());

            trabalho = new Trabalho("Trabalho 2 LAB IV - JPA", new Date(), "trabalhos");
            trabalho.setProfessorAvaliador(professor); // Não funcionou usando o construtor de trabalho que insere o
                                                       // professor direto
            System.out.println("TRABALHO/AVALIADOR = " + trabalho.getProfessorAvaliador().getNomeUsuario());

            trabalho.setAlunos(new HashSet<Aluno>());
            trabalho.getAlunos().add(em.find(Aluno.class, 1L));
            trabalho.getAlunos().add(em.find(Aluno.class, 3L));
            trabalho.getAlunos().add(em.find(Aluno.class, 2L));

            em.persist(trabalho);
            em.getTransaction().commit();

            System.out.println("### Trabalho TESTE ####################################################################");

            em.clear();
            em.getTransaction().begin();
            professor = em.find(Professor.class, 4L);
            System.out.println(">>> Professor => " + professor.getId() + " - " + professor.getNomeUsuario());

            trabalho = new Trabalho("Trabalho 2 LAB IV - TESTE", new Date(), "trabalhos");
            trabalho.setProfessorAvaliador(professor); // Não funcionou usando o construtor de trabalho que insere o
                                                       // professor direto
            System.out.println("TRABALHO/AVALIADOR = " + trabalho.getProfessorAvaliador().getNomeUsuario());

            trabalho.setAlunos(new HashSet<Aluno>());
            trabalho.getAlunos().add(em.find(Aluno.class, 1L));
            trabalho.getAlunos().add(em.find(Aluno.class, 2L));
            trabalho.getAlunos().add(em.find(Aluno.class, 3L));

            em.persist(trabalho);
            em.getTransaction().commit();

            System.out.println("### Trabalho Maven ####################################################################");

            em.clear();
            em.getTransaction().begin();
            professor = em.find(Professor.class, 4L);
            System.out.println(">>> Professor => " + professor.getId() + " - " + professor.getNomeUsuario());

            trabalho = new Trabalho("Trabalho 2 LAB IV - MAVEN", new Date(), "trabalhos");
            trabalho.setProfessorAvaliador(professor); // Não funcionou usando o construtor de trabalho que insere o
                                                       // professor direto
            System.out.println("TRABALHO/AVALIADOR = " + trabalho.getProfessorAvaliador().getNomeUsuario());

            trabalho.setAlunos(new HashSet<Aluno>());
            trabalho.getAlunos().add(em.find(Aluno.class, 1L));
            trabalho.getAlunos().add(em.find(Aluno.class, 2L));

            em.persist(trabalho);
            em.getTransaction().commit();

        } catch (final PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        try {

            System.out.println(
                    "### TESTE DE ALTERAÇÃO ####################################################################");
            trabalho = em.find(Trabalho.class, 3L);
            trabalho.setLocalArquivo("c:/temp/teste.pdf");
            em.getTransaction().begin();
            em.getTransaction().commit();

        } catch (final Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        }

        try {

            System.out.println("### TESTE DE ALTERAÇÃO / UPDATE ####################################################");
            trabalho = em.find(Trabalho.class, 1L);
            trabalho.setLocalArquivo("c:/temp/LAB IV.pdf");
            em.getTransaction().begin();
            em.merge(trabalho);
            em.getTransaction().commit();

        } catch (final Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        }

        // TRABALHOS - EXCLUI O Trabalho TESTE
        try {

            System.out.println(
                    "### EXCLUSÃO do Trabalho TESTE ####################################################################");

            trabalho = em.find(Trabalho.class, 2L);
            
            em.getTransaction().begin();
            em.remove(trabalho);
            em.getTransaction().commit();

        } catch (final Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        System.out.println("### PESQUISA / JPQL ####################################################################");
        // Define a query
        String qtexto = "select distinct t from Trabalho t where t.titulo like :titulo";
        // Define a query parseada
        TypedQuery<Trabalho> query = em.createQuery(qtexto, Trabalho.class);
        // Atribui o parâmetro da query
        query.setParameter("titulo", "%MAVEN%");
        // Como a pesquisa pode resultar mais de uma linha usar o List
        List<Trabalho> resultados = query.getResultList();
        // Imprime
        System.out.println("######### RELATÓRIO DE TRABALHOS CADASTRADOS #########");
        for (final Trabalho temp : resultados) {
            System.out.println(
                    "Título: " + temp.getTitulo() + " | Entrega em : " + temp.getDataHoraEntrega().toString());
        }
        System.out.println("--------------------------------------------------------------");

        // Define a query para pesquisar com join de alunos
        qtexto = "select distinct t from Trabalho t inner join t.alunos a where a.nomeUsuario like :nome";
        // Define a query parseada
        query = em.createQuery(qtexto, Trabalho.class);
        // Atribui o parâmetro da query
        query.setParameter("nome", "%Vinicio%");
        // Como a pesquisa pode resultar mais de uma linha usar o List
        resultados = query.getResultList();
        // Imprime
        System.out.println("######### RELATÓRIO DE TRABALHOS CADASTRADOS POR ALUNOS #########");
        for (final Trabalho temp : resultados) {
            System.out.println("Título: " + temp.getTitulo() );
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("### ALUNOS + PROFESSOR + TRABALHO usando DAO ####################################################################");
        professor = new Professor("Fabiano Sabha", "pwfs");
        trabalho = new Trabalho("Sistema Operacional", Mvp.toDate("30/10/2020"), "c:/temp/Tralaho SO.pptx", professor);
        trabalho.setAlunos(new HashSet<Aluno>());
        trabalho.getAlunos().add(new Aluno("Júlia Régia", "pwjr", 4444L) );
        AlunoDao alunoDao = new AlunoDaoJpa(em);
        trabalho.getAlunos().add( alunoDao.buscarAlunoPorRa( 1111L ));
        trabalho.getAlunos().add( alunoDao.buscarAlunoPorRa( 3333L ));
        TrabalhoDao trabalhoDao = new TrabalhoDaoJpa(em);
        trabalhoDao.salvarTrabalho(trabalho);

        System.out.println("--------------------------------------------------------------");

        //Fecha a fábrica 
        em.close();
        System.out.println("#############################   FIM  #############################");
        Mvp.printEnd();

    }
}
