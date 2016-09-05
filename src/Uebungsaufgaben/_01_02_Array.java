package Uebungsaufgaben;
import java.util.Scanner;

/**
 * @author firedragon4e
 */
public class _01_02_Array{
    
    public static String scanner(){
        Scanner input = new Scanner(System.in);
        String eingabe = input.nextLine();
        return eingabe;
    }
    
    public static int anzahlPersonen(String txt){
        System.out.println(txt);
        int zeilen = Integer.parseInt(scanner());
        return zeilen;
    }
    
    public static String[] nameArrayErstellen(int i){
        String[] arr = new String[i];
        return arr;
    }
    
    public static double[] koerpergroesseArrayErstellen(int i){
        double[] arr = new double[i];
        return arr;
    }
    
    public static String nameEingeben(int i, String txt1, String txt2){
        System.out.println(txt1 + (i+1) + txt2);
        String name = scanner();
        return name;
    }
    
    public static double koerpergroesseEingeben(String txt){
        System.out.println(txt);
        double groesse = Double.parseDouble(scanner());
        return groesse;
    }
    
    public static int setX(String input){
        int x, y;
        x = input.length();
        y = x/8;
        return y;
    }
    
    public static int getMaxParts(int[] x){
        int a = x[0], b;
        for (int i : x){
            b = i;
            if(a < b){
                a = b;
            }
        }
        return a;
    }
    
    public static String mkDynamic(String txtBase, String txtExtend, int x){
        String dynTxt = txtBase;
        for(int i = 0; i <= x; i++){
            dynTxt += txtExtend; 
        }
        return dynTxt;
    }
    
    public static double durchschnittErmitteln(double[] groesse){
        double durchschnitt, summe = 0.0;
        for(double i : groesse){
            summe += i;
        }
        durchschnitt = (summe / groesse.length) * 100;
        int d2i = (int) durchschnitt;
        durchschnitt = (double) d2i / 100;
        return durchschnitt;
    }
    
    public static void ausgabeTabelle(int[] x, int mp, String[] name, double[] groesse, double avg){
        String txtBaseH = "========================";
        String txtExtendedH = "========";
        String txtBaseT = "\t";
        String txtExtendedT = "\t";
        System.out.println("Name" + mkDynamic(txtBaseT, txtExtendedT, (mp)) + "|    K\u00F6rpergr\u00F6\u00DFe");
        System.out.println(mkDynamic(txtBaseH, txtExtendedH, (mp)));
        for(int i = 0; i < name.length; i++){
            int mkDyn = mp - x[i];
            System.out.println(name[i] + mkDynamic(txtBaseT, txtExtendedT, mkDyn) + "|    " + groesse[i] + " m");
        }
        System.out.println(mkDynamic(txtBaseH, txtExtendedH, (mp)));        
        System.out.println("Durchschnitt:" + mkDynamic(txtBaseT, txtExtendedT, (mp-1)) + "|    " + avg + " m");
    }
    
    public static void main(String[] args){
        String txt1 = "Geben Sie Anzahl der Personen ein!";
        String txt2 = "Geben sie den ";
        String txt3 = ". Namen ein!";
        String txt4 = "Geben sie die K\u00F6rpergr\u00F6sse ein!";
        int anzahl = anzahlPersonen(txt1);
        int[] x = new int[anzahl];
        String[] name = nameArrayErstellen(anzahl);
        double[] koerpergroesse = koerpergroesseArrayErstellen(anzahl);
        for(int i = 0; i < name.length; i++){
            name[i] = nameEingeben(i, txt2, txt3);
            x[i] = setX(name[i]);
            koerpergroesse[i] = koerpergroesseEingeben(txt4);
        }
        int mp = getMaxParts(x);
        double avg = durchschnittErmitteln(koerpergroesse);
        ausgabeTabelle(x, mp, name, koerpergroesse, avg);
    }
}