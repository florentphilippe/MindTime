package Main;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class newEventWindow {


    public static Stage newEvent(){
        //new Stage
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Create a new Event");

        //Labels
        Label nameLabel = new Label("Name : ");
        GridPane.setConstraints(nameLabel,0,0);

        Label typeLabel = new Label("Type : ");
        GridPane.setConstraints(typeLabel,0,1);

        //ChoiceBox
        ChoiceBox<String> typeChoice = new ChoiceBox<>();
        typeChoice.getItems().addAll("■ : Task","• : Note ","O : Event");
        typeChoice.setValue("■ : Task");
        GridPane.setConstraints(typeChoice,1,1);

        //Inputs
        TextField nameInput = new TextField();
        nameInput.setPromptText("New Event");
        nameInput.setMinWidth(300);
        GridPane.setConstraints(nameInput,1,0);


        //Main layout
        GridPane secondaryLayout = new GridPane();
        secondaryLayout.setPadding(new Insets(10,10,10,10));
        secondaryLayout.setVgap(15);
        secondaryLayout.setHgap(5);
        secondaryLayout.getChildren().addAll(nameLabel,nameInput,typeLabel,typeChoice);

        //Root scene
        Scene rootScene = new Scene(secondaryLayout,430,300);

        //Stage settings
        secondaryStage.setScene(rootScene);
        secondaryStage.show();

        return secondaryStage;
    }

    //typeChoice getter
    public static String getTypeChoice(ChoiceBox<String> choiceBox){
        return choiceBox.getValue();
    }
}
