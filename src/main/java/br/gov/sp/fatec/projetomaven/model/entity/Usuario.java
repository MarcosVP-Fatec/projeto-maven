package br.gov.sp.fatec.projetomaven.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.gov.sp.fatec.projetomaven.Mvp;

@Table(name = "usu_usuario")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")            private Long    id;
    @Column(name = "usu_nome_usuario")  private String  nomeUsuario;
    @Column(name = "usu_senha")         private String  senha;

    public Usuario(){}
    public Usuario(String nomeUsuario, String senha){
        setNomeUsuario(nomeUsuario);
        setSenha(senha);
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
        this.nomeUsuario = Mvp.left(nomeUsuario, 80);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}