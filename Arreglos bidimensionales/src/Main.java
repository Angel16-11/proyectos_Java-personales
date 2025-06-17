//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    static Scanner leer=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de filas que desea:");
        int filas=leer.nextInt();
        System.out.print("Ingrese la cantidad de columnas:");
        int columnas=leer.nextInt();
        int[][]numero=new int[filas][columnas];
        int contador=1;

        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                numero[i][j]=contador;
                contador++;
                System.out.print("["+numero[i][j]+"]");
            }
            System.out.println();
        }


    }
}