package br.gov.sp.fatec.projetomaven.model.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import br.gov.sp.fatec.projetomaven.Mvp;
import br.gov.sp.fatec.projetomaven.model.UsuarioLogado;

@MappedSuperclass
public abstract class Auditoria {

    String  _inc_usua;    
    Date    _inc_data;

    public Auditoria(){
        if (get_Inc_Usua() == null) {
            set_Inc_Usua( UsuarioLogado.usuario().getNome() ); //Este usuário terá que ser tratado pela aplicação
            set_Inc_Data( Mvp.dateSystem() );
        }
    }

    public String get_Inc_Usua() {
        return _inc_usua;
    }

    public void set_Inc_Usua(String _inc_usua) {
        this._inc_usua = Mvp.left(_inc_usua, 80);
    }

    public Date get_Inc_Data() {
        return _inc_data;
    }

    public void set_Inc_Data(Date _inc_data) {
        this._inc_data = _inc_data;
    }

}