package Body;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class BulletEvent {

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
    private StringProperty name;
    private Byte type;
    private LocalDate date;
    private Integer uniqueValue;

    public BulletEvent(){
        name = new SimpleStringProperty(this,"","Default Name");
        type = 0;
        date = LocalDate.now();
        uniqueValue = 00000000;
    }

    public BulletEvent(String cName,Byte cType,LocalDate cDate,Integer cUniqueValue){
        name = new SimpleStringProperty(this,cName,"Default Name");
        type = cType;
        date = cDate;
        uniqueValue = cUniqueValue;
    }


    //***Setters***
    public void setName(String name) {
        this.name.set(name);
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

    //***Getters***
    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty() {
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

    //toString Method
    public String toString() {
        return "Creation of a new BulletEvent Object :"+
                "\nName : "+this.getName()+
                "\nType : "+this.getType()+
                "\nDate : "+this.getDate()+
                "\nUniqueValue : "+this.getUniqueValue();

    }
}
