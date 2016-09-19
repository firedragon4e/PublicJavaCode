package Uebungsaufgaben;
import java.util.Arrays;
public class ZahlenSortierenOhneMethode{
    public static void main(String[] args){
        int[] arr = {18, 5, 22, 3, 45, 34};
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + "\t");
        }
    }
}