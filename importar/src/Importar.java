
import java.util.Scanner;

public class Importar {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String nombre="";
        int num_1=0,num_2=0,resultado=0;
        System.out.print("¿cual es tu nombre?");
        nombre= leer.nextLine();

        System.out.print("Dame el primer valor para tu suma:");
        num_1= leer.nextInt();

        System.out.print("Dame el segundo valor para tu suma:");
        num_2=leer.nextInt();

        resultado=num_1+num_2;
        System.out.println("Hola "+nombre + " el resultado de su suma es:"+resultado);




    }
}