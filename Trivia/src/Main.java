//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int puntaje = 0;

        // Pregunta 1
        System.out.println("Pregunta 1: ¿Cuál es la capital de Francia?");
        System.out.println("A) Berlín");
        System.out.println("B) Madrid");
        System.out.println("C) París");
        System.out.print("Tu respuesta: ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("C")) {
            puntaje++;
        }

        // Pregunta 2
        System.out.println("\nPregunta 2: ¿Cuánto es 9 x 8?");
        System.out.println("A) 72");
        System.out.println("B) 81");
        System.out.println("C) 64");
        System.out.print("Tu respuesta: ");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("A")) {
            puntaje++;
        }

        // Pregunta 3
        System.out.println("\nPregunta 3: ¿Quién escribió 'Cien años de soledad'?");
        System.out.println("A) Gabriel García Márquez");
        System.out.println("B) Pablo Neruda");
        System.out.println("C) Mario Vargas Llosa");
        System.out.print("Tu respuesta: ");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("A")) {
            puntaje++;
        }

        // Resultado final
        System.out.println("\nJuego terminado. Tu puntaje es: " + puntaje + "/3");
        if (puntaje == 3) {
            System.out.println("¡Excelente!");
        } else if (puntaje == 2) {
            System.out.println("¡Muy bien!");
        } else {
            System.out.println("Sigue practicando.");
        }


    }
}
