package Main;

import Core.BulletEvent;
import Core.DayEvent;
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
    * v. 1.0 (26/12/2016)
    *
    * Started on the 12/11/2016
    */

//Initialization :
Label dateTitle,yearTitle;
VBox layoutTitle;
static BorderPane mainLayout;
Scene mainScene;
public static Stage window;

public static ArrayList<BulletEvent> bulletEvents = new ArrayList<BulletEvent>();       //Contain all the BulletEvents from the file
public static ArrayList<DayEvent> dayEvents = new ArrayList<>();        //Contain all the DayEvents built from the bulletEvents list
public static Config config = new Config();


    @Override
    public void start(Stage primaryStage) throws Exception{

        /*
        *Reading :
        *config.ser, objects.ser
        *Converting bulletsEvent into a DayEvent List
        */
        //importing configuration
        config = Config.ConfigReader();
        System.out.println(config.toString());

        //Set BulletEvent counter from config
        BulletEvent.setCounter(config.getCounter());
        System.out.println("BulletEvent.counter = "+BulletEvent.getCounter()+"\n");

        //Importing BulletEvent list
        bulletEvents.addAll(ObjectsManager.ObjectListReader());
        System.out.println(bulletEvents.size()+" objects imported from objects.ser\n");

        //Sorting tests !!!!!!!!!!!!!!!!
        Integer aze = 0;
        while(aze < bulletEvents.size()){
            System.out.println("Element "+aze+" unique value = "+bulletEvents.get(aze).getUniqueValue());
            aze++;
        }
        System.out.println("");

        //Convert BulletEvent list into the DayEvent List
        if (!bulletEvents.isEmpty()) {
            dayEvents.addAll(ObjectsManager.automaticConstructor(bulletEvents));
            System.out.println("DayEvent list size : " + dayEvents.size());
            Integer i = 0;
            for (DayEvent dayEvent : dayEvents) {
                System.out.println("DayEvent n° " + i + " unique value : " + dayEvent.getUniqueValue());
                System.out.println("DayEvent n° " + i + " number of elements : " + dayEvent.getEventsList().size() + "\n");
                i++;
            }
        }


        //Main Stage "window"
        window = primaryStage;
        window.setTitle("Mind Time");
        window.setMaxWidth(450);


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

        //Center Scene
        ScrollPane centerPane = new ScrollPane(ObjectsManager.dayEventConstructor(dayEvents));
        centerPane.setFitToWidth(true);


        //Principal BorderPane layout
        mainLayout = new BorderPane();
        mainLayout.setTop(layoutTitle);
        mainLayout.setCenter(centerPane);

        //Principal Scene
        mainScene = new Scene(mainLayout, 400, 900);

        //set up the main stage
        window.setScene(mainScene);
        window.show();

    }
}

