package Main;

import Body.BulletEvent;
import FileManagement.Config;
import FileManagement.ObjectsManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

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

public static ArrayList<BulletEvent> bulletEvents = new ArrayList<BulletEvent>();
public static Config config = new Config();


    @Override
    public void start(Stage primaryStage) throws Exception{

        /*
        *Reading :
        *config.ser, objects.ser
        */
        //importing configuration
        config = Config.ConfigReader();
        System.out.println(config.toString());

        //Set BulletEvent counter from config
        BulletEvent.setCounter(config.getCounter());
        System.out.println("BulletEvent.counter = "+BulletEvent.getCounter()+"\n");

        //Importing BulletEvent list
        bulletEvents = ObjectsManager.ObjectListReader();
        System.out.println(bulletEvents.size()+" objects imported from objects.ser\n");
        //System.out.println(list.get(0).toString());




        //main Stage "window"
        window = primaryStage;
        window.setTitle("Mind Time");


        //Main window Title

        //Top Scene
            //Top menu
            Menu fileMenu = new Menu("File");       //Menu
            MenuItem newItem = new MenuItem("New Event...");        //Item
            newItem.setOnAction(e -> newEventWindow.newEvent());        //action item = secondary Window
            fileMenu.getItems().add(newItem);

            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().add(fileMenu);

            //Title Label
            dateTitle = new Label();
            yearTitle = new Label();
            yearTitle.setText(DateMethods.returnYear());
            dateTitle.setText(DateMethods.returnDate());

            //VBox title layout
            layoutTitle = new VBox(5);
            layoutTitle.setAlignment(Pos.CENTER);
            layoutTitle.getChildren().addAll(menuBar,dateTitle,yearTitle);

            //Menu Bar


        //Bottom Scene



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

