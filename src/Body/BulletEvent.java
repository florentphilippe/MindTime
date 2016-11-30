package Body;

import java.io.Serializable;
import java.time.LocalDate;


public class BulletEvent implements Serializable {

    /*
    * The main Object of the program inspired from bullet journal
    *
    * Here a link to access all the hidden components of the Keyboard :
    * http://www.symbole-clavier.com/
    * ■ = alt+254
    * O = O
    * • = alt+0149
    */


    //Initialization of the class values
    private String name;
    private Byte type;
    private LocalDate date;
    private Integer uniqueValue;
    private static Integer counter = 0;



    public BulletEvent() {
        name = "Default Name";
        type = 0;
        date = LocalDate.now();
        uniqueValue = 00000000;
        counter++;
    }

    public BulletEvent(String cName,Byte cType,LocalDate cDate,Integer cUniqueValue){
        name = cName;
        type = cType;
        date = cDate;
        uniqueValue = cUniqueValue;
        counter++;
    }


    //***Setters***
    public void setName(String name) {
        this.name = name;
    }

    public void setType(Byte sType){
        type = sType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUniqueValue(Integer uniqueValue) {
        this.uniqueValue = uniqueValue;
    }

    public static void setCounter(int counter) {
        BulletEvent.counter = counter;
    }



    //***Getters***
    public String getName() {
        return name;
    }

    public Byte getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getUniqueValue() {
        return uniqueValue;
    }

    public static int getCounter() {
        return counter;
    }



    //toString Method
    public String toString() {
        return "BulletEvent Object ;"+
                "\nName : "+this.getName()+
                "\nType : "+this.getType()+
                "\nDate : "+this.getDate()+
                "\nUniqueValue : "+this.getUniqueValue()+
                "\nCounter : "+getCounter()+"\n";
    }
}
