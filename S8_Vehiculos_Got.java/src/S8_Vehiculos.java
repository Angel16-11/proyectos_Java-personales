import java.util.ArrayList;
import java.util.Scanner;

public class S8_Vehiculos {
    public static void main(String[] args) {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("******************************************************");
            System.out.println("-------------------- MENU VEHICULOS-----------------");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Listar vehículos");
            System.out.println("3. Buscar vehículo por nombre");
            System.out.println("4. Eliminar vehículo por nombre");
            System.out.println("5. Modificar vehículo");
            System.out.println("6. Salir");
            System.out.println("********************************************************");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Vehiculo v = crearVehiculo(sc);
                    lista.add(v);
                    System.out.println("Vehículo agregado.");
                    break;
                case 2:
                    listarVehiculos(lista);
                    break;
                case 3:
                    buscarVehiculo(lista, sc);
                    break;
                case 4:
                    eliminarVehiculo(lista, sc);
                    break;
                case 5:
                    modificarVehiculo(lista, sc);
                    break;
                case 6:
                    System.out.println("gracias por usar el programa...");
                    break;
                default:
                    System.out.println("opcion no valida por favor elija otro.");
            }
        } while (opcion != 6);
    }

    public static Vehiculo crearVehiculo(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();
        return new Vehiculo(nombre, precio, stock);
    }

    public static void listarVehiculos(ArrayList<Vehiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vehículos.");
        } else {
            for (Vehiculo v : lista) {
                System.out.println(v);
            }
        }
    }

    public static void buscarVehiculo(ArrayList<Vehiculo> lista, Scanner sc) {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for (Vehiculo v : lista) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(v);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro el vehículo.");
        }
    }

    public static void eliminarVehiculo(ArrayList<Vehiculo> lista, Scanner sc) {
        System.out.print("Nombre a eliminar: ");
        String nombre = sc.nextLine();
        boolean eliminado = lista.removeIf(v -> v.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("Vehículo eliminado.");
        } else {
            System.out.println("No se encontró el vehículo.");
        }
    }

    public static void modificarVehiculo(ArrayList<Vehiculo> lista, Scanner sc) {
        System.out.print("Nombre del vehículo a modificar: ");
        String nombre = sc.nextLine();
        for (Vehiculo v : lista) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = sc.nextDouble();
                System.out.print("Nuevo stock: ");
                int nuevoStock = sc.nextInt();
                sc.nextLine();
                v.setPrecio(nuevoPrecio);
                v.setStock(nuevoStock);
                System.out.println("Vehículo modificado.");
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }
}
