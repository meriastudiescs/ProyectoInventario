package Sistema;
import java.io.*;

public class FernandaBD {

    private static final String ARCHIVO = "inventario.txt";


    public static void guardarInventario(String[] nombres, String[] codigos, int[] cantidades) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (int i = 0; i < nombres.length; i++) {
                if (nombres[i] != null) {
                    writer.write(nombres[i] + "," + codigos[i] + "," + cantidades[i]);
                    writer.newLine();
                }
            }
            System.out.println("Inventario guardado en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }


    public static void cargarInventario(String[] nombres, String[] codigos, int[] cantidades) {
        File archivo = new File(ARCHIVO);

        if (archivo.exists()) {
            System.out.println("Cargando inventario desde el archivo...");
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                int indice = 0;
                while ((linea = reader.readLine()) != null && indice < nombres.length) {
                    String[] datos = linea.split(",");
                    nombres[indice] = datos[0];
                    codigos[indice] = datos[1];
                    cantidades[indice] = Integer.parseInt(datos[2]);
                    indice++;
                }
                System.out.println("Inventario cargado desde el archivo.");
            } catch (IOException e) {
                System.out.println("Error al cargar el inventario: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo de inventario no existe.");
        }
    }
}

