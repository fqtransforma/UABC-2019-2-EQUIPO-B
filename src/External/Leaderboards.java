package External;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Leaderboards {

    public ArrayList<RankedPlayer> list = new ArrayList<>();

    public void addRankedPlayer(){
        String name;
        name = JOptionPane.showInputDialog("Enter your name!");
        list.add(new RankedPlayer(name));
    }

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
