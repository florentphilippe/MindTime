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
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException exception){
            System.out.println("Writing BulletEventList to objects.ser");
            System.out.println("Writing new file : objects.ser ...");
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
            System.out.println("Impossible to access objects.ser ...");
            arrayList = new ArrayList<>();
        }catch (ClassNotFoundException ex){
            arrayList = new ArrayList<>();
        }
         return arrayList;
    }

    //BulletEvent list sorter
    public static ArrayList BulletEventSorter(ArrayList<BulletEvent>  sourceList, BulletEvent bulletEvent){
        ArrayList finalList = new ArrayList();        //Destination list
        Integer i = 0;          //Loop variable
        while(i < sourceList.size()){

            if (bulletEvent.getUniqueValue() <= sourceList.get(i).getUniqueValue()){
                finalList.add(bulletEvent);
                i++;
            }
            else {
                finalList.add(sourceList.get(i));
            i++;
            }
        }
        return finalList;
    }



}
