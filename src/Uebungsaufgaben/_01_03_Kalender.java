package Uebungsaufgaben;

import java.util.Scanner;
//import static MiniPrograms.GetStringLength.setStringLengthFromInput;
import static MiniPrograms.StringMultiplier.multiply;

/**
 *
 * @author firedragon4e
 */

public class _01_03_Kalender{
    public static String getInput(String txt){
        System.out.println(txt);
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        return input;
    }
    
    public static int setDate(String input, int x, int xx){
        String dateString = new String(input.substring(x, xx));
        int date = Integer.parseInt(dateString);
        /* 
         *  Nullen werden gelöscht, arbeite an andere methode.
         */
//        System.out.println(date);
        return date;
    }
    
    public static void main(String[] args){
        Kalender k1;
        k1 = new Kalender();
        
        String txt, trenner1, trenner2, ifNot;
        txt = "Geben Sie das Datum in folgendem Format ein. \"dd.mm.yyyy\"";
//        int length = setStringLengthFromInput(txt);
        int length = 55;
        ifNot = " (wenn leer => Enter)";
        trenner1 = multiply("=", length);
        trenner2 = multiply("-", length);
        
        String userInput = getInput(txt);
        k1.tag = setDate(userInput, 0, 2);
        k1.monat = setDate(userInput, 3, 5);
        k1.jahr = setDate(userInput, 6, 10);
        System.out.println(k1.tag+"."+k1.monat+"."+k1.jahr);
        
        k1.titel = getInput("Geben Sie einen Titel ein!" + ifNot);
        k1.inhalt = getInput("Eventuell ein Inhalt?!" + ifNot);
        k1.ort = getInput("Am welchen Ort?!" + ifNot);
        System.out.println("Sie haben folgendem Termin f\u00FCr den " + 
                k1.tag + "." + k1.monat  + "." + k1.jahr + " erstellt:\n" + 
                trenner1 + "\nTitel:\n>>\t" + k1.titel + "\n" + trenner2 + 
                "\nInhalt:\n>>\t" + k1.inhalt + "\n" + trenner2  + "\nOrt:\n>>\t" + k1.ort);
    }
}