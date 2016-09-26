package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;

/**
 *
 * @author firedragon4e
 */

public class ZahlenSortieren{
    public static int[] setArr(){
//        int[] arr = {18, 5, 22, 3, 45, 34};
        int x = Integer.parseInt(scanner("Wieviele Zahlen enth\u00E4lt die Zahlenfolge?"));
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(scanner("Geben Sie die " + (i+1) + ". Zahl ein!"));
        }
        return arr;
    }
    
    public static int[] check4Bigger(int[] array){
        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i-1]){
                array = tausch(array, i);
            }
        }
        return array;
    }
    
    public static int[] tausch(int[] array, int i){
        int bigger = array[i-1];
//        System.out.println("Gr\u00F6\u00DFere Zahl (" + bigger + ") mit kleinere Zehl (" + array[i] + ") \ntauschen.");
        array[i-1] = array[i];
        array[i] = bigger;
//        System.out.println("Nach dem Tausch bis " + (i+1) + ". Stelle (" + array[i] + ") pr\u00FCfen.");
        array = check4BiggerAfterTausch(array, i);
        return array;
    }
    
    public static int[] check4BiggerAfterTausch(int[] array, int x){
        for(int i = 1; i < x; i++){
            if(array[i] < array[i-1]){
//                System.out.println(array[i] + " ist kleiner als " + array[i-1] + ".\n>> weiter geht's mit dem Tausch!");
                array = tausch(array, i);
            }
        }
        return array;
    }
    
    public static void output(int[] arr){
        System.out.println("******************************************");
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println("\n******************************************");
    }
    
    public static void main(String[] args){
        int[] arr = setArr();
        System.out.println("\t  Gemischte Zahlenfolge");
        output(arr);
        System.out.println();
        arr = check4Bigger(arr);
        System.out.println("\t  Sortierte Zahlenfolge");
        output(arr);
    }
}