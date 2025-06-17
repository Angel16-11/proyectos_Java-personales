import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("******************************************************************************************");
        System.out.println("1. comparar dos nombres");
        System.out.println("2. login");
        System.out.println("*******************************************************************************************");
        System.out.print("que opcion deseas:");
        int opcion = entrada.nextInt();
        entrada.nextLine(); // Consumir el salto de línea pendiente

        switch(opcion) {
            case 1:
                String nombre_uno = "", nombre_dos = "";
                System.out.print("porfavor ingresa el primer nombre:");
                nombre_uno = entrada.nextLine();

                System.out.print("porfavor ingresa el segundo nombre:");
                nombre_dos = entrada.nextLine();

                if(nombre_uno.equalsIgnoreCase(nombre_dos)) {
                    System.out.println("Los nombres son iguales");
                } else {
                    System.out.println("Los nombres son diferentes");
                }
                break;
                
            case 2:
                String usuario = "";
                String clave = "";
                System.out.println("porfavor ingresa el usuario:");
                usuario = entrada.nextLine();
                System.out.print("porfavor ingresa la clave:");
                clave = entrada.nextLine();
                if(usuario.equals("angel") && clave.equals("1234")) {
                    System.out.println("Bienvenido Señor Angel");
                } else {
                    System.out.println("Usuario o clave incorrectos");
                }
                break;
            
            default:
                System.out.println("Opción no válida");
                break;
        }
        
        entrada.close(); // Cerrar el Scanner al finalizar
    }
}