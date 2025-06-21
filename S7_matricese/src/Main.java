//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;
public class Main {
    static Scanner leer=new Scanner(System.in);
    static Random R=new Random();

    public static void main(String[] args) {
    int opcion=menu();
    char respuesta='s';
    while(respuesta=='s'||respuesta=='S') {
        System.out.println("ingrese el numero de filas:");
        int filas = leer.nextInt();
        System.out.println("ingrese el numero de columnas:");
        int columnas = leer.nextInt();
        int[][] numero = new int[filas][columnas];
        numero = llenarMatriz(filas, columnas);
        System.out.println("----matriz original-------");
        imprimirMatriz(numero);
        switch (opcion) {
            case 1:
                System.out.println("--------suma de la matriz------");
                int[] sumas = sumaFilas(numero);
                for (int i = 0; i < sumas.length; i++) {
                    System.out.println("Suma de la fila " + (i + 1) + " : " + sumas[i]);
                }
                break;
            case 2:
                System.out.println("---suma de columnas----");
                int[]sumac=sumaColumna(numero);
                for(int i=0;i<sumac.length;i++){
                    System.out.println("suma de columna:"+(i+1)+":"+sumac[i]);
                }
                break;



        }//fin del swtich
        System.out.print("desea contiuar s/n:");
        respuesta=leer.next().charAt(0);
    }//fin del while respuesta de ususario

    }

    public static int menu(){
        System.out.println("********************************************");
        System.out.println("------------------ MENU --------------------");
        System.out.println("1. Suma de todos los elementos");
        System.out.println("2. Suma de filas");
        System.out.println("3. Suma de columnas");
        System.out.println("4. Generar matriz de pares");
        System.out.println("5. Sumar diagonales");
        System.out.println("6. Ordenar matriz");
        System.out.println("7. Busqueda lineal");
        System.out.println("8. Ordenamiento de una sola fila");
        System.out.println("9. Encontrar el mayor ");
        System.out.println("10. Transpuesta");
        System.out.println("11. Multiplicacion de matrices");
        System.out.println("12. Salir");
        System.out.println("********************************************");
        System.out.print("Ingrese su opcion : ");
        int opcion=leer.nextInt();
        return opcion;
    }

    public static int[][]llenarMatriz(int f,int c){
        int temporal[][]=new int[f][c];
        for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                temporal[i][j]=1+R.nextInt(20);
            }
        }
        return temporal;
    }

    public static void imprimirMatriz(int [][]x){
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                System.out.print("["+x[i][j]+"]");
            }
            System.out.println();
        }
    }

    public static int sumaElementos(int x[][]){
        int suma=0;
        for(int i=0;i< x.length;i++){
            for(int j=0;j<x[i].length;j++){
                suma+=x[i][j];
            }
        }
        return suma;
    }

    public static int[]sumaFilas(int x[][]){
        int []sumas=new int[x.length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                sumas[i]=x[i][j];
            }
        }
        return sumas;
    }

    public static int[]sumaColumna(int x[][]){
        int []suma=new int[x[0].length];
        for(int i=0;i<x[i].length;i++){
            for(int j=0;j<x.length;j++){
                suma[i]=x[i][j];
            }
        }
        return suma;
    }
}