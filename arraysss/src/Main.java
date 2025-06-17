//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner leer = new Scanner(System.in);
    static Random rand= new Random();


    public class EjemploArreglos {
        public static int[] generarArregloAleatorio(int n) {

            int[] arreglo = new int[n];


            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = rand.nextInt(101); // nextInt(101) da [0..100]
            }


            return arreglo;
        }

        public static void main(String[] args) {
            // 1. Defino el tamaño que quiero (por ejemplo, 5 elementos)
            int tamaño = 5;

            // 2. Llamo al método que genera el arreglo
            int[] miArreglo = generarArregloAleatorio(tamaño);

            // 3. Imprimo el arreglo en pantalla
            System.out.println("Contenido del arreglo generado:");
            for (int i = 0; i < miArreglo.length; i++) {
                System.out.println("índice " + i + " = " + miArreglo[i]);
            }
        }
    }
}



