package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;

/**
 *
 * @author firedragon4e
 */

public class _01_05_Telefonbuchverwaltung{
    static Eintrag[] telefonbuch;
    static int anzahlEintraege = 0;
    final static String positiv = "j";
    final static String leer = "";
    static String answer;
    static boolean oneMore = false, again = true;
    
    static void eintraegeEinlesen(){
        telefonbuch[0] = new Eintrag();
        telefonbuch[0].name = "Bardia Dehghanpour";
        telefonbuch[0].telNr = "015253639476";
        telefonbuch[0].email = "huso@gmail.com";
        telefonbuch[2].str = "Rotweg";
        telefonbuch[2].hausNr = "1111";
        telefonbuch[0].plz = "99848";
        telefonbuch[0].city = "WF";
        telefonbuch[4].country = "DE";
        anzahlEintraege++;
        
        telefonbuch[2] = new Eintrag();
        telefonbuch[2].name = "susi";
        telefonbuch[2].telNr = "015234356546";
        telefonbuch[0].email = "huso@gmail.com";
        telefonbuch[2].str = "Waldweg";
        telefonbuch[2].hausNr = "45";
        telefonbuch[0].plz = "99848";
        telefonbuch[2].city = "MTL";
        telefonbuch[4].country = "DE";
        anzahlEintraege++;
        
        telefonbuch[4] = new Eintrag();
        telefonbuch[4].name = "Daniel N";
        telefonbuch[4].telNr = "015234356546";
        telefonbuch[0].email = "huso@gmail.com";
        telefonbuch[4].str = "Hinterhof";
        telefonbuch[4].hausNr = "15";
        telefonbuch[0].plz = "99848";
        telefonbuch[4].city = "HU";
        telefonbuch[4].country = "DE";
        anzahlEintraege++;
        
        telefonbuch[5] = new Eintrag();
        telefonbuch[5].name = "Denis M";
        telefonbuch[5].telNr = "015234356546";
        telefonbuch[0].email = "huso@gmail.com";
        telefonbuch[5].str = "wiese";
        telefonbuch[5].hausNr = "38";
        telefonbuch[0].plz = "99848";
        telefonbuch[5].city = "ESA";
        telefonbuch[5].country = "DE";
        anzahlEintraege++;
    }
    
    static Eintrag[] eintragEinfuegen(Eintrag[] telefonbuch){
        boolean doIT = false;
        int index = 0;
        if(anzahlEintraege >= telefonbuch.length){
            answer = scanner("Das Telefonbuch ist leider voll!\n"
                    + "M\u00F6chten Sie einen Eintrag ersätzen? (j/n)");
            if(answer.equalsIgnoreCase(positiv)){
                for(int i = 0; i < telefonbuch.length; i++){
                    System.out.println((i+1) + ". Eintrag");
                    output(telefonbuch, i);
                }
                index = Integer.parseInt(scanner("Geben sie die Nummer des Eintrages ein!")) - 1;
                reset(telefonbuch[index]);
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
        String reset = leer;
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
        String NA = "ERROR 404 - Eintrag Not Found";
        boolean doIT = false;
        String input = scanner("Geben Sie den Vor-/Nachname oder den vollst\u00E4ndigen Namen ein!");
        for(int i = 0; i < telefonbuch.length; i++){
            if((telefonbuch[i].name.equalsIgnoreCase(input) || 
                    telefonbuch[i].name.toLowerCase().trim().indexOf(input.toLowerCase().trim()) >= 0) && 
                    !leer.equals(telefonbuch[i].name)){
                System.out.println("Name matches!");
                answer = output(telefonbuch, i);
                if(answer.equalsIgnoreCase(positiv)){
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
            if(!telefonbuch[i].name.equals(leer)){
                
                txt += (i+1) + ". Eintrag\nName:\t " + telefonbuch[i].name + "\nE-Mail:\t " + 
                        telefonbuch[i].email + "\nTel.:\t " + telefonbuch[i].telNr + 
                        "\nAdresse: " + telefonbuch[i].str + " " + telefonbuch[i].hausNr + 
                        "\n\t " + telefonbuch[i].plz + " " + telefonbuch[i].city + "\n\t " + 
                        telefonbuch[i].country + "\n\n";
//                if(i < telefonbuch.length-1){
//                    txt += "\n";
//                }
            }
        }
        txt += "\b";
        System.out.println(txt);
    }
    
    public static void main(String[] args){
        telefonbuch = new Eintrag[10];
        for(int i = 0; i < telefonbuch.length; i++){
            telefonbuch[i] = new Eintrag();
            reset(telefonbuch[i]);
        }
        eintraegeEinlesen();
        
        do{
            do{
                answer = scanner("M\u00F6chten Sie einer neuen Kontakt eintragen? (j/n)");
                if(answer.equalsIgnoreCase(positiv)){
                    eintragEinfuegen(telefonbuch);
                    oneMore = true;
                }else{
                    oneMore = false;
                }
            }while(oneMore);

            do{
                answer = scanner("Suchen Sie nach einem Kontakt? (j/n)");
                if(answer.equalsIgnoreCase(positiv)){
                    telefonbuchNachschauen();
                    oneMore = true;
                }else{
                    oneMore = false;
                }
            }while(oneMore);

            do{
                answer = scanner("M\u00F6chten Sie einen Eintrag l\u00F6schen? (j/n)");
                if(answer.equalsIgnoreCase(positiv)){
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
                if(!answer.equalsIgnoreCase(positiv)){
                    again = false;
                }
            }
        }while(again);
        
        output(telefonbuch);
    }
}