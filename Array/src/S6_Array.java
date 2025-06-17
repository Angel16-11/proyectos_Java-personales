
import java.util.Scanner;
import java.util.Random;

public class S6_Array{
    static Scanner leer=new Scanner(System.in);
    static Random R=new Random();

    public static void main(String[]args){
       char respuesta='s';
       while (respuesta=='s'||respuesta=='S'){
           System.out.println("Ingrese su tamaño:");
           int size=leer.nextInt();
           System.out.println();
           int []numeros=new int[size];
           numeros=leerArreglos(size);
           System.out.println("----Arreglo original------");
           imprimirArreglo(numeros);
           System.out.println("***********************************************");
           System.out.println("------------------Menu-------------------------");
           System.out.println("1. Sumar Arreglos");
           System.out.println("2.mayor del arreglo");
           System.out.println("3.primos en el arreglo");
           System.out.println("4.buscar numero en el arreglo");
           System.out.println("5.Ordenamiento de arreglos");
           System.out.println("6.Busqueda Binaria");
           System.out.println("7.Parametros Interclados");
           System.out.println("************************************************");
           System.out.print("su opcion es:");
           int opcion= leer.nextInt();
           switch(opcion){
               case 1:
                   System.out.println("---segundo arreglo----");
                   int []numeros2=new int[size];
                   numeros2=leerArreglos(size);
                   imprimirArreglo(numeros2);
                   imprimirArreglo(sumarArreglos(numeros,numeros2));
                   break;
               case 2:
                   System.out.println("----------mayor del arreglo-----------");
                   System.out.println("El mayor elemento es:"+MayorElemento(numeros));
                   break;
               case 3:
                   System.out.println("---------Primos en el arreglo-------");
                   numerosPrimos(numeros);
                   break;
               case 4:
                   System.out.println("---------------BuscarNumero-------");
                   System.out.println("Ingrese el numero a buscar:");
                   int numeroB=leer.nextInt();
                   if (busqueda(numeros,numeroB)){
                       System.out.println("El numero si se encuentra");
                   }else{
                       System.out.println("El numero no se encuentra");
                   }
                   break;
               case 5:
                   break;
               case 6:
                   break;
               case 7:
                   break;
               default:
                   break;
           }//fin del switch
           System.out.println("Desea volver a hacer el programa(s/n):");
           respuesta=leer.next().charAt(0);
       }//fin del while respuesta de ususario
    }
    public static int[]leerArreglos(int x){
        int []temporal=new int[x];
        for(int i=0;i<temporal.length;i++){
            temporal[i]=R.nextInt(10);
        }
        return temporal;
    }

    public static void imprimirArreglo(int[]x){
        for(int i=0;i<x.length;i++){
            System.out.println("Arreglo"+"["+i+"]"+"="+x[i]);
        }
    }

    public static int[] sumarArreglos(int []a,int[]b){
        int[]suma=new int[a.length];
        for(int i=0;i<a.length;i++){
            suma[i]=a[i]+b[i];
        }
        return suma;
    }

    public static int MayorElemento(int[]x){
        int mayor=x[0];
        for(int i=0;i<x.length;i++){
            if(x[i]>mayor){
                mayor=x[i];
            }
        }
        return mayor;
    }

    public static int[] numerosPrimos(int[]x){
        int contador=0;
        for(int i=0;i<x.length;i++){
            if(Esprimo(x[i])){
                contador++;
            }
        }
        int[]arreglosPrimos=new int[contador];
        int j=0;
        for(int i=0;i<x.length;i++){
            arreglosPrimos[j]=x[i];
            j++;
        }
        return arreglosPrimos;
    }

    public static boolean Esprimo(int x){
        int contadorDivisores=0;
        for(int i=0;i<x;i++){
            if(x%i==0){
                contadorDivisores++;
            }
        }
        if(contadorDivisores==2){
            return true;

        }else{
            return false;
        }
    }

    public static boolean busqueda(int[]x,int valorB){
        for(int i=0;i<x.length;i++){
            if(x[i]==valorB){
                return true;
            }
        }
        return false;
    }

}