
//opcione 1 se leen 5 numeros entre 1 y 100 y se imprime el menor
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
                Scanner leer = new Scanner (System.in);
                char respuesta='s';
                while (respuesta=='s' || respuesta=='S'){
                    System.out.println("  Menu   ");
                    System.out.println("    1.numero menor     ");
                    System.out.println("    2.en proceso    ");
                    System.out.print("¿Que opcion desea hcaer?:");
                    int opcion=leer.nextInt();
                    if(opcion==1){
                        int contador=1;
                        int menor=101;
                        while(contador<=5){
                            System.out.println("Ingrese numero:");
                            int numero=leer.nextInt();
                            if(numero>=0 && numero<=100){
                                if(numero<menor){
                                    menor=numero;


                                }//


                            }//fin del if comparacion
                            else{
                                menor=menor;
                                System.out.println("Numero fuera de rango");
                            }
                            contador++;
                        }//fin del while con contador
                        System.out.println("El numero menor es:"+menor);
                    }

                }//fin de la opcion 1.


            }//fin del while

        }













