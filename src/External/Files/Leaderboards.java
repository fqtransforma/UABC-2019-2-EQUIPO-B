package External.Files;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Leaderboards {

    //lista de scores de jugadores previos
    public ArrayList<RankedPlayer> list = new ArrayList<>();

    //metodo para agregar jugador a la lista, pide nombre antes de agregarlo
    public void addRankedPlayer(){
        String name;
        name = JOptionPane.showInputDialog("Enter your name!");
        list.add(new RankedPlayer(name));
    }

    //escribe la lista en un archivo
    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream("leaderboards.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(list);
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
    public void read(){
        try{
            FileInputStream fis = new FileInputStream("leaderboards.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            list = (ArrayList<RankedPlayer>) ois.readObject();

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
