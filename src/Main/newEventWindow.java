package Main;

import Core.BulletEvent;
import Core.DayEvent;
import FileManagement.Config;
import FileManagement.ObjectsManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import static Main.Main.bulletEvents;
import static Main.Main.config;
import static Main.Main.dayEvents;


public class newEventWindow {


    public static Stage newEvent() {
        //new Stage
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Create a new Event");
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
            nameInput.setPromptText("New Event");
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
                okButtonAction(nameInput.getText(), BulletEvent.convertTypeChoice(typeChoice), getDate(dateSelection));
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



    //DatePicker getter
    public static LocalDate getDate(DatePicker datePicker){
        return datePicker.getValue();
    }

    //LocalDate converter to uniqueValue
    public static Integer convertLocalDate(LocalDate localDate){
        StringBuilder builder = new StringBuilder();    //build the string

        builder.append(localDate.getYear());


        if (localDate.getMonthValue() == 1 || localDate.getMonthValue() == 2 || localDate.getMonthValue() == 3 || localDate.getMonthValue() == 4 || localDate.getMonthValue() == 5 ||       //must always have to number
                localDate.getMonthValue() == 6 || localDate.getMonthValue() == 7 || localDate.getMonthValue() == 8 || localDate.getMonthValue() == 9){
            builder.append(0);
            builder.append(localDate.getMonthValue());
        }else
            builder.append(localDate.getMonthValue());


        builder.append(localDate.getDayOfMonth());      //Always return 2 characters even for values in [0;9]


        return Integer.parseInt(builder.toString());
    }


    //OkButton Action
    public static void okButtonAction(String stringName,Byte type,LocalDate localDate){
        //Create new event and add it to the list
        BulletEvent newBulletEvent = new BulletEvent();
        newBulletEvent.setName(stringName);
        newBulletEvent.setType(type);
        newBulletEvent.setDate(localDate);
        newBulletEvent.setUniqueValue(convertLocalDate(localDate));
        System.out.println(newBulletEvent.toString());

        //Sorting and writing list to file
        //bulletEvents.add(newBulletEvent);
        System.out.println("list.lengh = "+bulletEvents.size()+" [Before]");
        ObjectsManager.BulletEventSorter(bulletEvents,newBulletEvent);
        System.out.println("list.lengh = "+bulletEvents.size()+" [After]\n");
        ObjectsManager.ObjectListWriter(bulletEvents);


        //Adding BulletEvent into DayEvent list
        dayEvents.clear();
        dayEvents.addAll(ObjectsManager.automaticConstructor(bulletEvents));
        Integer i = 0;
        for (DayEvent dayEvent : dayEvents) {
            System.out.println("DayEvent n° " + i + " unique value : " + dayEvent.getUniqueValue());
            System.out.println("DayEvent n° " + i + " number of elements : " + dayEvent.getEventsList().size() + "\n");
            i++;
        }


        /* This method doesn't working...
        ObjectsManager.dayEventAdder(Main.dayEvents,newBulletEvent);
        Integer i = 0;
        for (DayEvent dayEvent : dayEvents) {
            System.out.println("DayEvent n° " + i + " unique value : " + dayEvent.getUniqueValue());
            System.out.println("DayEvent n° " + i + " number of elements : " + dayEvent.getEventsList().size() + "\n");
            i++;
        }
        */

        //update config
        config.setCounter(BulletEvent.getCounter());
        Config.ConfigWriter(config);
        System.out.println(config.toString());
    }

}
