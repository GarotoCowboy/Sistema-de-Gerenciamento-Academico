package br.com.academico.sistema.sistemaacademico.util;

public class Conversor {

    public static Long convertToLong(String num){
        if(isNumeric(num)){
            //System.out.println("entrou");
            return Long.parseLong(num);
        }
        return null;
    }

    public static int convertToInt(String num){
        if(isNumeric(num)) {
            return Integer.parseInt(num);
        }
        //Arrumar esse return
        return 0;
    }

    public static  boolean isNumeric(String strNumber){
        if(strNumber == null) return false;

        return strNumber.matches("^[0-9]+$");
    }
}
