package Body;


import java.time.LocalDate;

public class DayEvent {
    /*
    *The list of BulletEvent by days
    */

    private BulletEvent eventsList[];
    private LocalDate dateEvents;
    private Integer uniqueValue;


    //Main Constructor
    public DayEvent(){
        eventsList = new BulletEvent[100];
        dateEvents = LocalDate.now();
        uniqueValue = 00000000;
    }

    //Parameters Constructor
    public DayEvent(BulletEvent[] cEvents,LocalDate cLocalDate,Integer cUniqueValue){
        eventsList = new BulletEvent[100];
        dateEvents = LocalDate.now();
        uniqueValue = 00000000;
    }

    //***Setters***
    public void setEvents(BulletEvent[] events) {
        this.eventsList = events;
    }

    public void setDateEvents(LocalDate dateEvents) {
        this.dateEvents = dateEvents;
    }

    public void setUniqueValue(Integer uniqueValue) {
        this.uniqueValue = uniqueValue;
    }


    //***Getters***
    public BulletEvent[] getEvents() {
        return eventsList;
    }

    public LocalDate getDateEvents() {
        return dateEvents;
    }

    public Integer getUniqueValue() {
        return uniqueValue;
    }

}
