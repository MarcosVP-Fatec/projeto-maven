package br.gov.sp.fatec.projetomaven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Mvp {

    /**
     * DATESYSTEM = Função que retorna a data atual do sistema
     * 
     * @param none
     * @return Date
     */
    public static Date dateSystem() {
        return new GregorianCalendar().getTime();
    }

    /**
     * LEFT = Função que retorna a parte esqueda da String
     * 
     * @param String = Texto
     * @param Int    = Tamanho que quer que retorne
     * @return String
     */
    public static String left(String sTexto, int nTam) {
        return sTexto.substring(0, sTexto.length() < nTam ? sTexto.length() : nTam);
    }

    /**
     * TODATE = Função que transforma uma String em data
     * 
     * @param sData = dd/mm/yyyy
     * @return Date
     * @throws ParseException
     */
    public static Date toDate(String sData) throws ParseException {
    
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date data = formato.parse(sData);        //    return (Date) new SimpleDateFormat("dd/MM/yyyy").parse( sData );         
        return data;
    }
    
    public static void printEnd(){

        System.out.println("");
        System.out.println(" FFFFFFFF   AAAAAAAA   TTTTTTTTT   EEEEEEEE   CCCCCCC ");
        System.out.println("FFFFFFFFF  AAAAAAAAAA  TTTTTTTTT  EEEEEEEEE  CCCCCCCCC");
        System.out.println("FFF        AAA    AAA     TTT     EEE        CCC    CC");
        System.out.println("FFFFF      AAAAAAAAAA     TTT     EEEEE      CCC      ");
        System.out.println("FFFFF      AAAAAAAAAA     TTT     EEEEE      CCC      ");
        System.out.println("FFF        AAA    AAA     TTT     EEE        CCC    CC");
        System.out.println("FFF        AAA    AAA     TTT     EEEEEEEEE  CCCCCCCCC");
        System.out.println("FFF        AAA    AAA     TTT      EEEEEEEE   CCCCCCC ");
        System.out.println("");
        System.exit(0);

    }
}