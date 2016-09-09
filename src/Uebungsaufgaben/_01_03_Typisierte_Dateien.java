package Uebungsaufgaben;

/**
 *
 * @author firedragon4e
 */
public class _01_03_Typisierte_Dateien{
    public static void main(String[] args){
        Date d1, d2, d3;
        
        d1 = new Date();
        d2 = new Date();
        d3 = new Date();
        
        d1.tag = 12;
        d1.monat = "September";
        d1.jahr = 2024;
        
        d2.tag = 21;
        d2.monat = "Februar";
        d2.jahr = 1847;
        
        d3.monat = "August";
        d3.tag = 31;
        d3.jahr = 2042;
        
        System.err.println(d1.tag + ". " + d1.monat + " " + d1.jahr);
        System.err.println(d2.tag + ". " + d2.monat + " " + d2.jahr);
        System.err.println(d3.tag + ". " + d3.monat + " " + d3.jahr);
    }
}