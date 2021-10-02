package main;

import fileAccess.FileAccess;
import vista.Vista;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    static Vista dialog;

    public static void main(String[] args) {
        dialog = new Vista();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static void opcionCambiarCadena(String cadena){
        FileAccess fa=new  FileAccess("config.bin");
        fa.introducirDatosCadena(cadena);
    }
    public static void opcionCambiarCaracter(char caracter){
        FileAccess fa=new  FileAccess("config.bin");
        fa.introducirDatosCaracter(caracter);
    }
    public static void opcionCambiarDecimal(double decimal){
        FileAccess fa=new  FileAccess("config.bin");
        fa.introducirDatosDecimal(decimal);
    }
    public static void opcionCambiarBooleano(boolean booleano){
        FileAccess fa=new  FileAccess("config.bin");
        fa.introducirDatosBoolean(booleano);
    }
    public static void LlamarALeerDatos(){
        FileAccess fa=new  FileAccess("config.bin");
        fa.leerDatos();
    }
    public static void opcionMostrarDatos(String cadena,char caracter,double decimalm,boolean booleano){
        dialog.mostrarDatos(cadena,caracter,decimalm,booleano);
    }

}
