package FileManagement;


import Body.BulletEvent;

import java.io.*;
import java.util.ArrayList;


public class ObjectsManager implements Serializable {


//initialization of Arraylist
public static ArrayList<BulletEvent> list;



    //BulletEvent list writer
    public static void ObjectListWriter(ArrayList<BulletEvent> arrayList){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("objects.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("BulletEvent list.lengh = "+arrayList.size());
            objectOutputStream.close();
        }catch (IOException exception){
            System.out.println("Writing new file : objects.ser ...");
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("BulletEvent list.lengh = "+arrayList.size()+"\n");
        }
    }

    //BulletEvent list reader
    public static ArrayList<BulletEvent> ObjectListReader(){
        ArrayList<BulletEvent> arrayList = new ArrayList<BulletEvent>();
        try{
            FileInputStream fileInputStream = new FileInputStream("objects.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            arrayList = (ArrayList<BulletEvent>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (IOException exception){
            System.out.println("Impossible to access objects.ser ...");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
         return arrayList;
    }

}
