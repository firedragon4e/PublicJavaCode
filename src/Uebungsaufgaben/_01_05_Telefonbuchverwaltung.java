package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;
import java.io.*;

/**
 *
 * @author firedragon4e
 */

public class _01_05_Telefonbuchverwaltung{
    static String PATH = ".\\src\\Uebungsaufgaben\\Kontakte.txt";
    static Eintrag[] telefonbuch;
    static int anzahlEintraege = 0;
    static final String POSITIV = "j";
    static final String LEER = "";
    static String answer;
    static boolean oneMore = false, again = true;
    
    static Eintrag[] eintraegeEinlesen(Eintrag[] telefonbuch){
        String line;
        int zeil = 1;
        try{
            FileReader ausDatei = new FileReader(PATH);
            BufferedReader inhaltAusDatei = new BufferedReader(ausDatei);
            while((line = inhaltAusDatei.readLine()) != null){
                zeil++;
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
                        break;
                    case "telNr":
                        telefonbuch[index].telNr = subStr;
                        break;
                    case "email":
                        telefonbuch[index].email = subStr;
                        break;
                    case "str":
                        telefonbuch[index].str = subStr;
                        break;
                    case "hausNr":
                        telefonbuch[index].hausNr = subStr;
                        break;
                    case "plz":
                        telefonbuch[index].plz = subStr;
                        break;
                    case "city":
                        telefonbuch[index].city = subStr;
                        break;
                    case "country":
                        telefonbuch[index].country = subStr;
                        break;
                    default:
                        System.out.println(zeil + ". Zeile enth\u00E4lt ung\u00FCltige Informationen: '" + 
                                line + "'");
                }
            }
            ausDatei.close();
        }catch(FileNotFoundException ex){
            System.out.println("Die Datei '" + PATH + "' wurde nicht gefunden!");
            System.out.println(ex.toString());
        }catch(IOException ex){
            System.out.println("Aus der Datei '" + PATH + "' kann nicht gelesen werden!");
            System.out.println(ex.toString());
        }
        return telefonbuch;
    }
    
    static Eintrag[] eintragEinfuegen(Eintrag[] telefonbuch){
        boolean doIT = false;
        int index = 0;
        if(anzahlEintraege >= telefonbuch.length){
            answer = scanner("Das Telefonbuch ist leider voll!\n"
                    + "M\u00F6chten Sie einen Eintrag ersetzen? (j/n)");
            if(answer.equalsIgnoreCase(POSITIV)){
                for(int i = 0; i < telefonbuch.length; i++){
                    System.out.println((i+1) + ". Eintrag");
                    output(telefonbuch, i);
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
            System.out.println("*Kontakt erfolgreich hinterlegt*");
            output(telefonbuch, index, true);
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
        for(int i = 0; i < telefonbuch.length; i++){
            if((telefonbuch[i].name.equalsIgnoreCase(input) || 
                    telefonbuch[i].name.toLowerCase().trim().indexOf(input.toLowerCase().trim()) >= 0) && 
                    !LEER.equals(telefonbuch[i].name)){
                System.out.println("Name matches!");
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(POSITIV)){
                    output(telefonbuch, i, true);
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
    
    static String output(Eintrag[] telefonbuch, int i){
        answer = scanner("Suchen Sie nach:\nName:\t " + telefonbuch[i].name + "\nTel.:\t " + telefonbuch[i].telNr + 
                "\nIst das der richtige Person?\n(Geben Sie f\u00FCr Ja => \"j\" und zum weiter suchen => \"n\" ein!)");
        return answer;
    }
    
    static void output(Eintrag[] telefonbuch, int i, boolean all){
        String txt = "Name:\t " + telefonbuch[i].name + "\nE-Mail:\t " + 
                telefonbuch[i].email + "\nTel.:\t " + telefonbuch[i].telNr + 
                "\nAdresse: " + telefonbuch[i].str + " " + telefonbuch[i].hausNr + 
                "\n\t " + telefonbuch[i].plz + " " + telefonbuch[i].city + "\n\t " + telefonbuch[i].country;
        System.out.println(txt);
    }
    
    static void output(Eintrag[] telefonbuch){
        String txt = "";
        for(int i = 0; i < telefonbuch.length; i++){
            if(!telefonbuch[i].name.equals(LEER)){
                
                txt += (i+1) + ". Eintrag\nName:\t " + telefonbuch[i].name + "\nE-Mail:\t " + 
                        telefonbuch[i].email + "\nTel.:\t " + telefonbuch[i].telNr + 
                        "\nAdresse: " + telefonbuch[i].str + " " + telefonbuch[i].hausNr + 
                        "\n\t " + telefonbuch[i].plz + " " + telefonbuch[i].city + "\n\t " + 
                        telefonbuch[i].country + "\n\n";
            }
        }
        System.out.println(txt);
    }
    
    public static void main(String[] args){
        telefonbuch = new Eintrag[10];
        for(int i = 0; i < telefonbuch.length; i++){
            telefonbuch[i] = new Eintrag();
            reset(telefonbuch[i]);
        }
        telefonbuch = eintraegeEinlesen(telefonbuch);
        
        do{
            do{
                answer = scanner("M\u00F6chten Sie einer neuen Kontakt eintragen? (j/n)");
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
                answer = scanner("M\u00F6chten Sie einen Eintrag l\u00F6schen? (j/n)");
                if(answer.equalsIgnoreCase(POSITIV)){
                    output(telefonbuch);
                    int index = Integer.parseInt(scanner("Welches Eintrag m\u00F6chten Sie l\u00F6schen? "
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
