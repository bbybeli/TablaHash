import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TablaHash {

    static class Nodo {
        String nombre;
        Nodo siguiente;
        public Nodo(String nombre) { this.nombre = nombre; }
    }

    static class TablaHashImpl {
        private final Nodo[] tabla;
        private final int tamaño;

        public TablaHashImpl(int tamaño) {
            this.tamaño = tamaño;
            this.tabla = new Nodo[tamaño];
        }

        private int funcionHash(String clave) {
            return Math.abs(clave.hashCode() % tamaño);
        }

        public void insertar(String nombre) {
            int indice = funcionHash(nombre);
            System.out.print("Insertando '" + nombre + "' -> Hash: " + indice);

            Nodo actual = tabla[indice];

            // No existe lista aún
            if (actual == null) {
                tabla[indice] = new Nodo(nombre);
                System.out.println(" [OK]");
                return;
            }

            // Recorremos la lista por duplicados o final
            System.out.print(" [COLISIÓN]");
            while (true) {
                if (actual.nombre.equals(nombre)) {
                    System.out.println(" -> Duplicado, omitido.");
                    return;
                }
                if (actual.siguiente == null) break;
                actual = actual.siguiente;
            }
            actual.siguiente = new Nodo(nombre);
            System.out.println(" -> Agregado.");
        }

        public void mostrarTabla() {
            System.out.println("\n=== TABLA HASH FINAL ===");
            for (int i = 0; i < tamaño; i++) {
                System.out.print("[" + i + "]: ");
                Nodo n = tabla[i];
                if (n == null) System.out.println("(vacío)");
                else {
                    while (n != null) {
                        System.out.print(n.nombre + " -> ");
                        n = n.siguiente;
                    }
                    System.out.println("null");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        files fileManager = new files();

        System.out.print("Nombre del archivo: ");
        String archivo = br.readLine();

        String[] nombres = fileManager.fileToStringArray(archivo);

        if (nombres != null && nombres.length > 0) {
            TablaHashImpl tabla = new TablaHashImpl(Math.max(3, nombres.length / 2));
            for (String nombre : nombres) tabla.insertar(nombre);
            tabla.mostrarTabla();
        }
    }
}
