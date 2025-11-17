import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortTesting{

    public static void printIntArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
    //clase main
    public static void main(String[] args) throws IOException{
        //QuickSortFiles qsFiles = new QuickSortFiles();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        int[] numeros;

        System.out.println("=========================================");
        System.out.println("   PROGRAMA QUICKSORT - ORDENAR NUMEROS   ");
    }
}