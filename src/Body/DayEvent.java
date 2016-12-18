package Body;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

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

                while (sourceList.get(iterator.nextIndex()).getUniqueValue() == sourceList.get(iterator.nextIndex()-1).getUniqueValue()){
                    processingList.add(iterator.next());
                    System.out.println("Processing loop");
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
                    while (sourceList.get(iterator.nextIndex()).getUniqueValue() == sourceList.get(iterator.nextIndex()-1).getUniqueValue()) {
                        processingList.add(iterator.next());
                    }
                    dayEvent.setEventsList(processingList);
                    finaList.add(dayEvent);
                }

                /*if (sourceList.get(iterator.nextIndex()).getUniqueValue() != sourceList.get(iterator.nextIndex() + 1).getUniqueValue()) {
                           finaList.add(dayEvent);
                 }
                */
            }
        }
    System.out.println("Number of loops : "+iterator.nextIndex());
    return finaList;
    }
}
