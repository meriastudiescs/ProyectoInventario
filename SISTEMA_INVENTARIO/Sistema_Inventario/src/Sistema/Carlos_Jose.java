package Sistema;

public class Carlos_Jose {

    public static void visualizarInventario(String[] nombres, String[] codigos, int[] cantidades) {
        System.out.println("\n--- Inventario ---");
        boolean inventarioVacio = true;

        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] != null) {
                System.out.println("Producto " + (i + 1) + ": " + nombres[i] + " | Código: " + codigos[i] + " | Cantidad: " + cantidades[i]);
                inventarioVacio = false;
            }
        }

        if (inventarioVacio) {
            System.out.println("El inventario está vacío.");
        }
    }
}



