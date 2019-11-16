package Externo.Archivos;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Leaderboards {

    //lista de scores de jugadores previos
    public ArrayList<JugadorRankeado> lista = new ArrayList<>();

    //metodo para agregar jugador a la lista, pide nombre antes de agregarlo
    public void addRankedPlayer(){
        String nombre;
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre!");
        lista.add(new JugadorRankeado(nombre));
    }

    //escribe la lista en un archivo
    public void escribre() {
        try {
            FileOutputStream fos = new FileOutputStream("leaderboards.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(lista);
            bos.flush();

            oos.close();
            bos.close();
            fos.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //lee la lista de un archivo
    public void leer(){
        try{
            FileInputStream fis = new FileInputStream("leaderboards.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            lista = (ArrayList<JugadorRankeado>) ois.readObject();

            ois.close();
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
