package Uebungsaufgaben;
import java.util.Arrays;

/**
 *
 * @author firedragon4e
 */
public class _17_06_100Zellen{
    
    public static boolean[] reverse(boolean[] zelle){
        for(int i = 0; i < zelle.length; i++){
            for(int j = i; j < zelle.length; j+=i+1){
                zelle[j] = !zelle[j];
            }
        }
        return zelle;
    }
    
    public static void output(boolean[] zelle){
        String txt = "Gefangene der Zellen ";
        int x = 0;
        for(int i = 0; i < zelle.length; i++){
            if(zelle[i] == false){
                txt += i + 1 + ", ";
                x++;
            }
        }
        txt += "d\u00FCrfen gehen.\nInsgesamt ";
        System.out.println(txt + x + " Gefangene sind befreit!");
    }
    
    public static void main(String[] args){
        boolean[] zelle = new boolean[100];
        Arrays.fill(zelle, true);
        zelle = reverse(zelle);
        output(zelle);
    }
}