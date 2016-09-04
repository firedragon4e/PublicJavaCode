package Uebungsaufgaben;
import java.util.Scanner;

/**
 * @author firedragon4e
 */
public class _01_02_Array{
    
    public static String scanner(){
        Scanner input = new Scanner(System.in);
        String eingabe = input.nextLine();
        return eingabe;
    }
    
    public static int anzahlPersonen(String txt){
        System.out.println(txt);
        int zeilen = Integer.parseInt(scanner());
        return zeilen;
    }
    
    public static String[] nameArrayErstellen(int i){
        String[] arr = new String[i];
        return arr;
    }
    
    public static double[] koerpergroesseArrayErstellen(int i){
        double[] arr = new double[i];
        return arr;
    }
    
    public static String nameEingeben(int i, String txt1, String txt2){
        System.out.println(txt1 + (i+1) + txt2);
        String name = scanner();
        return name;
    }
    
    public static double koerpergroesseEingeben(String txt){
        System.out.println(txt);
        double name = Double.parseDouble(scanner());
        return name;
    }
    
    public static int setX(String input){
        int x, y;
        x = input.length();
        y = x/8;
        return y;
    }
    
    public static int getMaxParts(int[] x){
        int a = x[0], b;
        for (int i : x){
            b = i;
            if(a < b){
                a = b;
            }
        }
        return a;
    }
    
    public static void ausgabeTabelle(int[] x, int mp, String[] name, double[] groesse){
        if(mp == 0){
            System.out.println("Name\t|\tK\u00F6rpergr\u00F6\u00DFe");
            System.out.println("===========================");
        }else if(mp == 1){
            System.out.println("Name\t\t|\tK\u00F6rpergr\u00F6\u00DFe");
            System.out.println("===================================");
        }else if(mp == 2){
            System.out.println("Name\t\t\t|\tK\u00F6rpergr\u00F6\u00DFe");
            System.out.println("===========================================");
        }else if(mp == 3){
            System.out.println("Name\t\t\t\t|\tK\u00F6rpergr\u00F6\u00DFe");
            System.out.println("===================================================");
        }else if(mp == 4){
            System.out.println("Name\t\t\t\t\t|\tK\u00F6rpergr\u00F6\u00DFe");
            System.out.println("===========================================================");
        }else if (mp == 5){
            System.out.println("Name\t\t\t\t\t\t|\tK\u00F6rpergr\u00F6\u00DFe");
            System.out.println("===================================================================");
        }
        
        for(int i = 0; i < name.length; i++){
            if(x[i] == 5){
                switch(mp){
                    case 5:
                        System.out.println(name[i] + "\t|\t" + groesse[i] + "cm");
                        break;
                }
            }else if(x[i] == 4){
                switch(mp){
                    case 4:
                        System.out.println(name[i] + "\t|\t" + groesse[i] + "cm");
                        break;
                    case 5:
                        System.out.println(name[i] + "\t\t|\t" + groesse[i] + "cm");
                        break;
                }
            }else if(x[i] == 3){
                switch(mp){
                    case 3:
                        System.out.println(name[i] + "\t|\t" + groesse[i] + "cm");
                        break;
                    case 4:
                        System.out.println(name[i] + "\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 5:
                        System.out.println(name[i] + "\t\t\t|\t" + groesse[i] + "cm");
                        break;
                }
            }else if(x[i] == 2){
                switch(mp){
                    case 2:
                        System.out.println(name[i] + "\t|\t" + groesse[i] + "cm");
                        break;
                    case 3:
                        System.out.println(name[i] + "\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 4:
                        System.out.println(name[i] + "\t\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 5:
                        System.out.println(name[i] + "\t\t\t\t|\t" + groesse[i] + "cm");
                        break;
                }
            }else if(x[i] == 1){
                switch(mp){
                    case 1:
                        System.out.println(name[i] + "\t|\t" + groesse[i] + "cm");
                        break;
                    case 2:
                        System.out.println(name[i] + "\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 3:
                        System.out.println(name[i] + "\t\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 4:
                        System.out.println(name[i] + "\t\t\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 5:
                        System.out.println(name[i] + "\t\t\t\t\t|\t" + groesse[i] + "cm");
                        break;
                }
            }else if(x[i] == 0){
                switch(mp){
                    case 0:
                        System.out.println(name[i] + "\t|\t" + groesse[i] + "cm");
                        break;
                    case 1:
                        System.out.println(name[i] + "\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 2:
                        System.out.println(name[i] + "\t\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 3:
                        System.out.println(name[i] + "\t\t\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 4:
                        System.out.println(name[i] + "\t\t\t\t\t|\t" + groesse[i] + "cm");
                        break;
                    case 5:
                        System.out.println(name[i] + "\t\t\t\t\t\t|\t" + groesse[i] + "cm");
                        break;
                }
            }
        }
    }
    
    public static void main(String[] args){
        String txt1 = "Geben Sie Anzahl der Personen ein!";
        String txt2 = "Geben sie den ";
        String txt3 = ". Namen ein!";
        String txt4 = "Geben sie die K\u00F6rpergr\u00F6sse ein!";
        int anzahl = anzahlPersonen(txt1);
        int[] x = new int[anzahl];
        String[] name = nameArrayErstellen(anzahl);
        double[] koerpergroesse = koerpergroesseArrayErstellen(anzahl);
        for(int i = 0; i < name.length; i++){
            name[i] = nameEingeben(i, txt2, txt3);
            x[i] = setX(name[i]);
            koerpergroesse[i] = koerpergroesseEingeben(txt4);
        }
        int mp = getMaxParts(x);
        ausgabeTabelle(x, mp, name, koerpergroesse);
    }
}