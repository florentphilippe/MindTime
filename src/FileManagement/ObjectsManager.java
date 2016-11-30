package FileManagement;


import Body.BulletEvent;
import java.io.*;
import java.util.ArrayList;

public class ObjectsManager  {


    //BulletEvent list writer
    public static void ObjectListWriter(ArrayList<BulletEvent> arrayList){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("objects.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("BulletEvent list.lengh = "+arrayList.size()+"\n");
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException exception){
            exception.printStackTrace();
            System.out.println("Writing new file : objects.ser ...");
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("BulletEvent list.lengh = "+arrayList.size()+"\n");
        }
    }

    //BulletEvent list reader
    public static ArrayList<BulletEvent> ObjectListReader(){
        ArrayList<BulletEvent> arrayList;
        try{
            FileInputStream fileInputStream = new FileInputStream("objects.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            arrayList = new ArrayList<BulletEvent>((ArrayList)objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
        }catch (IOException exception){
            exception.printStackTrace();
            System.out.println("Impossible to access objects.ser ...");
            arrayList = new ArrayList<>();
        }catch (ClassNotFoundException ex){
            arrayList = new ArrayList<>();
            ex.printStackTrace();
        }
         return arrayList;
    }

}
