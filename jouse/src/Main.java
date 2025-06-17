
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        char respuesta = 's';
        while (respuesta == 's' || respuesta == 'S'){
            System.out.println("********Menu********");
            System.out.println("1. Asterisco de Asteriscos");
            System.out.println("2. Sumatoria de Funcion");
            System.out.println("3. Factorial de Sumatoria");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de Filas:");
                    int filas = leer.nextInt();
                    int si=1;
                    if (filas % 2 != 0){
                        si = 0;
                    }
                    while (si!=0){
                        System.out.println("Ingrese un número unicamente impar");
                        filas = leer.nextInt();
                        if (filas % 2 != 0)
                            si = 0;
                    }
                    for (int i=0; i<filas; i++){
                        for (int j=0; j<=(filas); j++){
                            if (i==j){
                                System.out.print("*");
                            }

                            else if (i==filas/2)
                                System.out.print("*");
                            else if (j==filas/2+1){
                                System.out.print("*");
                            }
                            else if (i==filas/2 && j==filas/2+1)
                                System.out.print("*");
                            else if (i+j==filas && i!= filas/2 && i!=filas && j!=filas/2){
                                System.out.print("*");
                            }
                            else if (i>=filas/2 && j==0)
                                System.out.print("");
                            else if (j==(filas/2) && i>=filas/2)
                                System.out.print(" ");
                            else if (j==filas/2 && i<filas/2)
                                System.out.print("");
                            else if (j==filas/2){
                                System.out.print("*");
                            }
                            else if(j!=filas/2 && j!=filas&& j!=i)
                                System.out.print(" ");

                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el Limite:");
                    int limite = leer.nextInt();
                    double suma = 0;
                    for (int i=1; i<=limite; i++){
                        double fact = 1;
                        for (int j=1; j<=i+1; j++){
                            fact = fact*j;
                        }
                        suma = suma + (((i*i)+(3*i)+2)/(fact));
                        System.out.println("n = "+i+", suma = "+suma+"  ");
                    }
                    System.out.println("El Resultado de la Sumatoria es "+suma);

                    break;
                case 3:
                    System.out.println("Ingrese el limite");
                    int limite2 = leer.nextInt();
                    while (limite2 < 1 || limite2 > 2){
                        System.out.println("Ingrese un Numero Correcto(1 o 2)");
                        limite2 = leer.nextInt();
                    }
                    int sumatoria = 0;
                    for (int i=1; i<=limite2; i++){
                        sumatoria = sumatoria + (i*(i+1));
                    }
                    System.out.println("Sumatoria = "+sumatoria);
                    int factorial = 1;
                    for (int j=sumatoria; j>1; j--){
                        factorial = factorial * j;
                        System.out.println(factorial);
                    }

                    break;
                default:
                    throw new AssertionError();

            }
            respuesta = leer.next().charAt(0);
        }

    }

}
