package br.gov.sp.fatec.projetomaven.model.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.gov.sp.fatec.projetomaven.Mvp;

@Table(name = "usu_usuario")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column=@Column(name="usu_id"))
public abstract class Usuario extends IdPadrao {

    @Column(name = "usu_nome_usuario")  private String  nomeUsuario;
    @Column(name = "usu_senha")         private String  senha;

    public Usuario(){}
    public Usuario(String nomeUsuario, String senha){
        setNomeUsuario(nomeUsuario);
        setSenha(senha);
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