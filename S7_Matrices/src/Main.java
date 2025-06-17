import java.util.Scanner;
import java.util.Random;

public class Main{
    static Scanner leer=new Scanner(System.in);
    static Random R=new Random();
    public static void main(String[]args){
        int opcion=menu();
        System.out.print("Ingrese la cantidad de filas:");
        int filas=leer.nextInt();
        System.out.print("Ingrese la cantidad de columnas:");
        int columnas=leer.nextInt();
        int[][]numeros=new int[filas][columnas];
        numeros=leerMatriz(filas,columnas);
        imprimirMatriz(numeros);
        char respuesta='s';
        while(respuesta=='s'||respuesta=='S'){
            switch(opcion){
                case 1:
                    System.out.println("-------Suma de los elementos------");
                    imprimirMatriz(numeros);
                    System.out.println("La suma total de los elementos es:"+sumaElementos(numeros));
                    break;
                case 2:
                    System.out.println("--------Suma de filas---------");
                    int[]sumasFilas=SumaFilas(numeros);
                    for(int i=0;i<sumasFilas.length;i++){
                        System.out.println("suma de filas"+(i+1)+":"+sumasFilas[i]);
                    }
                    break;
                case 3:
                    System.out.println("------------Sumas columnas----------");
                    int[]sumascolumnas=sumasColumnas(numeros);
                    for(int i=0;i< sumascolumnas.length;i++){
                        System.out.println("columna"+(i+1)+":"+sumascolumnas[i]);
                    }
                    break;
                case 4:
                    System.out.println("-----------Generar Matriz de pares----------");
                    imprimirMatriz(numerosPares(numeros));
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("------Busqueda lineal-------");
                    System.out.print("Ingrese el numero que desea buscar:");
                    int numeroB=leer.nextInt();
                    if(BusquedaLineal(numeros,numeroB)){
                        System.out.println("El numero "+numeroB+" Si se encuentra");
                    }else{
                        System.out.println("El numero"+numeroB+" No se encuentra");
                    }
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("---------Encontrar el mayor---------- ");
                    System.out.println("el numero mayor es:"+NumeroMayor(numeros));
                    break;
                case 10:
                    break;
                case 11:
                    break;
                default:
                    System.out.println("opcion invaida eliga otra porfavor:");
                    break;
            }
            System.out.print("desea continuar (s/n):");
            respuesta=leer.next().charAt(0);
        }
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
        System.out.println("Ingrese su opcion:");
        int opcion=leer.nextInt();
        return opcion;
    }

    public static int[][]leerMatriz(int f,int c){
        int[][]temporal=new int[f][c];
        for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                temporal[i][j]=1+R.nextInt(10);
            }
        }
        return temporal;
    }

    public static void imprimirMatriz(int[][]x){
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                System.out.print("["+x[i][j]+"]");
            }
            System.out.println();
        }
    }

    public static int sumaElementos(int[][]x){
        int suma=0;
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                suma+=x[i][j];
            }
        }
        return suma;
    }

    public static int[]SumaFilas(int[][]x){
        int[]suma=new int[x.length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                suma[i]+=x[i][j];
            }
        }
        return suma;
    }

    public static int[]sumasColumnas(int[][]x){
        int []suma=new int[x[0].length];
        for(int i=0;i<x[i].length;i++){
            for(int j=0;j<x.length;j++){
                suma[j]+=x[i][j];
            }
        }
        return suma;
    }

    public static int[][] numerosPares(int [][]x){
        int[][]pares=new int[x.length][x[0].length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                if(x[i][j]%2==0){
                    pares[i][j]=x[i][j];
                }else{
                    pares[i][j]=0;
                }
            }
        }
        return pares;
    }

    public static boolean BusquedaLineal(int[][]x,int valorB){
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                if(x[i][j]==valorB){
                    return true;
                }
            }
        }
        return false;
    }

    public static int NumeroMayor(int[][]x){
        int mayor=x[0][0];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                if(x[i][j]>mayor){
                    x[i][j]=mayor;
                }
            }
        }
        return mayor;
    }


}