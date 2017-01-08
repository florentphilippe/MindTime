package Main;

import Core.BulletEvent;
import Core.DayEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;


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
                editEvent(currentEvent.getName());
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

    //Editing Stage
    public static Stage editEvent(String editName) {

        //new Stage
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Edit Event");
        secondaryStage.setResizable(false);
        secondaryStage.initModality(Modality.APPLICATION_MODAL);

        //Top Content
        //Labels
        Label nameLabel = new Label("Name : ");
        GridPane.setConstraints(nameLabel,0,0);

        Label typeLabel = new Label("Type : ");
        GridPane.setConstraints(typeLabel,0,2);

        Label dateLabel = new Label("Date : ");
        GridPane.setConstraints(dateLabel,0,1);


        //ChoiceBox
        ChoiceBox<String> typeChoice = new ChoiceBox<>();
        typeChoice.getItems().addAll("■ : Task","• : Note ","O : Event");
        typeChoice.setValue("■ : Task");
        GridPane.setConstraints(typeChoice,1,2);

        //Inputs
        TextField nameInput = new TextField();
        nameInput.setText(editName);
        nameInput.setMinWidth(300);
        GridPane.setConstraints(nameInput,1,0);

        //DatePicker
        DatePicker dateSelection = new DatePicker(LocalDate.now());
        GridPane.setConstraints(dateSelection,1,1);


        //Main layout
        GridPane secondaryLayout = new GridPane();
        secondaryLayout.setPadding(new Insets(10,10,10,10));
        secondaryLayout.setVgap(15);
        secondaryLayout.setHgap(5);
        secondaryLayout.getChildren().addAll(nameLabel,nameInput,typeLabel,typeChoice,dateLabel,dateSelection);

        //Bottom Content
            //Buttons
            Button okButton = new Button("OK");
            okButton.setDefaultButton(true);
            okButton.setOnAction(e -> {
                boolean eventEdited = newEventWindow.okButtonAction(nameInput.getText(), BulletEvent.convertTypeChoice(typeChoice), newEventWindow.getDate(dateSelection));
                System.out.println("BulletEvent.counter = "+BulletEvent.getCounter()+"\n");
                secondaryStage.close();
            });

            Button cancelButton = new Button("Cancel");
            cancelButton.setOnAction(e -> secondaryStage.close());

            //Bottom layout
            HBox bottomLayout = new HBox(15);
            bottomLayout.setPadding(new Insets(20,20,20,20));
            bottomLayout.setAlignment(Pos.CENTER_RIGHT);
            bottomLayout.getChildren().addAll(okButton,cancelButton);

        //Root Layout
        BorderPane eventWindowRootLayout = new BorderPane();
        eventWindowRootLayout.setCenter(secondaryLayout);
        eventWindowRootLayout.setBottom(bottomLayout);


        //Root scene
        Scene rootScene = new Scene(eventWindowRootLayout,430,300);

        //Stage settings
        secondaryStage.setScene(rootScene);
        secondaryStage.show();

        return secondaryStage;
    }
}