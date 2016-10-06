package Uebungsaufgaben;

import java.util.Scanner;

/**
 *
 * @author firedragon4e
 */
//Eine klasse (Konstruktor) erstellen und beliebige variablen deklarieren
class Datum{
    int stunde, minute, sekunde;
    String jahr, monat, tag;
}

//unsere Hauptklasse
public class ObjekteVerstehenBeispiel{
    //methode muss ein objekt zurückgeben, deshalb "Datum zeitEingabe"
    public static Datum zeitEingabe(Datum objekt, String jahr, String monat){
        //variable jahr ist als parameter übergeben Scanner wird nicht benötigt
        objekt.jahr = jahr;
        
        //variable monat ist ebenfalls als parameter übergeben
        //Scanner wird nicht benötigt
        objekt.monat = monat;
        
        //jeweilige Informationen von Nutzer abfragen und in objekt speichern
        System.out.println("Geben Sie tag ein:");
        Scanner input = new Scanner(System.in);
        //Darauf achten welche Datentyp (int, String, etc) benötigt wird
        String inputText = input.next();
        objekt.tag = inputText;
        
        System.out.println("Geben Sie Stunde ein:");
        input = new Scanner(System.in);
        //Hier muss man z.B. input in int convertieren, dehalb nextInt()
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
        //unser objekt zurückgeben
        return objekt;
    }
    //methode gibt keinen Rückwert, deshalb void
    static void ausgabe(Datum objekt){
        System.out.println("Heute ist der " + objekt.tag + "/" + objekt.monat + "/" + objekt.jahr + " - " + 
                objekt.stunde + ":" + objekt.minute + ":" + objekt.sekunde);
    }
    
    public static void main(String[] args){
        //neues objekt names "zeit" deklarieren
        Datum zeit = new Datum();
        //variablen deklarieren und initialisieren
        String jahr = "2016";
        String monat = "10";
        //objekt zeit als parameter an methode zeitEingabe übergeben
        //und letztendlich objekt initialisieren (Wert zuweisen) 
        zeit = zeitEingabe(zeit, jahr, monat);
        //objekt an methode ausgabe übergeben
        ausgabe(zeit);
    }
}