package Body;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

    public BulletEvent(){
        name = new SimpleStringProperty(this,"","Default Name");
        type = 0;
    }

    public BulletEvent(String cName,Byte cType){
        name = new SimpleStringProperty(this,cName,"Default Name");
        type = cType;
    }


    //***Setters***
    public void setName(String name) {
        this.name.set(name);
    }
    public void setType(Byte sType){
        type = sType;
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
}
