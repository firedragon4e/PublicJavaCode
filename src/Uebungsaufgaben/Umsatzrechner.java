package Uebungsaufgaben;

import static MiniPrograms.GetInput.scanner;
/**
 *
 * @author firedragon4e
 */

public class Umsatzrechner{
    public static double[][] setTabelle(){
        int x = Integer.parseInt(scanner("Geben Sie Anzahl der Jahren ein!"))+1;
        double[][] umsaetze = new double[x][6];
        for(int i = 0; i < umsaetze.length-1; i++){
            for(int j = 0; j < umsaetze[i].length-2; j++){
                umsaetze[i][j] = Double.parseDouble(scanner("Geben Sie den Wert f\u00FCr " + j + ". Quartal ein."));
            }
        }
        umsaetze = getDurchschnitt(getSumme(getJahresumsatz(umsaetze)));
        return umsaetze;
    }
    
    public static double[][] getJahresumsatz(double[][] umsaetze){
        for(int i = 0; i < umsaetze.length-1; i++){
            double jahresumsatz = 0;
            for(int j = 0; j < umsaetze[i].length-2; j++){
                jahresumsatz += umsaetze[i][j];
            }
            umsaetze[i][umsaetze.length-1] = jahresumsatz;
        }
        return umsaetze;
    }
    
    public static double[][] getDurchschnitt(double[][] umsaetze){
        for(int i = 0; i < umsaetze.length; i++){
            double durchschnitt = 0;
            for(int j = 0; j < umsaetze[i].length-1; j++){
                durchschnitt += umsaetze[i][j];
            }
            umsaetze[i][umsaetze.length] = durchschnitt;
        }
        return umsaetze;
    }
    
    public static double[][] getSumme(double[][] umsaetze){
        for(int i = 0; i < umsaetze[0].length-1; i++){
            double summe = 0;
            for(int j = 0; j < umsaetze.length-1; j++){
                summe += umsaetze[j][i];
            }
            umsaetze[umsaetze.length][i] = summe;
        }
        return umsaetze;
    }
    
    public static void output(double[][] umseatze, int x){
        for(int i = 0; i < umseatze.length; i++){
            for(int j = 0; j < umseatze[i].length-x; j++){
                System.out.println(umseatze[i][j] + "\t");
            }
            System.err.println();
        }
    }
    
    public static void main(String[] args){
        double[][] umseatze = setTabelle();
        output(umseatze, 0);
        
    }
}