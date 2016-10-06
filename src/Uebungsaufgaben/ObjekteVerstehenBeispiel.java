package Uebungsaufgaben;

import java.util.Scanner;

/**
 *
 * @author firedragon4e
 */
class Datum{
    int stunde, minute, sekunde;
    String jahr, monat, tag;
}

public class ObjekteVerstehenBeispiel{
    public static Datum zeitEingabe(Datum objekt, String jahr, String monat){
        objekt.jahr = jahr;
        
        objekt.monat = monat;
        
        System.out.println("Geben Sie tag ein:");
        Scanner input = new Scanner(System.in);
        String inputText = input.next();
        objekt.tag = inputText;
        
        System.out.println("Geben Sie Stunde ein:");
        input = new Scanner(System.in);
        int inputInteger = input.nextInt();
        objekt.stunde = inputInteger;
        
        System.out.println("Geben Sie Minute ein:");
        input = new Scanner(System.in);
        inputInteger = input.nextInt();
        objekt.minute = inputInteger;
        
        System.out.println("Geben Sie Sekunde ein:");
        input = new Scanner(System.in);
        inputInteger = input.nextInt();
        objekt.sekunde = inputInteger;
        
        return objekt;
    }
    
    static void ausgabe(Datum objekt){
        System.out.println("Heute ist der " + objekt.tag + "/" + objekt.monat + "/" + objekt.jahr + " - " + 
                objekt.stunde + ":" + objekt.minute + ":" + objekt.sekunde);
    }
    
    public static void main(String[] args){
        Datum zeit = new Datum();
        String jahr = "2016";
        String monat = "10";
        zeit = zeitEingabe(zeit, jahr, monat);
        ausgabe(zeit);
    }
}
