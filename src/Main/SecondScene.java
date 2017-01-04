package Main;

import Core.BulletEvent;
import Core.DayEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SecondScene {

    //Scene which appears when clicking on "Edit" on each DayEvent
    public static Scene secondScene(DayEvent currentDayEvent){
        Label title = new Label();

        title.setText("\t"+DayEvent.nameConstructor(currentDayEvent));

        //Root Layout
        BorderPane rootLayout = new BorderPane();
        rootLayout.setTop(Main.menuBar);

        //Content Layout
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20,15,5,15));
        mainLayout.getChildren().add(title);

        //Describe each BulletEvent of the DayEvent
        for (BulletEvent currentEvent : currentDayEvent.getEventsList()){
            HBox buttonBar = new HBox(10);
            BorderPane borderPane = new BorderPane();
            Label eventName = new Label();
            Button deleteButton = new Button();
            Button editButton = new Button();

            eventName.setText(BulletEvent.convertByte(currentEvent.getType())+" "+currentEvent.getName());

            //Delete Button
            deleteButton.setText("Delete");
            deleteButton.setOnAction(event -> {
                DayEvent.bulletDeleter(currentEvent);
                deleteButton.setText("Deleted");
                deleteButton.setDisable(true);
                });

            //Edit Button
            editButton.setText("Edit");
            editButton.setOnAction(event -> {
                newEventWindow.newEvent();
                editButton.setText("Edited");
                editButton.setDisable(true);
                DayEvent.bulletDeleter(currentEvent);
            });

            buttonBar.getChildren().addAll(editButton,deleteButton);
            borderPane.setLeft(eventName);
            borderPane.setRight(buttonBar);
            mainLayout.getChildren().add(borderPane);
        }

        rootLayout.setCenter(mainLayout);

        //Bottom
        Button returnButton = new Button();
        returnButton.setText("Return");
        returnButton.setOnAction(event -> Main.window.setScene(Main.mainScene()));

        HBox bottomLayout= new HBox(25);
        bottomLayout.getChildren().add(returnButton);
        bottomLayout.setAlignment(Pos.CENTER_RIGHT);
        bottomLayout.setPadding(new Insets(5,25,25,5));

        rootLayout.setBottom(bottomLayout);


        return new Scene(rootLayout,400,900);
    }
}