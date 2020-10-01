package br.gov.sp.fatec.projetomaven.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.sp.fatec.projetomaven.Mvp;

@Table(name = "tra_trabalho")
@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")                private Long    id;
    @Column(name = "tra_titulo")            private String  titulo;
    @Column(name = "tra_data_hora_entrega") private Date    dataHoraEntrega;
    @Column(name = "tra_local_arquivo")     private String  localArquivo;

    //A chave estrangeira não se mapeia diretamente
    //x to y => x é da entidade atual.
    //No JoinColumn definir o nome da coluna fk desta entidade.
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "pro_avaliador_id")  private Professor professorAvaliador;

    //Um trabalho pode ter vários alunos e um aluno pode ter vários trabalhos
    //Ao inves de informar qual coluna vai me ajudar a buscar os alunos eu tenho
    //que falar qual a tabela
    //joinColuns define quais as colunas desta classe Trabalho são referenciadas na tabela de ligação
    //inverseJoinColumn define quais colunas da outra tabela (Aluno) são referenciadas na tabela de ligação
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ent_entrega",
               joinColumns = {@JoinColumn(name = "tra_id") },
               inverseJoinColumns = {@JoinColumn(name = "alu_id")})
    private Set<Aluno> alunos;

    /** 
     * Construtor
    */
    public Trabalho(){}
    
    public Trabalho(String      titulo
                  , Date        dataHoraEntrega
                  , String      localArquivo
                  , Professor   professorAvaliadorId) {
        setTitulo(titulo);
        setDataHoraEntrega(dataHoraEntrega);
        setLocalArquivo(localArquivo);
        setProfessorAvaliador(professorAvaliador);
    }

    public Trabalho(String      titulo
                  , Date        dataHoraEntrega
                  , String      localArquivo) {
        setTitulo(titulo);
        setDataHoraEntrega(dataHoraEntrega);
        setLocalArquivo(localArquivo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = Mvp.left(titulo, 50);
    }

    public Date getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(Date dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getLocalArquivo() {
        return localArquivo;
    }

    public void setLocalArquivo(String localArquivo) {
        this.localArquivo = Mvp.left(localArquivo, 200);
    }

    public Professor getProfessorAvaliador() {
        return professorAvaliador;
    }

    public void setProfessorAvaliador(Professor professorAvaliador) {
        this.professorAvaliador = professorAvaliador;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

}