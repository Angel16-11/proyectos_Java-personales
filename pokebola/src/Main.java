import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        char respuesta='s';
        while (respuesta=='s'|| respuesta=='S'){
            System.out.print("Ingrese el tamaño de la Pokébola (impar recomendado): ");
            int tamaño = leer.nextInt();

            if (tamaño % 2 == 0) {
                tamaño++; // Aseguramos que sea impar
            }

            for (int i = 0; i < tamaño; i++) {
                for (int j = 0; j < tamaño; j++) {
                    // Condición para el borde circular
                    if (i == 0 || i == tamaño - 1 || j == 0 || j == tamaño - 1 || i + j == tamaño / 2 || j - i == tamaño / 2 || i + j == tamaño + tamaño / 2 - 1 || i - j == tamaño / 2) {
                        System.out.print("* ");
                    }
                    // Línea horizontal en el centro
                    else if (i == tamaño / 2) {
                        System.out.print("- ");
                    }
                    // Centro de la Pokébola (el botón)
                    else if (i == tamaño / 2 && j == tamaño / 2) {
                        System.out.print("O ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println("desea continuar s/n");
            respuesta=leer.next().charAt(0);
            leer.close();
        }

    }
}

