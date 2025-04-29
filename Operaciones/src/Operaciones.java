
import java.util.Scanner;


public class Operaciones {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        int num_1, num_2, resultado=0;
        int parametro;
        System.out.print("Escriba su primer valor:");
        num_1=leer.nextInt();
        System.out.print("Escriba su segundo valor:");
        num_2=leer.nextInt();
        System.out.print("Escriba su caso:");
        parametro=leer.nextInt();

        switch(parametro) {
            case 1: resultado=num_1+num_2;
                    System.out.print("El resultado de la suma es:"+resultado);
                break;
            case 2: resultado=num_1-num_2;
                    System.out.print("El reusltado de la resta es:"+resultado);
                break;
            case 3: resultado= num_1*num_2;
                    System.out.print("El resultado de la multiplicacion es:"+resultado);
                    break;
            case 4: resultado= num_1/num_2;
                System.out.print("El resultado de la division es:"+resultado);
                break;
            default:System.out.print("Error, La opcion no existe");
                break;




        }


    }
}