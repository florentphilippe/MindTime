package Main;

import Core.BulletEvent;
import Core.DayEvent;
import javafx.geometry.Insets;
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

        //Root Layout
        BorderPane rootLayout = new BorderPane();
        rootLayout.setTop(Main.menuBar);

        //Content Layout
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20,15,5,15));
        mainLayout.getChildren().add(title);

        for (BulletEvent currentEvent : currentDayEvent.getEventsList()){
            BorderPane borderPane = new BorderPane();
            Label eventName = new Label();
            Button deleteButton = new Button();

            eventName.setText(BulletEvent.convertByte(currentEvent.getType())+" "+currentEvent.getName());
            deleteButton.setText("Delete");
            deleteButton.setOnAction(event -> {
                DayEvent.bulletDeleter(currentEvent);
                deleteButton.setText("Deleted");
                deleteButton.setDisable(true);
                });

            borderPane.setLeft(eventName);
            borderPane.setRight(deleteButton);
            mainLayout.getChildren().add(borderPane);
        }

        rootLayout.setCenter(mainLayout);

        return new Scene(rootLayout,400,900);
    }
}