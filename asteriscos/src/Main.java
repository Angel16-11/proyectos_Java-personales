import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ejercicio 2 sumatoria!!");
        System.out.print("Ingrese el limite: ");
        int fin = leer.nextInt();
        double sumatoria = 0;

        for (int i = 1; i <= fin; i++) {
            double factorial = 1;
            for (int j = 1; j <= (i + 1); j++) {
                factorial *= j; // Corregido el cálculo del factorial
            }

            int potencia = 1;
            for (int j = 1; j <= (i + 1); j++) {
                potencia *= i; // Corregido el cálculo de la potencia
            }

            double numerador = potencia + 3 * i + 2;
            double ter = numerador / factorial;
            sumatoria += ter;

            System.out.println("n=" + i + ", suma=" + sumatoria);
        }

        System.out.println("Resultado de la sumatoria: " + sumatoria);
    }
}



