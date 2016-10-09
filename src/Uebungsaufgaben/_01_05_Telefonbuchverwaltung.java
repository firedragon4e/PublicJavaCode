package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;
import java.nio.file.*;
import java.io.*;

/**
 *
 * -->>Telefonbuch Verwaltung, Einträge aus Datei lesen!<<--
 * 
 * >>Front-End:
 * 
 * Einträge im Telefonbuch:
 * 
 *      - eintragen,
 *      - ersetzen,
 *      - suchen(nach un-/vollständiger Name),
 *      - komplett ausgeben.
 * 
 * >>Back-End:
 * 
 * Einträge werden:
 * 
 *      - von einer Datei ausgelesen,
 *      - nach Änderungen/Erstellung in einer Datei gespeichert.
 * 
 * Falls die Datei nicht vorhanden ist, wird eine neue erstellt.
 * Beim einlesen und einfügen werden Einträge in der Datei nach ID-Nr. sortiert und gespeichert,
 * falls diese z.B. manuel vom Nutzer geändert wurden.
 * 
 * @author firedragon4e
 * 
 * © Bardia Dehghanpour 2016
 * 
 */

public class _01_05_Telefonbuchverwaltung{
    private static String DEF_PATH = ".//src//Uebungsaufgaben//";
    private static String DEF_NAME = "Kontakte";
    private static final String DEF_EXT = ".txt";
    private static final String DEF_NEW = "_new_";
    private static int GEN_NUM = 0;
    private static String PATH = DEF_PATH + DEF_NAME + DEF_EXT;
    static Eintrag[] telefonbuch;
    private static final int MAX_EINTRAEGE = 10;
    private static int anzahlEintraege = 0;
    private static final String POSITIV = "j";
    private static final String LEER = "";
    private static String answer;
    private static boolean oneMore = false, again = true;
    private static int zeile = 1;
    
    static void mkFile(String extend, String x){
        Path path;
        String input;
        input = scanner("\n\nWie soll die zu ertellende Datei hei\u00DFen?\n"
                + "Um den standard Name \"Kontakte\" zu nehmen, dr\u00FCcken sie einfach Enter.\n");
        if(!input.equals(LEER)){
            DEF_NAME = input;
        }
        input = scanner("In welchem Pfad soll die datei gespeichert werden?\n"
                + "(Standard Pfad ist \".\\src\\Uebungsaufgaben\\\")\n"
                + "Um Standard Pfad zu nehmen, dr\u00FCcken sie einfach Enter.\n"
                + "Format einhalten um Konflikte zu vermeiden!\n"
                + "(z.B.: C:\\dieser Ordner\\)");
        if(!input.equals(LEER)){
            input = input.replace("\\", "//");
            DEF_PATH = input;
            PATH = DEF_PATH + DEF_NAME + DEF_EXT;
            path = Paths.get(PATH);
            System.out.println("did");
        }else{
            path = FileSystems.getDefault().getPath(DEF_NAME + DEF_EXT);
            System.out.println("Die Datei '" + DEF_NAME + DEF_EXT + 
                    "' wurde unter dem standard Pfad erstellt!");
        }
        if(!Files.exists(path) || !extend.equals(LEER)){
            try{
                Path newPath = Paths.get(DEF_PATH + DEF_NAME + extend + "_" + x + DEF_EXT);
                GEN_NUM++;
                Files.createFile(newPath);
                System.out.println("Datei \"" + newPath + "\" erfolgreich erstellt");
            }catch(FileAlreadyExistsException ex){
                System.out.println(ex.toString());
                System.err.format("Datei \"%s\" existiert bereits%n", PATH);
                mkFile(DEF_NEW, String.valueOf(GEN_NUM));
            }catch(IOException ex){
                System.out.println(ex.toString());
                System.err.format("createFile fehlgeschlagen: %s%n", ex);
            }
        }else{
            mkFile(DEF_NEW, String.valueOf(GEN_NUM));
        }
    }
    
    static void eintraegeSortieren(String path, String[][] zwischenSpeicher){
        String txt = "";
        try(FileWriter datei = new FileWriter(path)){
            for(String[] id : zwischenSpeicher){
                for(String wert : id){
                    if(wert != null){
                        txt += wert + "\n";
                    }
                }
            }
            datei.write(txt);
        }catch(FileNotFoundException ex){
            System.out.println("Die Datei '" + PATH + "' wurde nicht gefunden!");
            System.out.println(ex.toString());
            mkFile(LEER, LEER);
        }catch(IOException ex){
            System.out.println("Aus der Datei '" + PATH + "' kann nicht gelesen werden!");
            System.out.println(ex.toString());
        }
    }
    
    static Eintrag[] eintraegeEinlesen(Eintrag[] telefonbuch){
        String line;
        String[][] zwischenSpeicher = new String[MAX_EINTRAEGE][8];
        try(FileReader datei = new FileReader(PATH); BufferedReader inhalt = new BufferedReader(datei)){
            while((line = inhalt.readLine()) != null){
                zeile++;
                int index, indexA, indexB,subStrA, subStrB, varA, varB;
                String subStr, varStr;
                
                indexA = line.indexOf('_') + 1;
                indexB = line.indexOf('.');
                index = Integer.valueOf(line.substring(indexA, indexB));
                
                subStrA = line.indexOf('"') + 1;
                subStrB = line.lastIndexOf('"');
                subStr = line.substring(subStrA, subStrB);
                
                varA = line.indexOf('.') + 1;
                varB = line.lastIndexOf('=');
                varStr = line.substring(varA, varB).trim();
                
                if(telefonbuch[index].name.equals(LEER)){
                    telefonbuch[index] = new Eintrag();
                    anzahlEintraege++;
                }
                switch(varStr){
                    case "name":
                        telefonbuch[index].name = subStr;
                        zwischenSpeicher[index][0] = line;
                        break;
                    case "telNr":
                        telefonbuch[index].telNr = subStr;
                        zwischenSpeicher[index][1] = line;
                        break;
                    case "email":
                        telefonbuch[index].email = subStr;
                        zwischenSpeicher[index][2] = line;
                        break;
                    case "str":
                        telefonbuch[index].str = subStr;
                        zwischenSpeicher[index][3] = line;
                        break;
                    case "hausNr":
                        telefonbuch[index].hausNr = subStr;
                        zwischenSpeicher[index][4] = line;
                        break;
                    case "plz":
                        telefonbuch[index].plz = subStr;
                        zwischenSpeicher[index][5] = line;
                        break;
                    case "city":
                        telefonbuch[index].city = subStr;
                        zwischenSpeicher[index][6] = line;
                        break;
                    case "country":
                        telefonbuch[index].country = subStr;
                        zwischenSpeicher[index][7] = line;
                        break;
                    default:
                        System.out.println(zeile + ". Zeile enth\u00E4lt ung\u00FCltige Informationen: \"" + 
                                line + "\"");
                }
            }
            eintraegeSortieren(PATH, zwischenSpeicher);
        }catch(FileNotFoundException ex){
            System.out.println("Die Datei '" + PATH + "' wurde nicht gefunden!");
            System.out.println(ex.toString());
            mkFile(LEER, LEER);
        }catch(IOException ex){
            System.out.println("Aus der Datei '" + PATH + "' kann nicht gelesen werden!");
            System.out.println(ex.toString());
        }
        return telefonbuch;
    }
    
    static void eintraegeEinschreiben(Eintrag target, int index, String path){
        String line;
        try(FileWriter datei = new FileWriter(path, true)){
            for(int i = 0; i < 8; i++){
                switch(i){
                    case 0:
                        line = "ID_" + index + ".name = \"" + target.name + "\"\n";
                        break;
                    case 1:
                        line = "ID_" + index + ".telNr = \"" + target.telNr + "\"\n";
                        break;
                    case 2:
                        line = "ID_" + index + ".email = \"" + target.email + "\"\n";
                        break;
                    case 3:
                        line = "ID_" + index + ".str = \"" + target.str + "\"\n";
                        break;
                    case 4:
                        line = "ID_" + index + ".hausNr = \"" + target.hausNr + "\"\n";
                        break;
                    case 5:
                        line = "ID_" + index + ".plz = \"" + target.plz + "\"\n";
                        break;
                    case 6:
                        line = "ID_" + index + ".city = \"" + target.city + "\"\n";
                        break;
                    case 7:
                        line = "ID_" + index + ".country = \"" + target.country + "\"\n";
                        break;
                    default:
                        line = "";
                }
                datei.write(line);
                zeile++;
            }
        }catch(FileNotFoundException ex){
            System.out.println("Die Datei '" + PATH + "' wurde nicht gefunden!");
            System.out.println(ex.toString());
            mkFile(LEER, LEER);
        }catch(IOException ex){
            System.out.println("In die Datei '" + PATH + "' kann nicht geschrieben werden!");
            System.out.println(ex.toString());
        }
    }
    
    static Eintrag[] eintragEinfuegen(Eintrag[] telefonbuch){
        boolean doIT = false;
        int index = 0;
        if(anzahlEintraege >= telefonbuch.length){
            answer = scanner("Das Telefonbuch ist leider voll!\nM\u00F6chten Sie einen Eintrag ersetzen? (j/n)");
            if(answer.equalsIgnoreCase(POSITIV)){
                for(int i = 0; i < telefonbuch.length; i++){
                    System.out.println((i+1) + ". Eintrag");
                    output(telefonbuch[i]);
                }
                index = Integer.parseInt(scanner("Geben sie die Nummer des Eintrages ein!")) - 1;
                reset(telefonbuch[index]);
                anzahlEintraege--;
                doIT = true;
            }
        }else{
            for(int i = 0; i < telefonbuch.length; i++){
                if("".equals(telefonbuch[i].name)){
                    index = i;
                    break;
                }
            }
            doIT = true;
        }
        if(doIT){
            telefonbuch[index] = new Eintrag();
            anzahlEintraege++;
            telefonbuch[index].name = scanner("Geben Sie den Namen ein:\t");
            telefonbuch[index].telNr = scanner("Geben Sie die Telefonnummer ein:\t");
            telefonbuch[index].email = scanner("Geben Sie die E-Mail Addrese ein:\t");
            telefonbuch[index].str = scanner("Geben Sie die Stra\u00DFe ein:\t");
            telefonbuch[index].hausNr = scanner("Geben Sie die Hausnummer ein:\t");
            telefonbuch[index].plz = scanner("Geben Sie die Postleitzahl ein:\t");
            telefonbuch[index].city = scanner("Geben Sie die Stadt ein:\t");
            telefonbuch[index].country = scanner("Geben Sie das Land ein:\t");
            eintraegeEinschreiben(telefonbuch[index], index, PATH);
            eintraegeEinlesen(telefonbuch);
            System.out.println("***Kontakt wurde erfolgreich gespeichert***");
            output(telefonbuch[index], true);
            System.out.println("***Kontakt erfolgreich hinzugef\u00FCgt***");
        }
        return telefonbuch;
    }
    
    static Eintrag reset(Eintrag target){
        String reset = LEER;
        target.city = reset;
        target.country = reset;
        target.email = reset;
        target.hausNr = reset;
        target.name = reset;
        target.plz = reset;
        target.str = reset;
        target.telNr = reset;
        return target;
    }
    
    static void telefonbuchNachschauen(Eintrag[] telefonbuch){
        String NA = "ERROR 404 - Term Not Found";
        boolean doIT = false;
        String input = scanner("Geben Sie den Vor-/Nachname oder den vollst\u00E4ndigen Namen ein!");
        for(Eintrag eintrag : telefonbuch){
            if((eintrag.name.equalsIgnoreCase(input) || 
                    eintrag.name.toLowerCase().trim().contains(input.toLowerCase().trim())) && 
                    !LEER.equals(eintrag.name)){
                System.out.println("Name matches!");
                answer = output(eintrag);
                if(answer.equalsIgnoreCase(POSITIV)){
                    output(eintrag, true);
                    break;
                }else{
                    System.out.println("Suche weiter!");
                }
            }else{
                doIT = true;
            }
        }
        if(doIT){
            System.out.println(NA);
        }
    }
    
    static String output(Eintrag target){
        answer = scanner("Suchen Sie nach:\nName:\t " + target.name + "\nTel.:\t " + target.telNr + 
                "\nIst das der richtige Person?\n(Geben Sie f\u00FCr Ja => \"j\" und zum weiter suchen => \"n\" ein!)");
        return answer;
    }
    
    static void output(Eintrag target, boolean all){
        String txt = "Name:\t " + target.name + "\nTel.:\t " + target.telNr + 
                "\nE-Mail:\t " + target.email + "\nAdresse: " + target.str + " " + target.hausNr + 
                "\n\t " + target.plz + " " + target.city + "\n\t " + target.country;
        System.out.println(txt);
    }
    
    static void output(Eintrag[] telefonbuch){
        String txt = "";
        for(int i = 0; i < telefonbuch.length; i++){
            if(!telefonbuch[i].name.equals(LEER)){
                
                txt += (i+1) + ". Eintrag\nName:\t " + telefonbuch[i].name + "\nTel.:\t " + 
                        telefonbuch[i].telNr + "\nE-Mail:\t " + telefonbuch[i].email + 
                        "\nAdresse: " + telefonbuch[i].str + " " + telefonbuch[i].hausNr + 
                        "\n\t " + telefonbuch[i].plz + " " + telefonbuch[i].city + "\n\t " + 
                        telefonbuch[i].country + "\n\n";
            }
        }
        System.out.println(txt);
    }
    
    public static void main(String[] args){
        telefonbuch = new Eintrag[MAX_EINTRAEGE];
        for(int i = 0; i < telefonbuch.length; i++){
            telefonbuch[i] = new Eintrag();
            reset(telefonbuch[i]);
        }
        telefonbuch = eintraegeEinlesen(telefonbuch);
        
        do{
            do{
                answer = scanner("M\u00F6chten Sie ein neuer Kontakt anlegen? (j/n)");
                if(answer.equalsIgnoreCase(POSITIV)){
                    telefonbuch = eintragEinfuegen(telefonbuch);
                    oneMore = true;
                }else{
                    oneMore = false;
                }
            }while(oneMore);

            do{
                answer = scanner("Suchen Sie nach einem Kontakt? (j/n)");
                if(answer.equalsIgnoreCase(POSITIV)){
                    telefonbuchNachschauen(telefonbuch);
                    oneMore = true;
                }else{
                    oneMore = false;
                }
            }while(oneMore);

            do{
                answer = scanner("M\u00F6chten Sie einen Kontakt l\u00F6schen? (j/n)");
                if(answer.equalsIgnoreCase(POSITIV)){
                    output(telefonbuch);
                    int index = Integer.parseInt(scanner("Welcher Kontakt m\u00F6chten Sie l\u00F6schen? "
                            + "(nur Nummer eingeben)!")) - 1;
                    reset(telefonbuch[index]);
                    oneMore = true;
                }else{
                    oneMore = false;
                }
            }while(oneMore);

            if(again){
                answer = scanner("M\u00F6chten Sie Eintragen/Suchen/L\u00F6schen wiederholen? (j/n)");
                if(!answer.equalsIgnoreCase(POSITIV)){
                    again = false;
                }
            }
        }while(again);
        
        output(telefonbuch);
        System.out.println(anzahlEintraege);
    }
}