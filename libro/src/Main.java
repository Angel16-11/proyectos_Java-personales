import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Opcion 1:Bienvenido a la biblioteca");
        System.out.println("Opcion 2:Do while");
        System.out.println("Ingrese el numero de la opcion que desea realizar: ");
        int opcion = leer.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Bienvenido \n a \n la \n biblioteca");
                System.out.printf("%s%n%s%n","Bienvenido a ", "la programacion en  java");
                break;
            case 2:
                System.out.println("serie numerica bajando en 200");
                int i = 1000;
                do{
                    System.out.print(i+",");
                    i-=200;
                }while (i>=0);
                break;
        }

    }
}