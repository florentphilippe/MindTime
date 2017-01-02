package Core;


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
    public DayEvent(){
        eventsList = new ArrayList<>();
        dateEvents = LocalDate.now();
        uniqueValue = 00000000;
    }

    //Parameters Constructor
    public DayEvent(ArrayList<BulletEvent> cArrayList,LocalDate cLocalDate,Integer cUniqueValue){
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
                "List size = " +this.getEventsList().size()+"\n"+
                "Date = " + this.getDateEvents()+"\n"+
                "UniqueValue = " + this.getUniqueValue()+"\n";
    }

    //Name constructor (Actually it is the date)
    public static String nameConstructor(DayEvent dayEvent){
        return new String(dayEvent.getDateEvents().getDayOfWeek()+" "+dayEvent.getDateEvents().getDayOfMonth()+" "+dayEvent.getDateEvents().getMonth());
    }

    //Bullet Event deleter
    public static void bulletDeleter(BulletEvent bulletEvent, DayEvent dayEvent){

        for(BulletEvent currentBulletEvent : dayEvent.getEventsList()){

            if(currentBulletEvent.getName().equals(bulletEvent.getName())){
                dayEvent.getEventsList().remove(currentBulletEvent);
                System.out.println("1 BulletEvent deleted");
            }
        }
    }
}
