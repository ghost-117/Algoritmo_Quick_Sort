import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortTesting{

    public static void printIntArray(int[] array){
        System.out.println("\n--- Contenido del arreglo ---");
        for (int i = 0; i < array.length; i++)
            System.out.println("[" + i + "] = " + array[i]);
        System.out.println("-----------------------------\n");
    }

    public static void main(String[] args) throws IOException{
        QuickSortFiles qsFiles = new QuickSortFiles();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String fileNameOut;
        int[] numeros;

        System.out.println("---------------------------------------");
        System.out.println("   PROGRAMA QUICKSORT - ORDENAR NUMEROS   ");
        
        
        // Leer  el archivo de entrada (txt)
        System.out.print("\nEscribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        numeros = qsFiles.fileToIntArray(fileName);
        
        // Mostrar arreglo original
        System.out.println("\n* ARREGLO ORIGINAL (Sin ordenar) *");
        printIntArray(numeros);
        
        // Aplicar QuickSort
        System.out.println(">>> Aplicando algoritmo QuickSort...\n");
        qsFiles.quickSort(numeros, 0, numeros.length - 1);
        
        // Mostrar arreglo ordenado
        System.out.println("---------ARREGLO ORDENADO-------");
        printIntArray(numeros);
        
        // Guardar resultado en nuevo archivo
        System.out.print("Escribe el nombre del archivo de salida (ordenado): ");
        fileNameOut = bufer.readLine();
        qsFiles.writeIntArrayToFile(fileNameOut, numeros);
        
        System.out.println("\n¡Archivo ordenado guardado exitosamente!");
        System.out.println("Ubicacion: C:\\Archivos\\" + fileNameOut);
        System.out.println("-------");
    }
}