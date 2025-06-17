
public class Main {
    public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;

        // Definir los números resaltados
        int[][] resaltados = {
                {0, 0}, {0, 2}, {0, 4}, {1, 1}, {1, 3},
                {2, 0}, {2, 2}, {2, 3}, {2, 4}, {3, 1},
                {3, 3}, {4, 0}, {4, 2}, {4, 4}
        };

        // Imprimir la cuadrícula
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (esResaltado(i, j, resaltados)) {
                    System.out.print("[*] "); // Representa los números resaltados
                } else {
                    System.out.print("[ ] "); // Representa una celda vacía
                }
            }
            System.out.println();
        }
    }

    public static boolean esResaltado(int i, int j, int[][] resaltados) {
        for (int[] par : resaltados) {
            if (par[0] == i && par[1] == j) {
                return true;
            }
        }
        return false;
    }
}
