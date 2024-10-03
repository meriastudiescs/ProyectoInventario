package Sistema;
import java.util.Scanner;

public class Main {
    static String[] nombres = new String[3];
    static String[] codigos = new String[3];
    static int[] cantidades = new int[3];
    static int productosAgregados = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FernandaBD.cargarInventario(nombres, codigos, cantidades);

        int opcion;

        do {

            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar Producto (Clase Moises)");
            System.out.println("2. Visualizar Inventario (Clase Carlos_Jose)");
            System.out.println("3. Actualizar Inventario (Clase Alexander)");
            System.out.println("4. Salir (Clase Fernanda)");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Moises.agregarProducto(scanner, nombres, codigos, cantidades, productosAgregados);
                    productosAgregados++;
                    break;
                case 2:
                    Carlos_Jose.visualizarInventario(nombres, codigos, cantidades);
                    break;
                case 3:
                    Alexander.actualizarInventario(nombres, codigos, cantidades, scanner);
                    break;
                case 4:
                    Fernanda.salir(nombres, codigos, cantidades, scanner); // Pasamos los parámetros necesarios para guardar
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}