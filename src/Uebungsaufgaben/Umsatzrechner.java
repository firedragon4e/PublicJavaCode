package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;

/**
 *
 * @author firedragon4e
 */

public class Umsatzrechner{
    public static double[][] setTabelle(){
        int x = Integer.parseInt(scanner("Geben Sie Anzahl der Jahren ein!"))+1;
        int y = Integer.parseInt(scanner("Geben Sie Anzahl der Quartale/Monate ein!"))+2;
        double[][] umsaetze = new double[x][y];
        for(int i = 0; i < umsaetze.length-1; i++){
            for(int j = 0; j < umsaetze[i].length-2; j++){
                umsaetze[i][j] = Double.parseDouble(scanner("Geben Sie den Umsatz f\u00FCr " + 
                        (j+1) + ". Quartal/Monat des " + (i+1) + ". Jahres ein."));
            }
        }
        //Kann man auch in der main-Methode machen. Schaut die auskommentierte code in der main-Methode!
        umsaetze = getDurchschnitt(getSumme(getJahresumsatz(umsaetze)));
        return umsaetze;
    }
    
    public static double[][] getJahresumsatz(double[][] umsaetze){
        for(int i = 0; i < umsaetze.length-1; i++){
            double jahresumsatz = 0;
            for(int j = 0; j < umsaetze[i].length-2; j++){
                jahresumsatz += umsaetze[i][j];
            }
            umsaetze[i][umsaetze[i].length-2] = jahresumsatz;
        }
        return umsaetze;
    }
  
    public static double[][] getSumme(double[][] umsaetze){
        int x = umsaetze[0].length-1, y = umsaetze.length-1;
        for(int i = 0; i < x; i++){
            double summe = 0;
            for(int j = 0; j < y; j++){
                summe += umsaetze[j][i];
            }
            umsaetze[y][i] = summe;
        }
        return umsaetze;
    }
    
    public static double[][] getDurchschnitt(double[][] umsaetze){
        for(int i = 0; i < umsaetze.length; i++){
            umsaetze[i][umsaetze[i].length-1] = 
                    umsaetze[i][umsaetze[i].length-2]/(umsaetze[i].length-2)*1.0;
        }
        return umsaetze;
    }
    
    public static void output(double[][] umseatze){
        String abschnitt;
        if(umseatze[0].length < 7){
            abschnitt = "Quartal";
        }else{
            abschnitt = "Monat";
        }
        String txt = "Jahr\t| ";
        for(int x = 0; x < umseatze[0].length-2; x++){
            txt += " " + (x+1) + ". " + abschnitt + "\t| ";
        }
        txt += " Jahresumsatz |  Durchschnitt";
        System.out.println(txt);
        for(int i = 0; i < umseatze.length; i++){
            if(i == umseatze.length-1){
                System.out.print("Summe\t");
            }else{
                System.out.print((i+1) + ". Jahr\t");
            }
            for(int j = 0; j < umseatze[i].length; j++){
                System.out.print("|  " + umseatze[i][j] + " \u20AC" + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        double[][] umseatze = setTabelle();
//        umseatze = getJahresumsatz(umseatze);
//        umseatze = getSumme(umseatze);
//        umseatze = getDurchschnitt(umseatze);
        output(umseatze);
    }
}