package Sistema;
import java.util.Scanner;

public class Moises {

    public static void agregarProducto(Scanner scanner, String[] nombres, String[] codigos, int[] cantidades, int productosAgregados) {
        System.out.println("\nAgregar Producto " + (productosAgregados + 1) + ":");

        System.out.print("Ingrese el nombre del producto: ");
        nombres[productosAgregados] = scanner.nextLine();

        System.out.print("Ingrese el código del producto: ");
        codigos[productosAgregados] = scanner.nextLine();

        System.out.print("Ingrese la cantidad inicial: ");
        cantidades[productosAgregados] = scanner.nextInt();
        scanner.nextLine();
    }
}


