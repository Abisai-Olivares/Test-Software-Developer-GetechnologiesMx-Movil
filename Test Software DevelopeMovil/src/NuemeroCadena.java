public class NuemeroCadena {
    public static void main(String[] args) {

        String palabraValidar="jj@dud324khsa123h12";
       int  contador=0;
        for (int i = 0; i < palabraValidar.length(); i++){
            char caracterC= palabraValidar.charAt(i);
            if (caracterC > 47  &&  caracterC <58){
                System.out.print(" ["+caracterC+"]");
                contador ++;


            }


        }
        System.out.println("Total de caracteres numericos es  -> "+contador);

    }
}
