//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int
        Cuenta miCuenta=new Cuenta();
        System.out.println("el nombre incial es:"+miCuenta.obtenerNombre());
        System.out.println("introduzca el nombre");
        String elNombre=leer.nextInt();
        miCuenta.establecerNombre(elNombre);
        System.out.println();
        System.out.println("el nombre en el objeto de mi cuenta es :");
        System.out.println(miCuenta.obtenerNombre());
    }
}