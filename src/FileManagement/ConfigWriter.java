package FileManagement;

import Body.BulletEvent;
import java.io.*;

public class ConfigWriter {

    //Counter writer
    public static void counterWriter() {
        try {
            FileOutputStream fos = new FileOutputStream("config.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(BulletEvent.getCounter());
            oos.close();
            System.out.println("Writing BulletEvent.counter in config.ser ...");
            System.out.println("BulletEvent.counter = "+BulletEvent.getCounter()+"\n");
        }catch(IOException exception){exception.printStackTrace();}
    }

    //Counter Reader
    public static Integer counterReader(){
        Integer integer = 0;
        try{
            FileInputStream fis = new FileInputStream("config.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            integer = ois.readInt();
            ois.close();
            System.out.println("Reading BulletEvent.counter from config.ser ...");
            System.out.println("Reading value : "+integer);
        }catch(IOException exception){
            System.out.println("Impossible to read BulletEvent.counter from config.ser ... ");
            integer = 0;
        }
        return integer;
    }

}
