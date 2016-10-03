package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;
import java.util.Scanner;
import static MiniPrograms.GetInput.scanner;

/**
 *
 * @author firedragon4e
 */

public class _01_05_Telefonbuchverwaltung{
    static Eintrag[] telefonbuch;
    static int anzahlEintraege = 0;
    final private static String positiv = "j";
    static boolean oneMore = false;
    
    static Eintrag[] eintragEinfuegen(Eintrag[] telefonbuch){
        boolean doIT = false;
        int index = 0;
        if(anzahlEintraege >= telefonbuch.length){
            String answer = scanner("Das Telefonbuch ist leider voll!\n"
                    + "M\u00F6chten Sie einen Eintrag \u00FCberschreiben? j/n");
            if(answer.equalsIgnoreCase(positiv)){
                for(int i = 0; i < telefonbuch.length; i++){
                    System.out.println((i+1) + ". Eintrag");
                    output(telefonbuch, i);
                }
                index = Integer.parseInt(scanner("Geben sie die Nummer des Eintrages ein!"))-1;
                reset(telefonbuch[index]);
                doIT = true;
            }
        }else{
            for(int i = 0; i < telefonbuch.length; i++){
                if(telefonbuch[i] == null){
                    index = i;
                    break;
                }
            }
            doIT = true;
        }
        if(doIT){
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
        String reset = null;
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
    
    static void telefonbuchNachschauen(){
        String txt = "ERROR 404 - Eintrag Not Found";
        String input = scanner("Geben Sie vorhandene Informationen ein, wonach Sie suchen!");
        String answer;
        for(int i = 0; i < telefonbuch.length; i++){
            if(telefonbuch[i].name.equalsIgnoreCase(input) || telefonbuch[i].name != null){
                txt = "Name matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].email.equalsIgnoreCase(input) || telefonbuch[i].email != null){
                txt = "E-Mail matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].str.equalsIgnoreCase(input) || telefonbuch[i].str!= null){
                txt = "Street matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].city.equalsIgnoreCase(input) || telefonbuch[i].city != null){
                txt = "City matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].country.equalsIgnoreCase(input) || telefonbuch[i].country != null){
                txt = "Country matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].hausNr.equalsIgnoreCase(input) || telefonbuch[i].hausNr != null){
                txt = "Home Number matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].plz.equalsIgnoreCase(input) || telefonbuch[i].plz != null){
                txt = "Postalcode matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else if(telefonbuch[i].telNr.equalsIgnoreCase(input) || telefonbuch[i].telNr != null){
                txt = "Telefon Number matches!";
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
                    output(telefonbuch, i, true);
                }
            }else{
                System.out.println(txt);
            }
        }
    }
    
    static String output(Eintrag[] telefonbuch, int i){
        String answer = scanner("Suchen Sie nach:\n\t" + telefonbuch[i].name + "\n\t" + telefonbuch[i].telNr + 
                "\n?\n (Geben Sie f\u00FCr Ja => \"j\" und zum weiter suchen => \"n\" ein!)");
        return answer;
    }
    
    static void output(Eintrag[] telefonbuch, int i, boolean all){
        String txt = (i+1) + ".\nName:\n" + telefonbuch[i].name + "\nE-Mail:\n" + 
                telefonbuch[i].email + "\nTel.:\n" + telefonbuch[i].telNr + 
                "\nAdresse:\n" + telefonbuch[i].str + " " + telefonbuch[i].hausNr + 
                "\n" + telefonbuch[i].plz + telefonbuch[i].city + "\n" + telefonbuch[i].country;
        System.out.println(txt);
    }
    
    static void output(Eintrag[] telefonbuch){
        String txt = "";
        for(int i = 0; i < telefonbuch.length; i++){
            txt += (i+1) + ".\nName:\n" + telefonbuch[i].name + "\nE-Mail:\n" + 
                    telefonbuch[i].email + "\nTel.:\n" + telefonbuch[i].telNr + 
                    "\nAdresse:\n" + telefonbuch[i].str + " " + telefonbuch[i].hausNr + 
                    "\n" + telefonbuch[i].plz + telefonbuch[i].city + "\n" + telefonbuch[i].country;
            if(i < telefonbuch.length-1){
                txt += "\n\n";
            }
        }
        System.out.println(txt);
    }
    
    public static void main(String[] args){
        telefonbuch = new Eintrag[10];
        Eintrag e0, e1, e2, e3, e4, e5, e6, e7, e8, e9;
        
        e0 = new Eintrag();
        e0.name = "Bardia";
        e0.city = "Wutha";
        e0.plz = "99848";
        e0.telNr = "015253639476";
        telefonbuch[0] = e0;
        anzahlEintraege++;
        
        e1 = new Eintrag();
        e1.name = "Sogi";
        e1.str = "Blutapfelweg";
        e1.hausNr = "4";
        e1.city = "Maintal";
        e1.telNr = "015234356546";
        telefonbuch[1] = e1;
        anzahlEintraege++;
        
        do{
            String answer = scanner("M\u00F6chten Sie eine neue Kontakt eintragen? (j/n)");
            if(answer.equalsIgnoreCase(positiv)){
                eintragEinfuegen(telefonbuch);
                oneMore = true;
            }
            answer = scanner("Suchen Sie nach einem Kontakt? (j/n)");
            if(answer.equalsIgnoreCase(positiv)){
                telefonbuchNachschauen();
                oneMore = true;
            }
        }while(oneMore);
    }
}