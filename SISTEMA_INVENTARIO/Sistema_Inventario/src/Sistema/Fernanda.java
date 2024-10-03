package Sistema;
import java.util.Scanner;

public class Fernanda {

    public static void salir(String[] nombres, String[] codigos, int[] cantidades, Scanner scanner) {
        System.out.println("\n¿Desea guardar el inventario antes de salir? (S/N): ");
        String respuesta = scanner.nextLine().toUpperCase();

        if (respuesta.equals("S")) {

            FernandaBD.guardarInventario(nombres, codigos, cantidades);
            System.out.println("Inventario guardado correctamente.");
        } else {
            System.out.println("No se guardaron los cambios.");
        }

        System.out.println("Saliendo del sistema...");
    }
}
