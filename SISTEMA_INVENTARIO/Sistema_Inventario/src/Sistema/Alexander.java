package Sistema;
import java.util.Scanner;


public class Alexander {


    public static void actualizarInventario(String[] nombres, String[] codigos, int[] cantidades, Scanner scanner) {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Reducir stock (producto vendido)");
        System.out.println("2. Agregar más stock (nueva cantidad disponible)");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el código del producto: ");
        String codigoBuscado = scanner.nextLine();

        int indiceProducto = -1;
        for (int i = 0; i < 3; i++) {
            if (codigos[i] != null && codigos[i].equals(codigoBuscado)) {
                indiceProducto = i;
                break;
            }
        }

        if (indiceProducto == -1) {
            System.out.println("Producto no encontrado. ¿Desea agregar un nuevo producto? (S/N)");
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("S")) {
                agregarNuevoProducto(nombres, codigos, cantidades, scanner);
            } else {
                System.out.println("Operación cancelada.");
            }
            return;
        }

        if (opcion == 1) {
            reducirStock(cantidades, indiceProducto, scanner);
        } else if (opcion == 2) {
            agregarStock(cantidades, indiceProducto, scanner);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void reducirStock(int[] cantidades, int indice, Scanner scanner) {
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();

        if (cantidades[indice] >= cantidadVendida) {
            cantidades[indice] -= cantidadVendida;
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Cantidad insuficiente en stock.");
        }
    }

    private static void agregarStock(int[] cantidades, int indice, Scanner scanner) {
        System.out.print("Ingrese la cantidad a agregar: ");
        int cantidadAgregada = scanner.nextInt();

        cantidades[indice] += cantidadAgregada;
        System.out.println("Stock actualizado. Nueva cantidad: " + cantidades[indice]);
    }

    private static void agregarNuevoProducto(String[] nombres, String[] codigos, int[] cantidades, Scanner scanner) {

        int indiceDisponible = -1;
        for (int i = 0; i < 3; i++) {
            if (nombres[i] == null) {
                indiceDisponible = i;
                break;
            }
        }

        if (indiceDisponible != -1) {
            System.out.print("Ingrese el nombre del nuevo producto: ");
            nombres[indiceDisponible] = scanner.nextLine();

            System.out.print("Ingrese el código del nuevo producto: ");
            codigos[indiceDisponible] = scanner.nextLine();

            System.out.print("Ingrese la cantidad inicial del producto: ");
            cantidades[indiceDisponible] = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nuevo producto agregado correctamente.");
        } else {
            System.out.println("El inventario está lleno, no se pueden agregar más productos.");
        }
    }
}

