package br.gov.sp.fatec.projetomaven;

import java.util.Date;
import java.util.GregorianCalendar;

public class Mvp {

    /**
     * Função que retorna a data atual do sistema
     * @param none
     * @return Date
     */
    public static Date dateSystem(){
        return new GregorianCalendar().getTime();
    }

    /**
     * Função que retorna a parte esqueda da String
     * @param String = Texto
     * @param Int = Tamanho que quer que retorne
     * @return String
     */
    public static String left( String sTexto , int nTam){
        return sTexto.substring( 0 , sTexto.length() < nTam ? sTexto.length() : nTam );
    }


    
}
