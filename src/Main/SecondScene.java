package Main;

import Core.BulletEvent;
import Core.DayEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SecondScene {

    //Scene that appears when clicking on "Edit" on each DayEvent
    public static Scene SecondScene(DayEvent currentDayEvent){
        Label title = new Label();
        title.setText("\t"+DayEvent.nameConstructor(currentDayEvent));

        //Main Layout
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().add(title);

        for (BulletEvent currentEvent : currentDayEvent.getEventsList()){
            BorderPane borderPane = new BorderPane();
            Label eventName = new Label();
            Button deleteButton = new Button();

            eventName.setText(BulletEvent.convertByte(currentEvent.getType())+" "+currentEvent.getName());
            deleteButton.setText("Delete");
            borderPane.setLeft(eventName);
            borderPane.setRight(deleteButton);
            mainLayout.getChildren().add(borderPane);
        }

        return new Scene(mainLayout);
    }
}