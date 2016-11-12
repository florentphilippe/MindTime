package Main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /*
    * The MindTime Project
    * v.0
    *
    * Started on the 12/11/2016
    */

//Initialization :
Label dateTitle,yearTitle;
VBox layoutTitle;
BorderPane mainLayout;
Scene mainScene;
Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{


        //main Stage "window"
        window = primaryStage;
        window.setTitle("Mind Time");


        //Main window Title

        //Title Label
        dateTitle = new Label();
        yearTitle = new Label();
        yearTitle.setText(DateMethods.returnYear());
        dateTitle.setText(DateMethods.returnDate());


        //VBox title layout
        layoutTitle = new VBox(2);
        layoutTitle.setAlignment(Pos.CENTER);
        layoutTitle.getChildren().addAll(dateTitle,yearTitle);

        //Principal BorderPane layout
        mainLayout = new BorderPane();
        mainLayout.setTop(layoutTitle);

        //Principal Scene
        mainScene = new Scene(mainLayout, 400, 900);


        //set up the main stage
        window.setScene(mainScene);
        window.show();
    }

}


