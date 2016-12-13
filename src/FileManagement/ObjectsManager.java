package FileManagement;


import Body.BulletEvent;
import com.sun.deploy.security.DeployURLClassPathCallback;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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
    public static void BulletEventSorter(ArrayList<BulletEvent> sourceList, BulletEvent bulletEvent){
        ArrayList<BulletEvent> finalList = new ArrayList<>();
        Iterator iterator = sourceList.iterator();        //Adding Iterator
        Integer elementInList = 0;

        if (sourceList.isEmpty() == true){
            finalList.add(bulletEvent);
            System.out.println("Number of loops : 1");
        }
        else if (bulletEvent.getUniqueValue() > sourceList.get(elementInList).getUniqueValue()){
            while (bulletEvent.getUniqueValue() > sourceList.get(elementInList).getUniqueValue() && iterator.hasNext()){
                finalList.add(sourceList.get(elementInList));
                elementInList++;
            }

            finalList.add(bulletEvent);

            while (finalList.size() < sourceList.size()+1){
                finalList.add(sourceList.get(elementInList));
                elementInList++;
            }
            System.out.println("Number of loops : "+elementInList);
        }
        else if (bulletEvent.getUniqueValue() <= sourceList.get(elementInList).getUniqueValue()){

            finalList.add(bulletEvent);

            while(finalList.size() < sourceList.size()+1){
                finalList.add(sourceList.get(elementInList));
                elementInList++;
            }
            System.out.println("Number of loops : "+elementInList);
        }

        sourceList.clear();
        sourceList.addAll(finalList);
    }



}
