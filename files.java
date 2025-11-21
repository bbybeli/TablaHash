import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class files {

    private File getFile(String name) {
        File f = new File("C:\\archivos\\" + name);
        if (!f.exists()) {
            System.out.println(" [ERROR DE RUTA] No encuentro el archivo: " + f.getAbsolutePath());
        }
        return f;
    }

    public int countFileLines(String fileName) {
        File file = getFile(fileName);
        if (!file.exists()) return 0;

        int numLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null) numLines++;
        } catch (IOException e) {
            System.out.println("Error al contar líneas: " + e);
        }
        return numLines;
    }

    public int[] fileToIntArray(String fileName) {
        File file = getFile(fileName);
        int lines = countFileLines(fileName);
        if (lines == 0) return null;

        int[] array = new int[lines];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                array[i++] = Integer.parseInt(linea.trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Se esperaban números.");
        } catch (IOException e) {
            System.out.println("Error leyendo enteros: " + e);
        }
        return array;
    }

    public String[] fileToStringArray(String fileName) {
        File file = getFile(fileName);
        int lines = countFileLines(fileName);
        if (lines == 0) return null;

        String[] array = new String[lines];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                array[i++] = linea.trim();
            }
        } catch (IOException e) {
            System.out.println("Error leyendo strings: " + e);
        }
        return array;
    }
}