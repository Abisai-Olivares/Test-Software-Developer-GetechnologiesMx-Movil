import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MenuEmpleados {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        DateTimeFormatter formatFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       List <Empleado> empleados = new ArrayList<>();
        int contador=0;
        do {
        System.out.println("[BIENVENIDO AL SISTEMA DE EMPLEADOS]");
        System.out.println("Seleccione una opcion");
        System.out.println("_______________________");
        System.out.println("1) Registrar empleados");
        System.out.println("2) Consulta edad de un empleado");
        System.out.println("3) Consulta de empleados en orden alfabetico ");
        System.out.println("4) Consultar empleados por edad ");
        System.out.println("_______________________");
        int respuesta =teclado.nextInt();




    switch (respuesta){

        case 1:
            Empleado nuevoEmpleado = new Empleado();
            System.out.println("Registrar empleado");
            System.out.println("_______________________");
            System.out.println("Introduce ID");
            nuevoEmpleado.setId(teclado.nextInt());
            System.out.println("Introduce Nombre");
            nuevoEmpleado.setNombre(teclado.next());
            System.out.println("Introduce Apellido Paterno");
            nuevoEmpleado.setApellidoP(teclado.next());
            System.out.println("Introduce Apellido Materno");
            nuevoEmpleado.setApellidoM(teclado.next());
            System.out.println("Introduce Fecha de nacimiento ");
            System.out.println("FORMATO->  dd/MM/yyyy");
            nuevoEmpleado.setFechaNacimiento(teclado.next());
            empleados.add(nuevoEmpleado);

            break;
        case 2:
        /*    for (int i = 0; i < empleados.size(); i++){
                System.out.println(empleados.get(i).nombre);

             } */

            System.out.println("Ingres ID de empleado para consultar edad ");
            int idEdad= teclado.nextInt();
            for (int i = 0; i < empleados.size(); i++){
                if (empleados.get(i).getId()== idEdad){
                    LocalDate fechaN= LocalDate.parse(empleados.get(i).getFechaNacimiento(),formatFecha);
                    Period edad = Period.between(fechaN,LocalDate.now());
                    System.out.println("El empleado "+empleados.get(i).getNombre()+" TIENE "+edad.getYears()+" Años");
                }
                else{
                    System.out.println("El empleado no existe");
                }
            }
            break;
        case 3:
            System.out.println("Empleados por orden alfabético apellido Paterno");
            empleados.sort(Comparator.comparing(Empleado::getApellidoP));
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println("Empleado ["+empleados.get(i).getId()+" ]"+empleados.get(i).getApellidoP()+
                        empleados.get(i).apellidoM+empleados.get(i).nombre);
            }

            break;
        case 4:
            try {
            List edades = new ArrayList();
            System.out.println("Empleados por orden de edad");
            for (int i = 0; i < empleados.size(); i++){
                    LocalDate fechaN= LocalDate.parse(empleados.get(i).getFechaNacimiento(),formatFecha);
                    Period edad = Period.between(fechaN,LocalDate.now());
                    edades.add(edad.getYears());
              //      System.out.println("El empleado "+empleados.get(i).getNombre()+" TIENE "+edad.getYears()+" Años");

            }
           Collections.sort(edades);

            int numlist= 0;

            List<Empleado> empleados2 = empleados;
            do{
                String edadx = empleados2.get(numlist).getFechaNacimiento().charAt(6) + "";
                edadx = edadx + empleados2.get(numlist).getFechaNacimiento().charAt(7);
                edadx = edadx + empleados2.get(numlist).getFechaNacimiento().charAt(8);
                edadx = edadx + empleados2.get(numlist).getFechaNacimiento().charAt(9);
                int  edadn=(LocalDate.now().getYear()-1)-Integer.parseInt(edadx);
                for (int i = 0; i < edades.size(); i++) {
                    if (Integer.parseInt(edades.get(i)+"")== edadn)
                        System.out.println(empleados2.get(i).getNombre());
                   empleados2.remove(empleados2.get(i));
                    i=edades.size();
                }
                numlist++;


            }while(numlist==empleados.size());}
            catch (Exception e){
                System.out.println("Error");
            }
            break;




        default:
            System.out.println("OPCION INCORRECTA");
            break;



    }
        }while (0!=1);

    }



}
