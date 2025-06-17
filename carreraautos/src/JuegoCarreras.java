//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Scanner;

public class JuegoCarreras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¡Preparados, estén listos!");

        System.out.print("Ingresa tu nombre: ");
        String jugadorNombre = scanner.nextLine();

        while (true) {
            System.out.println("\nPresiona ENTER para acelerar...");
            scanner.nextLine(); // Espera que el usuario presione Enter

            int velocidadJugador = random.nextInt(41) + 87; // Entre 87 y 127
            int velocidadOponente = random.nextInt(41) + 70; // Entre 70 y 110

            System.out.println("\nAcelerando...\n");

            System.out.print(jugadorNombre + ": ");
            for (int i = 0; i < velocidadJugador; i++) {
                System.out.print("=");
            }
            System.out.println();

            System.out.print("Oponente: ");
            for (int i = 0; i < velocidadOponente; i++) {
                System.out.print("=");
            }
            System.out.println();

            if (velocidadJugador > velocidadOponente) {
                System.out.println("¡Ganaste la carrera!");
            } else if (velocidadJugador < velocidadOponente) {
                System.out.println("¡Perdiste la carrera!");
            } else {
                System.out.println("¡Empate!");
            }

            System.out.print("\n¿Quieres jugar de nuevo? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                System.out.println("¡Gracias por jugar!");
                break;
            }
        }

        scanner.close();
    }
}
