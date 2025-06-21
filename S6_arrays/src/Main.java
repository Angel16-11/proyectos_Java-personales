//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner leer=new Scanner(System.in);
    static Random R=new Random();

    public static void main(String[] args) {
        char respuesta='s';
        while(respuesta=='s'|| respuesta=='S'){
            System.out.println("ingrese el tamaño:");
            int size=leer.nextInt();
            int[] numero=new int[size];
            numero=llenarArreglo(size);
            System.out.println("-----------arreglo original---------");
            imprimirArreglo(numero);
            int opcion=menu();
            switch(opcion){
                case 1:
                    System.out.println("-------sumar Arreglos------");
                    System.out.println(sumaArreglo(numero));
                    break;
                case 2:
                    System.out.println("-----------mayor elemento------");
                    System.out.println("el mayor elemento es:"+mayorArreglo(numero));
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("----------busqueda lineal------");
                    System.out.println("ingrese el numero a buscar:");
                    int valorb=leer.nextInt();
                   if( busquedaLinea(numero,valorb)){
                       System.out.println("el numero"+valorb+"si se encunetra");
                }else{
                       System.out.println("el numero"+valorb+"no se encunetra");
                   }
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }//fin del switch
            System.out.print("desea continuar s/n:");
            respuesta=leer.next().charAt(0);
        }
    }

    public static int menu(){
        System.out.println("****************************************************");
        System.out.println("------------------Menu-------------------------");
        System.out.println("1. Sumar Arreglos");
        System.out.println("2.mayor del arreglo");
        System.out.println("3.primos en el arreglo");
        System.out.println("4.buscar numero en el arreglo");
        System.out.println("5.Ordenamiento de arreglos");
        System.out.println("6.Busqueda Binaria");
        System.out.println("************************************************");
        System.out.print("su opcion es:");
        int opcion=leer.nextInt();
        return opcion;
    }

    public static int [] llenarArreglo(int size){
        int []temporal=new int[size];
        for(int i=0;i< temporal.length;i++){
            temporal[i]=1+R.nextInt(10);;
        }
       return temporal;
    }

    public static void imprimirArreglo(int[]x){
        for(int i=0;i<x.length;i++){
            System.out.println("Arreglo "+i+":"+"="+x[i]);
        }

    }

    public static int sumaArreglo(int x[]){
        int suma=0;
        for (int i=0;i<x.length;i++){
            suma+=x[i];
        }
        return suma;
    }

    public static int mayorArreglo(int[] x){
        int mayor=x[0];
        for(int i=0;i<x.length;i++){
            if(x[i]>mayor){
                mayor=x[i];
            }
        }
        return mayor;
    }

    public static boolean busquedaLinea(int x[],int valorb){
        for(int i=0;i<x.length;i++){
            if(x[i]==valorb){
                return true;
            }
        }
        return false;
    }
}