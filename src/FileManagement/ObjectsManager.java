package FileManagement;


import Body.BulletEvent;
import com.sun.deploy.security.DeployURLClassPathCallback;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
        System.out.println("Sorting the list");
        ArrayList<BulletEvent> finalList = new ArrayList<>();
        ListIterator<BulletEvent> iterator = sourceList.listIterator();        //Adding Iterator
        Integer elementInList = 0;

        if (sourceList.isEmpty() == true){
            finalList.add(bulletEvent);
            elementInList++;
        }
        else{
            while (iterator.hasNext()){
                if (bulletEvent.getUniqueValue() > sourceList.get(iterator.nextIndex()).getUniqueValue()){
                    finalList.add(iterator.next());
                    elementInList++;
                }


                else if (bulletEvent.getUniqueValue() <= sourceList.get(iterator.nextIndex()).getUniqueValue()){
                    finalList.add(bulletEvent);
                    elementInList++;
                    break;
                }
            }
            while (iterator.hasNext()){
                finalList.add(iterator.next());
                elementInList++;
            }

        }
        if(finalList.size() == sourceList.size()){          //In case bulletEvent has to be the last element of the finalList
            finalList.add(bulletEvent);
            elementInList++;
        }

        System.out.println("Number of loop : "+elementInList);
        sourceList.clear();
        sourceList.addAll(finalList);
    }



}
