package fileAccess;

import main.Principal;

import java.io.*;


public class FileAccess {
    
    private File fichero;
    
    public FileAccess(String path){
        fichero=new File(path);
        crearFichero();
        
    }

    public void crearFichero(){
        if(!fichero.exists()){
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void introducirDatosPorDefecto(String cadena,char caracter,double decimal,boolean booleano){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero,true));
            MyObjectOutputStream moos=new MyObjectOutputStream(new FileOutputStream(fichero,true))){
            oos.writeObject(cadena);
            moos.writeChar(caracter);
            moos.writeDouble(decimal);
            moos.writeBoolean(booleano);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void introducirDatosCadena(String cadena){
        File fichero2=new File("config2.bin");
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero));
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero2,true));
            MyObjectOutputStream moos=new MyObjectOutputStream(new FileOutputStream(fichero2,true))){
            ois.readObject();
            oos.writeObject(cadena);
            moos.writeChar(ois.readChar());
            moos.writeDouble(ois.readDouble());
            moos.writeBoolean(ois.readBoolean());
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        fichero.delete();
        fichero2.renameTo(fichero);
    }
    public void introducirDatosCaracter(char caracter){
        File fichero2=new File("config2.bin");
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero));
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero2,true));
            MyObjectOutputStream moos=new MyObjectOutputStream(new FileOutputStream(fichero2,true))){
                oos.writeObject((String) ois.readObject());
                ois.readChar();
                moos.writeChar(caracter);
                moos.writeDouble(ois.readDouble());
                moos.writeBoolean(ois.readBoolean());
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        fichero.delete();
        fichero2.renameTo(fichero);
    }
    public void introducirDatosDecimal(double decimal){
        File fichero2=new File("config2.bin");
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero));
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero2,true));
            MyObjectOutputStream moos=new MyObjectOutputStream(new FileOutputStream(fichero2,true))){
                oos.writeObject((String) ois.readObject());
                moos.writeChar(ois.readChar());
                ois.readDouble();
                moos.writeDouble(decimal);
                moos.writeBoolean(ois.readBoolean());
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        fichero.delete();
        fichero2.renameTo(fichero);
    }
    public void introducirDatosBoolean(boolean booleano){
        File fichero2=new File("config2.bin");
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero));
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero2,true));
            MyObjectOutputStream moos=new MyObjectOutputStream(new FileOutputStream(fichero2,true))){
            oos.writeObject((String) ois.readObject());
            moos.writeChar(ois.readChar());
            moos.writeDouble(ois.readDouble());
            moos.writeBoolean(booleano);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        fichero.delete();
        fichero2.renameTo(fichero);
    }


    public void leerDatos(){
        Object o;
        String cadena=""; char caracter=' '; boolean booleano=true; double decimal=0;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
           o=ois.readObject();
           cadena=(String) o.toString();
           caracter=ois.readChar();
           decimal=ois.readDouble();
            booleano=ois.readBoolean();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Principal.opcionMostrarDatos(cadena,caracter,decimal,booleano);
    }
}
