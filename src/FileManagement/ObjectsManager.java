package FileManagement;


import Body.BulletEvent;
import java.io.*;
import java.util.ArrayList;
import static Main.Main.config;

public class ObjectsManager implements Serializable {


    //BulletEvent list writer
    public static void ObjectListWriter(ArrayList<BulletEvent> arrayList){
        BulletEvent[] bulletEvents = new BulletEvent[arrayList.size()];
        try{
            //copying ArrayList values in the new grid
            Integer j = arrayList.size();
            Integer i = 0;
            while(i < j){
                bulletEvents[i] = arrayList.get(i);
                i++;
            }

            FileOutputStream fileOutputStream = new FileOutputStream("objects.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bulletEvents);
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("BulletEvent list.lengh = "+bulletEvents.length+"\n");
            objectOutputStream.close();
        }catch (IOException exception){
            System.out.println("Writing new file : objects.ser ...");
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("BulletEvent list.lengh = "+bulletEvents.length+"\n");
        }
    }

    //BulletEvent list reader
    public static ArrayList<BulletEvent> ObjectListReader(){
        ArrayList<BulletEvent> arrayList = new ArrayList<>();
        BulletEvent[] bulletEvents;
        try{
            FileInputStream fileInputStream = new FileInputStream("objects.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bulletEvents = (BulletEvent[]) objectInputStream.readObject();
            objectInputStream.close();
            //copying BulletEvent grid into ArrayList
            Integer j = bulletEvents.length;
            Integer i = 0;
            while(i<j){
                arrayList.add(bulletEvents[i]);
                i++;
            }

        }catch (IOException exception){
            System.out.println("Impossible to access objects.ser ...");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
         return arrayList;
    }

}
