import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidacionFecha {


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        DateTimeFormatter formatFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("BIENVENIDO A VALIDACION DE FORMATO DE FECHAS");
        System.out.println("________________________________________");

        do {
            System.out.println("Ingresa tu fecha con el debido formato");
            System.out.println("FORMATO [dd/MM/yyyy]");
            String fecha= teclado.next();
            System.out.println("________________________________________");
            try{
                LocalDate.parse(fecha, formatFecha);
                System.out.println("FECHA CON EL FORMATO CORRECTO");
                System.out.println("________________________________________");


            }catch (Exception ex){
                System.out.println("FECHA CON EL FOTMATO INCORRECTO");
                System.out.println("________________________________________");


            }

        }while (true);

        //Se utilizo el try-catch con el motivo de que al momento que el usuario
        // intruduzca una fecha con el formato mal ingresado este solo arroje un mensaje diciendo que esta incorrecto
        // en caso de dejarlo si el try-cath mandaria un error en su consola








    }
}
