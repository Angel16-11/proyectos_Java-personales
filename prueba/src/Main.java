//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
                Scanner leer = new Scanner(System.in);

                System.out.println("Ingrese un número entero de más de 5 dígitos:");
                int numero = leer.nextInt();

                // Validación
                if (numero < 100000) {
                    System.out.println("Número incorrecto, debe ser más de 5 dígitos.");
                } else {
                    System.out.println("Salida:");
                    System.out.println(numero);

                    System.out.println("Al revés:");
                    while (numero > 0) {
                        System.out.println(numero % 10); // Obtiene el último dígito
                        numero /= 10; // Reduce el número quitando el último dígito
                    }
                }

                leer.close();
            }
        }

