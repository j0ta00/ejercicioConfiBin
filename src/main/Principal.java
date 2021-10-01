package main;

import fileAccess.FileAccess;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        FileAccess fa=new FileAccess("config.bin");
        fa.introducirDatosPorDefecto("1234567891",'D',9,true);
        menu(fa);
    }

    public static void menu(FileAccess fa) {
        int opcion=-1;
        String cadena="";
        double decimal=0;
        boolean booleano=false;
        char caracter=' ';
        Scanner teclado = new Scanner(System.in);
        while(opcion>0 || opcion<5){
            opcion=teclado.nextInt();
            switch (opcion){
                case 1-> fa.leerDatos();
                case 2->{
                    System.out.println("Introduce la nueva cadena");
                    cadena=teclado.nextLine();
                    fa.introducirDatosCadena(cadena);
                }
                case 3->{
                    System.out.println("Introduce el nuevo caracter");
                    caracter=teclado.next().charAt(0);
                    fa.introducirDatosCaracter(caracter);
                }
                case 4->{
                    System.out.println("Introduce el nuevo double");
                    decimal=teclado.nextDouble();
                    fa.introducirDatosDecimal(decimal);
                }
                case 5->{
                    System.out.println("Introduce el nuevo boolean");
                    System.out.println("V verdadero F falso");
                    if(teclado.nextLine().toUpperCase(Locale.ROOT)=="V"){
                        booleano=true;
                    }else{
                        booleano=false;
                    }
                    fa.introducirDatosBoolean(booleano);
                }
            }

        }

    }
}
