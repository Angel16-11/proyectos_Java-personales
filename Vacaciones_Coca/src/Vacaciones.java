
import java.util.Scanner;

public class Vacaciones {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int antiguedad=0, clave=0;
        String nombre="";
        System.out.println("**************************************************");
        System.out.println("*Bienvenido al sistema de vacaciones de coca-cola*");
        System.out.println("**************************************************");
        System.out.println();
        System.out.println();

        System.out.print("¿Cual es su nombre?:");
        nombre=leer.nextLine();
        System.out.print("¿cuantos años de servicio tiene el trabajador?:");
        antiguedad=leer.nextInt();
        System.out.print("¿Cual es su clave de departamento del trabajador?:");
        clave=leer.nextInt();

        if(clave==1){
            if(antiguedad==1){
                System.out.print("El trabajador "+nombre+ " tiene derecho a 6 dias de vacaciones");
            }else if(antiguedad>=2 && antiguedad<=6){
                System.out.print("El trabajador "+nombre+ " Tiene derecho a 14 dias de vacaciones");
            }else if(antiguedad>=7){
                System.out.print("El trabajador "+nombre+ " tiene derecho a 10 dias de vacaciones");
            }

        }else if(clave==2){
            if(antiguedad==1){
                System.out.print("El trabajador "+nombre+ " tiene derecho a 7 dias de vacaciones");
            }else if(antiguedad>=2 && antiguedad<=6){
                System.out.print("El trabajador "+nombre+ " Tiene derecho a 15 dias de vacaciones");
            }else if(antiguedad>=7){
                System.out.print("El trabajador "+nombre+ " tiene derecho a 22 dias de vacaciones");
            }

        }else if(clave==3){
            if(antiguedad==1){
                System.out.print("El trabajador "+nombre+ " tiene derecho a 10 dias de vacaciones");
            }else if(antiguedad>=2 && antiguedad<=6){
                System.out.print("El trabajador "+nombre+ " Tiene derecho a 20 dias de vacaciones");
            }else if(antiguedad>=7){
                System.out.print("El trabajador "+nombre+ " tiene derecho a 30 dias de vacaciones");
            }

        }else{
            System.out.print("Eror la clave del departamento es incorrecta");

        }


    }
}