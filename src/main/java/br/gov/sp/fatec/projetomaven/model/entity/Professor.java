package br.gov.sp.fatec.projetomaven.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.projetomaven.Mvp;

@Table(name = "pro_professor")
@Entity
@PrimaryKeyJoinColumn(name = "pro_id")
public class Professor extends Usuario {
    
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
    public Professor() {}
    public Professor(String nomeUsuario, String senha, String titulo) {
        super(nomeUsuario, senha);
        setTitulo(titulo);
    }
    public Professor(String nomeUsuario, String senha) {
        super(nomeUsuario, senha);
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