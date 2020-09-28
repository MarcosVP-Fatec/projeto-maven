package br.gov.sp.fatec.projetomaven.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.sp.fatec.projetomaven.Mvp;

@Table(name = "pro_professor")
@Entity
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")            private Long    id;
    @Column(name = "pro_nome_usuario")  private String  nomeUsuario;
    @Column(name = "pro_senha")         private String  senha;
    @Column(name = "pro_titulo")        private String  titulo;

    //Usar o Set poque não pode repetir o trabalho
    //O Hibernate não trabalha bem com List
    //LAZY porque não quero carregar todos os trabalhos do professor sempre
    //
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professorAvaliador")
    private Set<Trabalho> trabalhosAvaliados;

    /**
     * Construtor
     * @param nomeUsuario
     */
    public Professor(String nomeUsuario, String senha, String titulo) {
        setNomeUsuario(nomeUsuario);
        setSenha(senha);
        setTitulo(titulo);
    }
    public Professor(String nomeUsuario, String senha) {
        setNomeUsuario(nomeUsuario);
        setSenha(senha);
    }
    public Professor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = Mvp.left(nomeUsuario, 50);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;    
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = Mvp.left(titulo, 10);
    }

    public Set<Trabalho> getTrabalhosAvaliados() {
        return trabalhosAvaliados;
    }

    public void setTrabalhosAvaliados(Set<Trabalho> trabalhosAvaliados) {
        this.trabalhosAvaliados = trabalhosAvaliados;
    }

}