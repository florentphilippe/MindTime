package FileManagement;


import Body.BulletEvent;
import Body.DayEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.*;
import java.util.ArrayList;
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





    //Automatic constructor of a list from BulletEvent ArrayList
    public static ArrayList<DayEvent> automaticConstructor(ArrayList<BulletEvent> sourceList){
        System.out.println("Launching the automaticConstructor method ... ");

        boolean loop = true;
        ListIterator<BulletEvent> iterator = sourceList.listIterator();
        ArrayList<DayEvent> finaList = new ArrayList<>();

        while(loop){
            if (iterator.nextIndex() == 0) {
                System.out.println("Processing first element of the list...");
                ArrayList<BulletEvent> processingList = new ArrayList<>();
                DayEvent dayEvent = new DayEvent();
                dayEvent.setUniqueValue(sourceList.get(iterator.nextIndex()).getUniqueValue());
                dayEvent.setDateEvents(sourceList.get(iterator.nextIndex()).getDate());
                processingList.add(iterator.next());

                if (!iterator.hasNext()) {
                    dayEvent.setEventsList(processingList);
                    finaList.add(dayEvent);
                    loop = false;
                }
                else {
                    while (sourceList.get(iterator.nextIndex()).getDate().equals(sourceList.get(iterator.previousIndex()).getDate())) {
                        processingList.add(iterator.next());
                        if(!iterator.hasNext()){
                            loop = false;
                            break;
                        }
                    }
                }
                dayEvent.setEventsList(processingList);
                finaList.add(dayEvent);

            }
            else{
                DayEvent dayEvent = new DayEvent();
                ArrayList<BulletEvent> processingList = new ArrayList<>();
                dayEvent.setUniqueValue(sourceList.get(iterator.nextIndex()).getUniqueValue());
                dayEvent.setDateEvents(sourceList.get(iterator.nextIndex()).getDate());
                processingList.add(iterator.next());

                if (!iterator.hasNext()) {
                    dayEvent.setEventsList(processingList);
                    finaList.add(dayEvent);
                    loop = false;
                }
                else {
                    while (sourceList.get(iterator.nextIndex()).getDate().equals(sourceList.get(iterator.previousIndex()).getDate())) {
                        processingList.add(iterator.next());
                        if(!iterator.hasNext()){
                            loop = false;
                            break;
                        }
                    }
                    dayEvent.setEventsList(processingList);
                    finaList.add(dayEvent);
                }
            }
        }
        System.out.println("Number of loops : "+iterator.nextIndex()+"\n");
        return finaList;
    }

    //Construct a gui from the DayEvent list
    public static VBox dayEventConstructor(ArrayList<DayEvent> sourceList){
        VBox main = new VBox(5);
        main.setPadding(new Insets(5,5,5,15));

        for(DayEvent currentDay : sourceList){
            Label title = new Label();
            Text text = new Text();
            VBox element = new VBox();
            StringBuilder content = new StringBuilder();

            title.setText("\t"+currentDay.getDateEvents().getDayOfWeek()+" "+currentDay.getDateEvents().getDayOfMonth()+" "+currentDay.getDateEvents().getMonth());

            for (BulletEvent currentEvent : currentDay.getEventsList()){
                content.append(BulletEvent.convertByte(currentEvent.getType()));
                content.append(currentEvent.getName()+"\n");
            }
            text.setText(content.toString());
            element.getChildren().addAll(title,text);
            main.getChildren().addAll(element);

        }
        return main;
    }



    /*
    Those two methods are DEPRECATED. They raise an error in "java platform binary". Don't know where is the issue
     */
    //DayEvent list sorter
    public static void dayEventSorter(ArrayList<DayEvent> sourceList, DayEvent dayEvent){
        System.out.println("Sorting the list");
        ArrayList<DayEvent> finalList = new ArrayList<>();
        ListIterator<DayEvent> iterator = sourceList.listIterator();        //Adding Iterator
        Integer elementInList = 0;

        if (sourceList.isEmpty() == true){
            finalList.add(dayEvent);
            elementInList++;
        }
        else{
            while (iterator.hasNext()){
                if (dayEvent.getUniqueValue() > sourceList.get(iterator.nextIndex()).getUniqueValue()){
                    finalList.add(iterator.next());
                    elementInList++;
                }
                else if (dayEvent.getUniqueValue() <= sourceList.get(iterator.nextIndex()).getUniqueValue()){
                    finalList.add(dayEvent);
                    elementInList++;
                    break;
                }
            }
            while (iterator.hasNext()){
                finalList.add(iterator.next());
                elementInList++;
            }
        }
        if(finalList.size() == sourceList.size()){          //In case dayEvent has to be the last element of the finalList
            finalList.add(dayEvent);
            elementInList++;
        }

        System.out.println("Number of loop : "+elementInList);
        sourceList.clear();
        sourceList.addAll(finalList);
    }


    //DayEvent adder to the main list
    public static void dayEventAdder(ArrayList<DayEvent> sourceList, BulletEvent bulletEvent){
        System.out.println("Adding BulletEvent to DayEvent list");
        ListIterator<DayEvent> iterator;
        iterator = sourceList.listIterator();
        boolean found = false;

        while(iterator.hasNext()){
            if (bulletEvent.getDate().equals(sourceList.get(iterator.nextIndex()).getDateEvents())){
                System.out.println("Adding BulletEvent : "+bulletEvent.getDate()+"; to DayEvent : "+sourceList.get(iterator.nextIndex()).getDateEvents());
                iterator.next().getEventsList().add(bulletEvent);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Entering If ");
            DayEvent dayEvent = new DayEvent();
            System.out.println("Creating new DayEvent ...");
            dayEvent.getEventsList().add(bulletEvent);
            dayEvent.setDateEvents(bulletEvent.getDate());
            dayEvent.setUniqueValue(bulletEvent.getUniqueValue());

            System.out.println("Sorting DayEvent list");
            dayEventSorter(sourceList,dayEvent);
        }
    }




}
