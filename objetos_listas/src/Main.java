//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    static Scanner leer=new Scanner(System.in);
    static Random R=new Random();
    static ArrayList<Empleado>empleados=new ArrayList<>();
    Empleado t=new Empleado();

    public static void main(String[] args) {
        char respuesta='s';
        while (respuesta=='s'||respuesta=='S'){
            int opcion=menu();
            switch(opcion) {
                case 1:
                 char respuestas='s';
                 while (respuestas=='s'||respuestas=='S') {
                     System.out.println("el nombre del empleado:");
                     String nombre = leer.next();
                     System.out.println("el cargo del empleado:");
                     String cargo = leer.next();
                     System.out.println("el sexo del empleado:");
                     char sexo = leer.next().charAt(0);
                     System.out.println("ingrese el salario del empleado");
                     int salario=leer.nextInt();

                     Empleado tempo=new Empleado(nombre,cargo,sexo,salario);
                     empleados.add(tempo);

                     System.out.println("desea crear otro empleado s/n:");
                     respuestas=leer.next().charAt(0);
                 }
                break;
                case 2:
                    System.out.println("eliminar empleado");
                    System.out.println("ingrese el nombre del empleado a eliminar:");
                    String eliminar=leer.next();
                    eliminarEmpleado(eliminar);
                    break;
                case 3:
                    System.out.println("ingrese el nombre del empleado que busca:");
                    String busca=leer.next();
                    buscarEmpleado(busca);
                    break;
                case 4:
                    System.out.println("ingrese el nombre del empleado que desea modificar:");
                    String modificar=leer.next();
                    modificarEmpleado(modificar);
                    break;
                case 5:
                    System.out.println("-------------lista de empleados-------");
                    imprimirEmpleados(empleados);
                    break;
                default:
                    System.out.println("su opcion esta mal");
            }
            System.out.println("desea continuar s/n:");
            respuesta=leer.next().charAt(0);
        }
    }
    public static int menu(){
        System.out.println("1.crear empleado");
        System.out.println("2.eliminar empleado");
        System.out.println("3.buscar empleado:");
        System.out.println("4.modificar empleado");
        System.out.println("5.lista de empleados");
        int opcion=leer.nextInt();
        return opcion;
    }

    public static void imprimirEmpleados(ArrayList<Empleado>empleados){
        for(int i=0;i<empleados.size();i++){
            System.out.print(empleados.get(i));
        }
    }

    public static void buscarEmpleado(String nombre){
        boolean encontrado=false;
        for(Empleado a:empleados){
            if(a.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("el empleado fue encontrado");
                System.out.println(a);
                encontrado=true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("el empleado no se encuentra");
        }
    }

    public static void eliminarEmpleado(String nombre){
        boolean eliminado=false;
        for(int i=0;i<empleados.size();i++){
            if(empleados.get(i).getNombre().equalsIgnoreCase(nombre)){
                empleados.remove(i);
                System.out.println("empleado eliminado exitosamente");
                break;
            }
        }
        if(!eliminado){
            System.out.println("empleado no encontrado!");
        }
    }

    public static void modificarEmpleado(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Empleado encontrado, ingrese los nuevos datos:");
                System.out.print("Nuevo nombre:");
                String nuevoNombre = leer.next();
                System.out.print("Nuevo cargo:");
                String nuevoCargo = leer.next();
                System.out.print("Nuevo sexo (f o m):");
                char nuevoSexo = leer.next().charAt(0);
                System.out.print("Nuevo salario:");
                int nuevoSalario = leer.nextInt();

                empleados.set(i, new Empleado(nuevoNombre, nuevoCargo,  nuevoSexo,nuevoSalario));
                System.out.println("Empleado modificado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }


}