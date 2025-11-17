import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class QuickSortFiles{

    int countFileLines(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        int numLines = 0;

        try{
            file = new File("C:\\archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            while ( (bufer.readLine()) != null ){
                numLines++;
            }
            reader.close();
        }catch( Exception e ) {
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return numLines;
    }

    // Método QuickSort principal - Divide y conquista
    public void quickSort(int[] array, int inicio, int fin){
        if (inicio < fin){
            int indicePivote = partition(array, inicio, fin);
            quickSort(array, inicio, indicePivote - 1);  // Ordena parte izquierda
            quickSort(array, indicePivote + 1, fin);     // Ordena parte derecha
        }
    }

    // Método partition - Reorganiza el arreglo usando pivote
    private int partition(int[] array, int inicio, int fin){
        int pivote = array[fin];  // Último elemento como pivote
        int i = inicio - 1;       // Índice del elemento menor
        
        for (int j = inicio; j < fin; j++){
            if (array[j] <= pivote){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, fin);
        return i + 1;
    }

    // Método auxiliar para intercambiar elementos
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Leer archivo y convertir a arreglo de enteros
    public int[] fileToIntArray(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        int[] array = null;
        int i = 0;
        int t;
        
        try{
            t = countFileLines(fileName);
            array = new int[t];
            file = new File("C:\\archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            
            while ( (linea = bufer.readLine()) != null ){
                array[i] = Integer.parseInt(linea);
                i++;
            }
            reader.close();
        } catch( Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }

    // Escribir arreglo ordenado a archivo
    public void writeIntArrayToFile(String fileName, int[] array){
        FileWriter file;
        PrintWriter writer;
        
        try{
            file = new FileWriter("c:\\archivos\\" + fileName);
            writer = new PrintWriter(file);
            for ( int unDato : array )
                writer.println(unDato);
            file.close();
        } catch ( Exception e) {
            System.out.println("Error al crear el archivo: " + e.toString());
        }
    }

}