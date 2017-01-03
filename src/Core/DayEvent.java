package Core;


import FileManagement.ObjectsManager;
import Main.Main;

import java.time.LocalDate;
import java.util.ArrayList;

public class DayEvent {
    /*
    *The list of BulletEvent by days
    */

    private ArrayList<BulletEvent> eventsList;
    private LocalDate dateEvents;
    private Integer uniqueValue;


    //Main Constructor
    public DayEvent() {
        eventsList = new ArrayList<>();
        dateEvents = LocalDate.now();
        uniqueValue = 00000000;
    }

    //Parameters Constructor
    public DayEvent(ArrayList<BulletEvent> cArrayList, LocalDate cLocalDate, Integer cUniqueValue) {
        eventsList.addAll(cArrayList);
        dateEvents = LocalDate.now();
        uniqueValue = this.getEventsList().get(0).getUniqueValue();
    }

    //***Setters***
    public void setEventsList(ArrayList<BulletEvent> eventsList) {
        this.eventsList = eventsList;
    }

    public void setDateEvents(LocalDate dateEvents) {
        this.dateEvents = dateEvents;
    }

    public void setUniqueValue(Integer uniqueValue) {
        this.uniqueValue = uniqueValue;
    }


    //***Getters***
    public ArrayList<BulletEvent> getEventsList() {
        return eventsList;
    }

    public LocalDate getDateEvents() {
        return dateEvents;
    }

    public Integer getUniqueValue() {
        return uniqueValue;
    }

    //***ToString***
    public String toString() {
        return "DayEvent\n" +
                "List size = " + this.getEventsList().size() + "\n" +
                "Date = " + this.getDateEvents() + "\n" +
                "UniqueValue = " + this.getUniqueValue() + "\n";
    }

    //Name constructor (Actually it is the date)
    public static String nameConstructor(DayEvent dayEvent) {
        return new String(dayEvent.getDateEvents().getDayOfWeek() + " " + dayEvent.getDateEvents().getDayOfMonth() + " " + dayEvent.getDateEvents().getMonth());
    }

    //Bullet Event deleter
    public static void bulletDeleter(BulletEvent bulletEvent) {
        ArrayList<BulletEvent> processingList = new ArrayList<>();
        Integer i = 0;

        for (BulletEvent currentBulletEvent : Main.bulletEvents) {

            if (currentBulletEvent.getName().equals(bulletEvent.getName())) {
                System.out.println("Removing 1 Element");
            }else{
                processingList.add(currentBulletEvent);
            }
        i++;
        }

        //Writing the changes in the file
        Main.bulletEvents.clear();
        Main.bulletEvents.addAll(processingList);
        ObjectsManager.ObjectListWriter(Main.bulletEvents);

        //Updating the DayEvent list
        Main.dayEvents.clear();
        Main.dayEvents.addAll(ObjectsManager.automaticConstructor(Main.bulletEvents));
    }
}
