package Uebungsaufgaben;
import java.util.Arrays;

/**
 *
 * @author firedragon4e
 */
public class _17_06_100Zellen{
    
    public static boolean[] getCrazy(boolean[] zelle){
        for(int i = 0; i < zelle.length; i++){
            for(int j = i; j < zelle.length; j+=i+1){
//            int x = i;
//            for(int j = 0; j < zelle.length; j++){
//                x += j;
//                if(x > 99){
//                    break;
//                }
//                System.out.print(j + " ");
                zelle[j] = !zelle[j];
            }
//            System.out.println();
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
        zelle = getCrazy(zelle);
        output(zelle);
    }
}