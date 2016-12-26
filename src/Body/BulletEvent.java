package Body;

import javafx.scene.control.ChoiceBox;

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

    //typeChoice converter to  byte for type
    public static Byte convertTypeChoice(ChoiceBox<String> choiceBox){
        /*
        *0 = Task
        *1 = Note
        *2 = Event
        */
        Byte out = 0;
        if (choiceBox.getValue() == "■ : Task")
            out = 0;
        else if (choiceBox.getValue() == "• : Note ")
            out = 1;
        else if (choiceBox.getValue() == "O : Event")
            out = 2;

        return out;
    }

    //Byte converter to String
    public static String convertByte(Byte type){
        /*
        * ■ = Task
        * • = Note
        * O = Event
        */

        String out = new String();
        if (type.equals(0))
            out = "■ : ";
        else if (type.equals(1))
            out = "• : ";
        else if (type.equals(2))
            out = "O : ";

        return out;
    }
}

