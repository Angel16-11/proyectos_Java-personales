import java.util.Scanner;
public class Capitulo3 {
    public static void main(String[]args) {
        Empleado emptyEmpleado = new Empleado();
        Empleado juan = new Empleado("Juan", 29589869, 38);
        Empleado matias = new Empleado("Matias", 12511401, 48);

        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre para el primer empleado:");
        String newName=leer.next();
        System.out.print("DNI pra el primer empleado");
        int newDNI=leer.nextInt();
        System.out.print("Edad para el primer empleado:");
        int newage=leer.nextInt();

        emptyEmpleado.setName(newName);
        emptyEmpleado.setAge(newage);
        emptyEmpleado.setDni(newDNI);

        System.out.printf("\n%s tiene %d años y su DNI es %d", emptyEmpleado.getName(), emptyEmpleado.getAge(), emptyEmpleado.getDni() );
        System.out.printf("\n%s tiene %d años y su DNI es %d", juan.getName(), juan.getAge(), juan.getDni() );
        System.out.printf("\n%s tiene %d años y su DNI es %d", matias.getName(), matias.getAge(), matias.getDni() );

        System.out.println(juan.getName() + " trabaja para " + Emplado.Company + " y tiene ");
        Empleado.iamWorking();;

    }
}
