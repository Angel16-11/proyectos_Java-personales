import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Opcion 1: Bienvenido a la biblioteca");
        System.out.println("Opcion 2: Do while");
        System.out.println("Opcion 3: Estructuras repetitivas");
        System.out.println("Opcion 4: Serie de numeros");
        System.out.println("Opcion 5: Sucesión Fibonacci");
        System.out.println("*******************************************************************************************");
        System.out.println("Ingrese el numero de la opcion que desea realizar: ");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Bienvenido \n a \n la \n biblioteca");
                System.out.printf("%s%n%s%n", "Bienvenido a ", "la programación en Java");
                break;
            case 2:
                System.out.println("Serie numérica bajando en 200");
                int i = 1000;
                do {
                    System.out.print(i + ",");
                    i -= 200;
                } while (i >= 0);
                break;
            case 3:
                System.out.println("Serie numérica subiendo en 200");
                int j = 0;
                do {
                    System.out.print(j + ",");
                    j += 200;
                } while (j <= 1000);
                break;
            case 4:
                System.out.println("Escriba qué serie quiere hacer");
                int serie = leer.nextInt();
                if (serie == 1) {
                    System.out.println("Escriba el límite de la serie:");
                    int limite = leer.nextInt();
                    int nume = 1;
                    while (nume <= limite) {
                        System.out.print(nume + ",");
                        nume++;
                    }
                } else if (serie == 2) {
                    j = 99;
                    System.out.println("Serie con for:");
                    for (i = 1; i <= 5; i++) {
                        System.out.print(i + ",");
                        System.out.print(j + ((i < 5) ? "," : ""));
                        j--;
                    }
                    System.out.println("");

                    i = 1;
                    j = 99;
                    System.out.println("Serie con while:");
                    while (i <= 5) {
                        System.out.print(i + ",");
                        System.out.print(j + ((i < 5) ? "," : ""));
                        i++;
                        j--;
                    }

                    i = 1;
                    j = 99;
                    System.out.println("Serie con do while:");
                    do {
                        System.out.print(i + ",");
                        System.out.print(j + ((i < 5) ? "," : ""));
                        i++;
                        j--;
                    } while (i <= 5); // ✅ Corrección de condición
                }
                break;
            case 5:
                System.out.println("Sucesión Fibonacci");
                System.out.println("¿Qué serie desea?");
                serie = leer.nextInt();
                if (serie == 1) {
                    int a = 0, b = 1, c;
                    for (int k = 0; k < 10; k++) { // ✅ Se eliminó <=, ya que genera 11 números
                        System.out.print(a + ",");
                        c = a + b;
                        a = b;
                        b = c;
                    }
                } else if (serie == 2) {
                    int a = 0, b = 1, c, contador = 0;
                    do {
                        System.out.print(a + ",");
                        c = a + b;
                        a = b;
                        b = c;
                        contador++; // ✅ Uso de variable separada para el conteo
                    } while (contador < 10);
                } else if (serie == 3) {
                    int a = 0, b = 1, c, contador = 0;
                    while (contador < 10) {
                        System.out.print(a + ",");
                        c = a + b;
                        a = b;
                        b = c;
                        contador++; // ✅ Uso de variable separada para el conteo
                    }
                }
                break;
            case 6:

        }
        leer.close();
    }
}
