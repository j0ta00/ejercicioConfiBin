package main;

import fileAccess.FileAccess;
import vista.Vista;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    static Vista dialog;
    static FileAccess fa=new  FileAccess("config.bin");


    public static void main(String[] args) {
        fa.introducirDatosPorDefecto("dfsfsdf",'d',4,true);
        dialog = new Vista();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static void opcionCambiarCadena(String cadena){
        fa.introducirDatosCadena(cadena);
    }
    public static void opcionCambiarCaracter(char caracter){
        fa.introducirDatosCaracter(caracter);
    }
    public static void opcionCambiarDecimal(double decimal){
        fa.introducirDatosDecimal(decimal);
    }
    public static void opcionCambiarBooleano(boolean booleano){
        fa.introducirDatosBoolean(booleano);
    }
    public static void LlamarALeerDatos(){
        fa.leerDatos();
    }
    public static void opcionMostrarDatos(String cadena,char caracter,double decimalm,boolean booleano){
        dialog.mostrarDatos(cadena,caracter,decimalm,booleano);
    }

}
